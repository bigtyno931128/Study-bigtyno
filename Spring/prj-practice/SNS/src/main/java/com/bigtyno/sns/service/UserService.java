package com.bigtyno.sns.service;

import com.bigtyno.sns.exception.ErrorCode;
import com.bigtyno.sns.exception.SnsApplicationException;
import com.bigtyno.sns.model.User;
import com.bigtyno.sns.model.entity.UserEntity;
import com.bigtyno.sns.repository.UserEntityRepository;
import com.bigtyno.sns.util.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.token.expired-time-ms")
    private Long expiredTimeMs;

    @Transactional
    public User join(String userName, String password) {
        // check the userId not exist
        userRepository.findByUserName(userName).ifPresent(it -> {
            throw new SnsApplicationException(ErrorCode.DUPLICATED_USER_NAME, String.format("userName is %s", userName));
        });

        UserEntity savedUser = userRepository.save(UserEntity.of(userName, encoder.encode(password)));
//        throw new RuntimeException();
        return User.fromEntity(savedUser);
    }

    // TODO:implement
    public String login(String userName , String password) {

        // 회원가입 여부 체크
        UserEntity userEntity = userRepository.findByUserName(userName).orElseThrow( () -> new SnsApplicationException(ErrorCode.USER_NOT_FOUND,String.format("%s not founded", userName)));

        // 비밀번호 체크
        if(encoder.matches(password, userEntity.getPassword())) {
            throw new SnsApplicationException(ErrorCode.INVALID_PASSWORD);
        }
        // 토큰 생성
        String token = JwtTokenUtils.generateToken(userName,secretKey,expiredTimeMs);

        return token;
    }
}
