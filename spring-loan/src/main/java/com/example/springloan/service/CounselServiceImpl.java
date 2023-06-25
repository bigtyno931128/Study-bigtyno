package com.example.springloan.service;

import com.example.springloan.domain.Counsel;
import com.example.springloan.dto.CounselDto;
import com.example.springloan.repository.CounselRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CounselServiceImpl implements CounselService {

    private final ModelMapper modelMapper;
    private final CounselRepository counselRepository;

    @Override
    public CounselDto.Response create(CounselDto.Request request) {

        Counsel counsel = modelMapper.map(request, Counsel.class);
        counsel.setAppliedAt(LocalDateTime.now());

        Counsel created = counselRepository.save(counsel);

        return modelMapper.map(created, CounselDto.Response.class);
    }
}
