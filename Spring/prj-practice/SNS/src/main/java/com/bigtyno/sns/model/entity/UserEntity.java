package com.bigtyno.sns.model.entity;

import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Enabled
@Table
@Getter
@Setter
public class UserEntity {

    @Id
    private Integer id;

    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_password")
    private String password;
}
