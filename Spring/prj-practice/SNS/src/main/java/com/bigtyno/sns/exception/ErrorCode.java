package com.bigtyno.sns.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    //중복
    DUPLICATED_USER_NAME(HttpStatus.CONFLICT, "User name is duplicated"),
    // 회원가입 하지 않은 유저
    USER_NOT_FOUND(HttpStatus.NOT_FOUND,"User not founded"),
    //패스워드가 다를경우
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "Password is invalid"),
    //서버에러
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal_server_error");

    private HttpStatus status;
    private String message;
}
