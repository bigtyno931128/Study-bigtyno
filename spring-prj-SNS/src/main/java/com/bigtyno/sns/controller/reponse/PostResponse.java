package com.bigtyno.sns.controller.reponse;

import com.bigtyno.sns.model.Post;
import com.bigtyno.sns.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private Integer id ;

    private String title;

    private String body;

    private UserResponse user;

    private Timestamp registeredAt;

    private Timestamp updatedAt;

    private Timestamp removedAt;

    public static PostResponse fromPost(Post post) {
        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getBody(),
                UserResponse.fromUser(post.getUser()),
                post.getRegisteredAt(),
                post.getUpdatedAt(),
                post.getRemovedAt()
        );
    }

}
