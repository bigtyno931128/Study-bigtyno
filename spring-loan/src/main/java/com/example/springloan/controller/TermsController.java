package com.example.springloan.controller;

import com.example.springloan.dto.ResponseDTO;
import com.example.springloan.dto.TermsDTO;
import com.example.springloan.service.TermsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/terms")
public class TermsController extends AbstractController {

    private final TermsService termsService;

    @PostMapping
    public ResponseDTO<TermsDTO.Response> create(@RequestBody TermsDTO.Request request) {
        return ok(termsService.create(request));
    }

    @GetMapping()
    public ResponseDTO<List<TermsDTO.Response>> getAll() {
        return ok(termsService.getAll());
    }
}