package com.example.springloan.service;

import com.example.springloan.domain.AcceptTerms;
import com.example.springloan.domain.Application;
import com.example.springloan.domain.Counsel;
import com.example.springloan.domain.Terms;
import com.example.springloan.dto.ApplicationDTO;
import com.example.springloan.dto.ApplicationDTO.Response;
import com.example.springloan.dto.ApplicationDTO.Request;
import com.example.springloan.dto.CounselDto;
import com.example.springloan.exception.BaseException;
import com.example.springloan.exception.ResultType;
import com.example.springloan.repository.AcceptTermsRepository;
import com.example.springloan.repository.ApplicationRepository;
import com.example.springloan.repository.TermsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final TermsRepository termsRepository;
    private final AcceptTermsRepository acceptTermsRepository;
    private final ModelMapper modelMapper;

    @Override
    public Response create(Request request) {

        Application application = modelMapper.map(request, Application.class);
        application.setAppliedAt(LocalDateTime.now());

        Application applied = applicationRepository.save(application);

        return modelMapper.map(applied, Response.class);
    }

    @Override
    public Response get(Long applicationId) {
        Application application = applicationRepository.findById(applicationId).orElseThrow(()-> new BaseException(ResultType.SYSTEM_ERROR));

        return modelMapper.map(application, Response.class);
    }

    @Override
    public Response update(Long applicationId, Request request) {

        Application application = applicationRepository.findById(applicationId).orElseThrow(()-> new BaseException(ResultType.SYSTEM_ERROR));

        application.setName(request.getName());
        application.setCellPhone(request.getCellPhone());
        application.setEmail(request.getEmail());
        application.setHopeAmount(request.getHopeAmount());

        applicationRepository.save(application);

        return modelMapper.map(application, Response.class);
    }

    @Override
    public void delete(Long applicationId) {
        Application application = applicationRepository.findById(applicationId).orElseThrow(()-> new BaseException(ResultType.SYSTEM_ERROR));

        application.setIsDeleted(true);

        applicationRepository.save(application);
    }

    @Override
    public Boolean acceptTerms(Long applicationId, ApplicationDTO.AcceptTerms request) {

        applicationRepository.findById(applicationId).orElseThrow(()-> new BaseException(ResultType.SYSTEM_ERROR));

        List<Terms> termsList = termsRepository.findAll(Sort.by(Sort.Direction.ASC, "termsId"));

        // 약관이 하나라도 있어야함
        if (termsList.isEmpty()) {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        }

        // 제시한 약관과 고객이 동의한 약관 동일
        List<Long> acceptTermsIds = request.getAcceptTermsIds();
        if (termsList.size() != acceptTermsIds.size()){
            throw new BaseException(ResultType.SYSTEM_ERROR);
        }

        List<Long> collect = termsList.stream().map(Terms::getTermsId).collect(Collectors.toList());
        Collections.sort(collect);
        // 우리가 가진 약관이 아닐때
        if(!collect.contains(acceptTermsIds)) {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        }

        for(Long termsId: acceptTermsIds){
            AcceptTerms accepted = AcceptTerms.builder()
                    .termsId(termsId)
                    .applicationId(applicationId)
                    .build();

            acceptTermsRepository.save(accepted);
        }

        return true;
    }
}
