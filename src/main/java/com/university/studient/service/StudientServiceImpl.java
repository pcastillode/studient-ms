package com.university.studient.service;

import com.university.studient.model.Studient;
import com.university.studient.repository.StudientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudientServiceImpl implements StudientService{

    @Autowired
    private StudientRepository studientRepository;

    @Override
    public Mono<Studient> save(Studient studient) {
        return studientRepository.save(studient);
    }

    @Override
    public Flux<Studient> findAll() {
        return studientRepository.findAll();
    }

    @Override
    public Mono<Studient> findById(Long id) {
        return studientRepository.findById(id);
    }

    @Override
    public Mono<Studient> update(Long id, Studient studientUpdate) {
        return studientRepository.findById(id).map(studient -> {
            studient.setIdStudient(studientUpdate.getIdStudient());
            studient.setDocumentNumber(studientUpdate.getDocumentNumber());
            studient.setDocumentType(studientUpdate.getDocumentType());
            studient.setAge(studientUpdate.getAge());
            studient.setIdUniversity(studientUpdate.getIdUniversity());
            studient.setIdCivilStatus(studientUpdate.getIdCivilStatus());
            studient.setStatus(studientUpdate.getStatus());
            studient.setBirthDate(studientUpdate.getBirthDate());
            studient.setAddress(studientUpdate.getAddress());
            studient.setIdGender(studientUpdate.getIdGender());
            return studient;
        }).flatMap(studient ->  studientRepository.save(studient));
    }

    @Override
    public Mono<Void> delete(Long id) {
        return studientRepository.deleteById(id);
    }

    @Override
    public Mono<Boolean> existById(Long id) {
        return studientRepository.existsById(id);
    }
}
