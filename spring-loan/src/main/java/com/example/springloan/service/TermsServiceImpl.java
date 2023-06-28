package com.example.springloan.service;

import com.example.springloan.domain.Terms;
import com.example.springloan.dto.TermsDTO;
import com.example.springloan.repository.TermsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TermsServiceImpl implements TermsService {

    private final TermsRepository termsRepository;
    private final ModelMapper modelMapper;

    @Override
    public TermsDTO.Response create(TermsDTO.Request request) {

        Terms terms = modelMapper.map(request, Terms.class);
        Terms created = termsRepository.save(terms);

        return modelMapper.map(created, TermsDTO.Response.class);
    }
}
