package com.example.springloan.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultType {

    SUCCESS("0000", "success"),
    //file
    NOT_EXIST("4001", "system error"),
    SYSTEM_ERROR("9000", "system error");

    private final String code;
    private final String desc;
}
