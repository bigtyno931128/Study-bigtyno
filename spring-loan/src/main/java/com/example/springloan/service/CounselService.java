package com.example.springloan.service;

import com.example.springloan.dto.CounselDto;

public interface CounselService {
    CounselDto.Response create(CounselDto.Request request);
    CounselDto.Response get(Long counselId);
    CounselDto.Response update(Long counselId, CounselDto.Request request);

    void delete(Long counselId);

}
