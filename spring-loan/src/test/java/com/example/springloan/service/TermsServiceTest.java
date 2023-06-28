package com.example.springloan.service;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import com.example.springloan.domain.Terms;
import com.example.springloan.dto.TermsDTO;
import com.example.springloan.repository.TermsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;


@ExtendWith(MockitoExtension.class)
public class TermsServiceTest {
    @InjectMocks
    TermsServiceImpl termsService;

    @Mock
    private TermsRepository termsRepository;

    @Spy
    private ModelMapper moderMapper;

    @Test
    void Should_ReturnResponseOfNewTermsEntity_When_RequestTerms() {

        Terms entity = Terms.builder()
                .name("대출 이용 약관")
                .termsDetailUrl("https://abc=stss.add/ccccdd")
                .build();

        TermsDTO.Request request = TermsDTO.Request.builder()
                .name("대출 이용 약관")
                .termsDetailUrl("https://abc=stss.add/ccccdd")
                .build();

        when(termsRepository.save(ArgumentMatchers.any(Terms.class))).thenReturn(entity);

        TermsDTO.Response actual = termsService.create(request);

        assertThat(actual.getName()).isSameAs(entity.getName());
        assertThat(actual.getTermsDetailUrl()).isSameAs(entity.getTermsDetailUrl());

    }
}