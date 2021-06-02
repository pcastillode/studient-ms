package com.university.studient.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.university.studient.model.Studient;
import com.university.studient.repository.StudientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.class)
public class TestStudientServiceImpl {

    @InjectMocks
    private StudientServiceImpl studientService;

    @Mock
    private StudientRepository studientRepository;

    @Test
    public void testSaveSuccessfully(){
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

        when(studientRepository.save(studient)).thenReturn(studientMono);
        assertThat(studientService.save(studient)).isEqualTo(studientMono);
    }

    @Test
    public void testFindAllSuccessfully(){
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

        when(studientRepository.findAll()).thenReturn(studientFlux);
        assertThat(studientService.findAll()).isEqualTo(studientFlux);
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
        assertThat(studientRepository.findById(1L)).isEqualTo(studientMono);
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

        Mono<Studient> studientMono = Mono.just(studient);
        Mono<Studient> studientMonoUpdate = Mono.just(studientUpdate);
        when(studientRepository.findById(1L)).thenReturn(studientMono);
        studientService.update(1L, studient)
                .doOnNext(studientUpdated -> assertThat(studientUpdated).isEqualTo(studientUpdate));
    }

    @Test
    public void testDeleteSuccessfully(){
        studientService.delete(1L);
        verify(studientRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testExistById(){
        Mono<Boolean> response = Mono.just(Boolean.TRUE);
        when(studientRepository.existsById(1L)).thenReturn(response);
        assertThat(studientService.existById(1L)).isEqualTo(response);
    }
}
