package com.university.studient.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.university.studient.model.Studient;
import com.university.studient.service.StudientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.class)
public class TestStudientController {

    @InjectMocks
    private StudientController studientController;

    @Mock
    private StudientService studientService;

    @Test
    public void testCreateSuccessfully(){
        Studient studient = new Studient();
        studient.setIdStudient(1L);
        studient.setDocumentNumber(12345678);
        studient.setDocumentType(1L);
        studient.setAge(24);
        studient.setIdUniversity(1L);
        studient.setIdCivilStatus(1L);
        studient.setStatus(true);
        studient.setBirthDate(LocalDate.of(1996,12,20));
        studient.setAddress("Address 1");
        studient.setIdGender(1L);
        Mono<Studient> studientMono = Mono.just(studient);

        when(studientService.save(studient)).thenReturn(studientMono);
        assertThat(studientController.create(studient)).isEqualTo(studientMono);
    }

    @Test
    public void testGetAllSuccessfully(){
        Studient studient = new Studient();
        studient.setIdStudient(1L);
        studient.setDocumentNumber(12345678);
        studient.setDocumentType(1L);
        studient.setAge(24);
        studient.setIdUniversity(1L);
        studient.setIdCivilStatus(1L);
        studient.setStatus(true);
        studient.setBirthDate(LocalDate.of(1996,12,20));
        studient.setAddress("Address 1");
        studient.setIdGender(1L);
        Flux<Studient> studientFlux = Flux.just(studient);

        when(studientService.findAll()).thenReturn(studientFlux);
        assertThat(studientController.getAll()).isEqualTo(studientFlux);
    }

    @Test
    public void testGetByIdSuccessfully(){
        Studient studient = new Studient();
        studient.setIdStudient(1L);
        studient.setDocumentNumber(12345678);
        studient.setDocumentType(1L);
        studient.setAge(24);
        studient.setIdUniversity(1L);
        studient.setIdCivilStatus(1L);
        studient.setStatus(true);
        studient.setBirthDate(LocalDate.of(1996,12,20));
        studient.setAddress("Address 1");
        studient.setIdGender(1L);
        Mono<Studient> studientMono = Mono.just(studient);

        when(studientService.findById(1L)).thenReturn(studientMono);
        assertThat(studientController.getById(1L)).isEqualTo(studientMono);
    }

    @Test
    public void testUpdateSuccessfully(){
        Studient studient = new Studient();
        studient.setIdStudient(1L);

        Studient studientUpdate = new Studient();
        studientUpdate.setIdStudient(1L);
        studientUpdate.setDocumentNumber(12345678);
        studientUpdate.setDocumentType(1L);
        studientUpdate.setAge(24);
        studientUpdate.setIdUniversity(1L);
        studientUpdate.setIdCivilStatus(1L);
        studientUpdate.setStatus(true);
        studientUpdate.setBirthDate(LocalDate.of(1996,12,20));
        studientUpdate.setAddress("Address 1");
        studientUpdate.setIdGender(1L);

        Mono<Studient> studientMonoUpdate = Mono.just(studientUpdate);
        when(studientService.update(1L, studient)).thenReturn(studientMonoUpdate);

        assertThat(studientController.update(1L, studient)).isEqualTo(studientMonoUpdate);
    }

    @Test
    public void testDeleteSuccessfully(){
        studientController.delete(1L);
        verify(studientService, times(1)).delete(1L);
    }
}
