package com.example.springloan.dto;

import lombok.*;

import java.time.LocalDateTime;

public class CounselDto {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Request {

        private String name;
        private String cellPhone;
        private String email;
        private String memo;
        private String address;
        private String addressDetail;
        private String zipCode;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    public static class Response {
        private Long counselId;
        private String name;
        private String cellPhone;
        private String email;
        private String memo;
        private String address;
        private String addressDetail;
        private String zipCode;
        private LocalDateTime appliedAt;
        private LocalDateTime createAt;
        private LocalDateTime updateAt;
    }

}
