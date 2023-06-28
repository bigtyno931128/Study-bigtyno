package com.example.springloan.service;

import com.example.springloan.domain.Terms;
import com.example.springloan.dto.ApplicationDTO;
import com.example.springloan.dto.TermsDTO;
import com.example.springloan.repository.TermsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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


    @Override
    public List<TermsDTO.Response> getAll() {
        List<Terms> termsList = termsRepository.findAll();

        return termsList.stream().map(t -> modelMapper.map(t, TermsDTO.Response.class)).collect(Collectors.toList());
    }
}
