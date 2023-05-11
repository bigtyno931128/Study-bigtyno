package com.bigtyno.sns.service;

import com.bigtyno.sns.exception.ErrorCode;
import com.bigtyno.sns.exception.SimpleSnsApplicationException;
import com.bigtyno.sns.model.AlarmArgs;
import com.bigtyno.sns.model.AlarmType;
import com.bigtyno.sns.model.Comment;
import com.bigtyno.sns.model.Post;
import com.bigtyno.sns.model.entity.*;
import com.bigtyno.sns.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class PostService {

    private final PostEntityRepository postEntityRepository;
    private final UserEntityRepository userEntityRepository;
    private final LikeEntityRepository likeEntityRepository;
    private final CommentEntityRepository commentEntityRepository;
    private final AlarmEntityRepository alarmEntityRepository;

    @Transactional
    public void create(String title, String body, String userName) {

        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() ->
                new SimpleSnsApplicationException(ErrorCode.USER_NOT_FOUND,String.format("%s not founded", userName)));

        PostEntity saved = postEntityRepository.save(PostEntity.of(title, body , userEntity));

    }
    @Transactional
    public Post modify(Integer userId, Integer postId, String title, String body) {
        PostEntity postEntity = postEntityRepository.findById(postId).orElseThrow(() -> new SimpleSnsApplicationException(ErrorCode.POST_NOT_FOUND, String.format("postId is %d", postId)));
        if (!Objects.equals(postEntity.getUser().getId(), userId)) {
            throw new SimpleSnsApplicationException(ErrorCode.INVALID_PERMISSION, String.format("user %s has no permission with post %d", userId, postId));
        }

        postEntity.setTitle(title);
        postEntity.setBody(body);

        return Post.fromEntity(postEntityRepository.saveAndFlush(postEntity));
    }

    @Transactional
    public void delete(Integer userId, Integer postId) {
        PostEntity postEntity = postEntityRepository.findById(postId).orElseThrow(() -> new SimpleSnsApplicationException(ErrorCode.POST_NOT_FOUND, String.format("postId is %d", postId)));
        if (!Objects.equals(postEntity.getUser().getId(), userId)) {
            throw new SimpleSnsApplicationException(ErrorCode.INVALID_PERMISSION, String.format("user %s has no permission with post %d", userId, postId));
        }
//        likeEntityRepository.deleteAllByPost(postEntity);
//        commentEntityRepository.deleteAllByPost(postEntity);
        postEntityRepository.delete(postEntity);
    }
    // entity mapping
    public Page<Post> list(Pageable pageable) {
        return postEntityRepository.findAll(pageable).map(Post::fromEntity);
    }

    public Page<Post> my(Integer userId, Pageable pageable) {
        return postEntityRepository.findAllByUserId(userId, pageable).map(Post::fromEntity);
    }

    @Transactional
    public void like(Integer postId, String userName) {

        PostEntity postEntity = postEntityRepository.findById(postId).orElseThrow(()->
                new SimpleSnsApplicationException(ErrorCode.POST_NOT_FOUND, String.format("%s not founded", postId)));

        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(()->
                new SimpleSnsApplicationException(ErrorCode.USER_NOT_FOUND, String.format("%s not founded", userName)));

        // check liked - > throws
        likeEntityRepository.findByUserAndPost(userEntity, postEntity).ifPresent(it -> {
            throw new SimpleSnsApplicationException(ErrorCode.ALREADY_LIKED_POST,
                    String.format("username %s already like post %d", userName, postId));
        });

        likeEntityRepository.save(LikeEntity.of(postEntity, userEntity));

        alarmEntityRepository.save(AlarmEntity.of(postEntity.getUser(), AlarmType.NEW_LIKE_ON_POST,new AlarmArgs(userEntity.getId(),postEntity.getId())));
    }

    public int getLikeCount(Integer postId) {

        PostEntity postEntity = postEntityRepository.findById(postId).orElseThrow(()->
                new SimpleSnsApplicationException(ErrorCode.POST_NOT_FOUND, String.format("%s not founded", postId)));
        return likeEntityRepository.countByPost(postEntity);
    }

    @Transactional
    public void comment(Integer postId, String userName, String comment) {
        PostEntity postEntity = postEntityRepository.findById(postId).orElseThrow(() -> new SimpleSnsApplicationException(ErrorCode.POST_NOT_FOUND, String.format("postId is %d", postId)));
        UserEntity userEntity = userEntityRepository.findByUserName(userName)
                .orElseThrow(() -> new SimpleSnsApplicationException(ErrorCode.USER_NOT_FOUND, String.format("userName is %s", userName)));

        commentEntityRepository.save(CommentEntity.of(comment, postEntity, userEntity));

        alarmEntityRepository.save(AlarmEntity.of(postEntity.getUser(), AlarmType.NEW_COMMENT_ON_POST,new AlarmArgs(userEntity.getId(),postEntity.getId())));
    }

    public Page<Comment> getComments(Integer postId, Pageable pageable) {
        PostEntity postEntity = postEntityRepository.findById(postId).orElseThrow(() -> new SimpleSnsApplicationException(ErrorCode.POST_NOT_FOUND, String.format("postId is %d", postId)));
        return commentEntityRepository.findAllByPost(postEntity, pageable).map(Comment::fromEntity);
    }
}
