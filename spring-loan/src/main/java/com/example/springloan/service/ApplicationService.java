package com.example.springloan.service;



import com.example.springloan.dto.ApplicationDTO;
import com.example.springloan.dto.ApplicationDTO.Response;
import com.example.springloan.dto.ApplicationDTO.Request;

public interface ApplicationService {

    Response create(Request request);

    Response get(Long applicationId);

    Response update(Long applicationId, Request request);

    void delete(Long applicationId);

    Boolean acceptTerms(Long applicationId, ApplicationDTO.AcceptTerms request);
}
