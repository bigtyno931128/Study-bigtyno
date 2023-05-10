package com.bigtyno.sns.service;

import com.bigtyno.sns.exception.ErrorCode;
import com.bigtyno.sns.exception.SnsApplicationException;
import com.bigtyno.sns.model.entity.PostEntity;
import com.bigtyno.sns.model.entity.UserEntity;
import com.bigtyno.sns.repository.PostEntityRepository;
import com.bigtyno.sns.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostEntityRepository postEntityRepository;
    private final UserEntityRepository userEntityRepository;
    @Transactional
    public void create(String title, String body, String userName) {

        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() ->
                new SnsApplicationException(ErrorCode.USER_NOT_FOUND,String.format("%s not founded", userName)));

        PostEntity saved = postEntityRepository.save(PostEntity.of(title, body , userEntity));

    }
}
