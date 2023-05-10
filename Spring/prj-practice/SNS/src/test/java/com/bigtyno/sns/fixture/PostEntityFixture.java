package com.bigtyno.sns.fixture;

import com.bigtyno.sns.model.User;
import com.bigtyno.sns.model.entity.PostEntity;
import com.bigtyno.sns.model.entity.UserEntity;

public class PostEntityFixture {

    public static PostEntity get(String userName, Integer postId, Integer userId) {
        UserEntity user = new UserEntity();
        user.setId(userId);
        user.setUserName(userName);


        PostEntity result = new PostEntity();
        result.setUser(user);
        result.setId(postId);

        return  result;
    }
}
