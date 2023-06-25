package com.example.springloan.service;

import com.example.springloan.dto.CounselDto;

public interface CounselService {
    CounselDto.Response create(CounselDto.Request request);

}
