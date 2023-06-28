package com.example.springloan.service;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.springloan.domain.AcceptTerms;
import com.example.springloan.domain.Application;
import com.example.springloan.domain.Terms;
import com.example.springloan.dto.ApplicationDTO;
import com.example.springloan.exception.BaseException;
import com.example.springloan.repository.AcceptTermsRepository;
import com.example.springloan.repository.ApplicationRepository;
import com.example.springloan.repository.TermsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class ApplicationServiceTest {

    @InjectMocks
    ApplicationServiceImpl applicationService;
    @Mock
    private ApplicationRepository applicationRepository;

    @Mock
    private TermsRepository termsRepository;

    @Mock
    private AcceptTermsRepository acceptTermsRepository;
    @Spy
    private ModelMapper moderMapper;

    @Test
    void Should_ReturnResponseOfNewApplicationEntity_When_RequestCreateApplication() {

        Application entity = Application.builder()
                .name("Member Moon")
                .cellPhone("010-1234-5678")
                .email("asd@fgh.com")
                .hopeAmount(BigDecimal.valueOf(5000000))
                .build();

        ApplicationDTO.Request request = ApplicationDTO.Request.builder()
                .name("Member Moon")
                .cellPhone("010-1234-5678")
                .email("asd@fgh.com")
                .hopeAmount(BigDecimal.valueOf(5000000))
                .build();

        when(applicationRepository.save(ArgumentMatchers.any(Application.class))).thenReturn(entity);

        ApplicationDTO.Response actual = applicationService.create(request);

        assertThat(actual.getHopeAmount()).isSameAs(entity.getHopeAmount());
        assertThat(actual.getName()).isSameAs(entity.getName());
    }
    
    @Test
    void Should_ReturnResponseOfExistApplicationEntity_When_RequestExistApplicationId() {
        Long findId = 1L;

        Application entity = Application.builder()
                .applicationId(1L)
                .build();
        
        when(applicationRepository.findById(findId)).thenReturn(Optional.ofNullable(entity));

        ApplicationDTO.Response actual = applicationService.get(findId);
        
        assertThat(actual.getApplicationId()).isSameAs(findId);
    }

    @Test
    void Should_ReturnUpdatedResponseOfExistApplicationEntity_When_RequestUpdatedExistApplicationInfo() {
        Long findId = 1L;

        Application entity = Application.builder()
                .applicationId(1L)
                .hopeAmount(BigDecimal.valueOf(500000000))
                .build();

        ApplicationDTO.Request request = ApplicationDTO.Request.builder()
                .hopeAmount(BigDecimal.valueOf(5000000))
                .build();

        when(applicationRepository.save(ArgumentMatchers.any(Application.class))).thenReturn(entity);
        when(applicationRepository.findById(findId)).thenReturn(Optional.ofNullable(entity));

        ApplicationDTO.Response actual = applicationService.update(findId, request);
        assertThat(actual.getApplicationId()).isSameAs(findId);
        assertThat(actual.getHopeAmount()).isSameAs(request.getHopeAmount());
    }

    @Test
    void Should_DeletedApplicationEntity_When_RequestDeleteExistApplicationInfo(){

        Long targetId = 1L;

        Application entity = Application.builder()
                .applicationId(1L)
                .build();

        when(applicationRepository.save(ArgumentMatchers.any(Application.class))).thenReturn(entity);
        when(applicationRepository.findById(targetId)).thenReturn(Optional.ofNullable(entity));

        applicationService.delete(targetId);

        assertThat(entity.getIsDeleted()).isSameAs(true);
    }

    @Test
    void Should_AddAcceptTerms_When_RequestAcceptTermsOfApplication() {

        Terms entity1 = Terms.builder()
                .termsId(1L)
                .name("약관1")
                .termsDetailUrl("https://bifrtbo.asd")
                .build();


        Terms entity2 = Terms.builder()
                .termsId(2L)
                .name("약관2")
                .termsDetailUrl("https://bifrtbo.asd")
                .build();

        List<Long> acceptTerms = Arrays.asList(1L, 2L);

        ApplicationDTO.AcceptTerms request = ApplicationDTO.AcceptTerms.builder()
                .acceptTermsIds(acceptTerms)
                .build();

        Long findId =  1L;

        when(applicationRepository.findById(findId)).thenReturn(
                Optional.ofNullable(Application.builder().build())
        );

        when(termsRepository.findAll(Sort.by(Sort.Direction.ASC, "termsId"))).thenReturn(Arrays.asList(entity1, entity2));
        when(acceptTermsRepository.save(ArgumentMatchers.any(AcceptTerms.class))).thenReturn(AcceptTerms.builder().build());

        Boolean actual = applicationService.acceptTerms(findId, request);

        assertThat(actual).isTrue();
    }

    @Test
    void Should_ThrowException_When_RequestNotAllAcceptTermsOfApplication() {

        Terms entity1 = Terms.builder()
                .termsId(1L)
                .name("약관1")
                .termsDetailUrl("https://bifrtbo.asd")
                .build();


        Terms entity2 = Terms.builder()
                .termsId(2L)
                .name("약관2")
                .termsDetailUrl("https://bifrtbo.asd")
                .build();

        List<Long> acceptTerms = Arrays.asList(1L);

        ApplicationDTO.AcceptTerms request = ApplicationDTO.AcceptTerms.builder()
                .acceptTermsIds(acceptTerms)
                .build();

        Long findId =  1L;

        when(applicationRepository.findById(findId)).thenReturn(
                Optional.ofNullable(Application.builder().build())
        );

        when(termsRepository.findAll(Sort.by(Sort.Direction.ASC, "termsId"))).thenReturn(Arrays.asList(entity1, entity2));
        Assertions.assertThrows(BaseException.class, ()->applicationService.acceptTerms(findId, request));

    }

    @Test
    void Should_ThrowException_When_RequestNotExistAcceptTermsOfApplication() {

        Terms entity1 = Terms.builder()
                .termsId(1L)
                .name("약관1")
                .termsDetailUrl("https://bifrtbo.asd")
                .build();


        Terms entity2 = Terms.builder()
                .termsId(2L)
                .name("약관2")
                .termsDetailUrl("https://bifrtbo.asd")
                .build();

        List<Long> acceptTerms = Arrays.asList(1L,3L);

        ApplicationDTO.AcceptTerms request = ApplicationDTO.AcceptTerms.builder()
                .acceptTermsIds(acceptTerms)
                .build();

        Long findId =  1L;

        when(applicationRepository.findById(findId)).thenReturn(
                Optional.ofNullable(Application.builder().build())
        );

        when(termsRepository.findAll(Sort.by(Sort.Direction.ASC, "termsId"))).thenReturn(Arrays.asList(entity1, entity2));
        Assertions.assertThrows(BaseException.class, ()->applicationService.acceptTerms(findId, request));

    }
}