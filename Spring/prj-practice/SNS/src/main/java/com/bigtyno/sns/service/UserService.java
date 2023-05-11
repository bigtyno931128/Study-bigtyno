package com.bigtyno.sns.service;

import com.bigtyno.sns.exception.ErrorCode;
import com.bigtyno.sns.exception.SimpleSnsApplicationException;
import com.bigtyno.sns.model.Alarm;
import com.bigtyno.sns.model.User;
import com.bigtyno.sns.model.entity.UserEntity;
import com.bigtyno.sns.repository.AlarmEntityRepository;
import com.bigtyno.sns.repository.UserEntityRepository;
import com.bigtyno.sns.util.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final AlarmEntityRepository alarmEntityRepository;


    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.token.expired-time-ms}")
    private Long expiredTimeMs;


    public User loadUserByUserName(String userName) {
        return userRepository.findByUserName(userName).map(User::fromEntity).orElseThrow(()->
                new SimpleSnsApplicationException(ErrorCode.USER_NOT_FOUND,String.format("%s not founded", userName)));
    }
    @Transactional
    public User join(String userName, String password) {
        // check the userId not exist
        userRepository.findByUserName(userName).ifPresent(it -> {
            throw new SimpleSnsApplicationException(ErrorCode.DUPLICATED_USER_NAME, String.format("userName is %s", userName));
        });

        UserEntity savedUser = userRepository.save(UserEntity.of(userName, encoder.encode(password)));
//        throw new RuntimeException();
        return User.fromEntity(savedUser);
    }

    // TODO:implement
    public String login(String userName , String password) {

        User savedUser = loadUserByUserName(userName);

        if (!encoder.matches(password, savedUser.getPassword())) {
            throw new SimpleSnsApplicationException(ErrorCode.INVALID_PASSWORD);
        }
        return JwtTokenUtils.generateAccessToken(userName, secretKey,expiredTimeMs);
    }

    public Page<Alarm> alarmList(String userName, Pageable pageable) {
        UserEntity userEntity = userRepository.findByUserName(userName).orElseThrow(() ->
                new SimpleSnsApplicationException(ErrorCode.USER_NOT_FOUND,String.format(
                        "%s not founded", userName)
                ));
        return alarmEntityRepository.findAllByUser(userEntity, pageable).map(Alarm::fromEntity);
    }
}
