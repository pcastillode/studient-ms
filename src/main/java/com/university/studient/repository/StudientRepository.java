package com.university.studient.repository;

import com.university.studient.model.Studient;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface StudientRepository extends ReactiveCrudRepository<Studient, Long> {
}
