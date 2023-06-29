package com.example.springloan.dto;

import lombok.*;

import java.io.Serializable;

@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class FileDTO implements Serializable {

    private String name;
    private String url;
}
