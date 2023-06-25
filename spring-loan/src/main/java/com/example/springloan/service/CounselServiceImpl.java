package com.example.springloan.service;

import com.example.springloan.domain.Counsel;
import com.example.springloan.dto.CounselDto;
import com.example.springloan.exception.BaseException;
import com.example.springloan.exception.ResultType;
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

    @Override
    public CounselDto.Response get(Long counselId) {

        Counsel counsel = counselRepository.findById(counselId).orElseThrow(()-> new BaseException(ResultType.SYSTEM_ERROR));

        return modelMapper.map(counsel, CounselDto.Response.class);
    }

    @Override
    public CounselDto.Response update(Long counselId, CounselDto.Request request) {

        Counsel counsel = counselRepository.findById(counselId).orElseThrow(()-> new BaseException(ResultType.SYSTEM_ERROR));

        counsel.setName(request.getName());
        counsel.setCellPhone(request.getCellPhone());
        counsel.setEmail(request.getEmail());
        counsel.setMemo(request.getMemo());
        counsel.setAddress(request.getAddress());
        counsel.setAddressDetail(request.getAddressDetail());
        counsel.setZipCode(request.getZipCode());

        counselRepository.save(counsel);

        return modelMapper.map(counsel, CounselDto.Response.class);
    }

    @Override
    public void delete(Long counselId) {
        Counsel counsel = counselRepository.findById(counselId).orElseThrow(()-> new BaseException(ResultType.SYSTEM_ERROR));

        counsel.setIsDeleted(true);

        counselRepository.save(counsel);
    }
}
