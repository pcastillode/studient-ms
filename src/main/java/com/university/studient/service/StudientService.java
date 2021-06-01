package com.university.studient.service;

import com.university.studient.model.Studient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudientService {

    Mono<Studient> save(Studient studient);

    Flux<Studient> findAll();

    Mono<Studient> findById(Long id);

    Mono<Studient> update(Long id, Studient studientUpdate);

    Mono<Void> delete(Long id);

    Mono<Boolean> existById(Long id);
}
