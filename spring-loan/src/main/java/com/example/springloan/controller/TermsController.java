package com.example.springloan.controller;

import com.example.springloan.dto.ResponseDTO;
import com.example.springloan.dto.TermsDTO;
import com.example.springloan.service.TermsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/terms")
public class TermsController extends AbstractController {

    private final TermsService termsService;

    @PostMapping
    public ResponseDTO<TermsDTO.Response> create(@RequestBody TermsDTO.Request request) {
        return ok(termsService.create(request));
    }
}