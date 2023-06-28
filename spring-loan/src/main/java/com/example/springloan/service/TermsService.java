package com.example.springloan.service;

import com.example.springloan.dto.TermsDTO.Response;
import com.example.springloan.dto.TermsDTO.Request;

public interface TermsService {
    Response create(Request request);
}
