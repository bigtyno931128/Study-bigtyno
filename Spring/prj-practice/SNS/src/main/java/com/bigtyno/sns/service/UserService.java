package com.bigtyno.sns.service;

import com.bigtyno.sns.exception.ErrorCode;
import com.bigtyno.sns.exception.SnsApplicationException;
import com.bigtyno.sns.model.User;
import com.bigtyno.sns.model.entity.UserEntity;
import com.bigtyno.sns.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityRepository userRepository;

    @Transactional
    public User join(String userName, String password) {
        // check the userId not exist
        userRepository.findByUserName(userName).ifPresent(it -> {
            throw new SnsApplicationException(ErrorCode.DUPLICATED_USER_NAME, String.format("userName is %s", userName));
        });

        UserEntity savedUser = userRepository.save(UserEntity.of(userName, password));
        return User.fromEntity(savedUser);
    }

//    public User join(String userName, String password) {
//
//        //회원가입하려는 userName으로 회웝가입된 user가 있는지
//        userEntityRepository.findByUserName(userName).ifPresent(it -> {
//            throw new SnsApplicationException(ErrorCode.DUPLICATED_USER_NAME,String.format("%s is duplicated", userName));
//        });
//
//        UserEntity userEntity = userEntityRepository.save(UserEntity.of(userName,password));
//
//        return User.fromEntity(userEntity);
//    }

    // TODO:implement
    public String login(String userName , String password) {

        // 회원가입 여부 체크
        UserEntity userEntity = userRepository.findByUserName(userName).orElseThrow( () -> new SnsApplicationException(ErrorCode.DUPLICATED_USER_NAME,""));

        // 비밀번호 체크
        if(!userEntity.getPassword().equals(password)) {
            throw new SnsApplicationException(ErrorCode.DUPLICATED_USER_NAME,"");
        }
        // 토큰 생성


        return "";
    }
}
