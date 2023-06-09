package com.bigtyno.sns.repository;

import com.bigtyno.sns.model.entity.AlarmEntity;
import com.bigtyno.sns.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.DoubleStream;

@Repository
public interface AlarmEntityRepository extends JpaRepository<AlarmEntity, Integer > {

    //Page<AlarmEntity> findAllByUserId(Integer userId, Pageable pageable);

    Page<AlarmEntity> findAllByUser(UserEntity userEntity, Pageable pageable);
}
