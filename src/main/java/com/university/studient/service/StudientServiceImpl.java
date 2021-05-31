package com.university.studient.service;

import com.university.studient.entity.Studient;
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
    public Mono<Void> delete(Long id) {
        return studientRepository.deleteById(id);
    }

    @Override
    public Mono<Boolean> existById(Long id) {
        return studientRepository.existsById(id);
    }
}
