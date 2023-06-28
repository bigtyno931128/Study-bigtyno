package com.example.springloan.service;

import com.example.springloan.dto.TermsDTO.Response;
import com.example.springloan.dto.TermsDTO.Request;

import java.util.List;

public interface TermsService {
    Response create(Request request);

    List<Response> getAll();
}
