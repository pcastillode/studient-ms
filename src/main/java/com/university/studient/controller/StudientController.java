package com.university.studient.controller;

import com.university.studient.entity.Studient;
import com.university.studient.service.StudientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/studient")
public class StudientController {

    @Autowired
    private StudientService studientService;

    @PostMapping()
    public Mono<Studient> create(@RequestBody Studient request){
        return studientService.save(request);
    }

    @GetMapping()
    public Flux<Studient> getAll() {
        return studientService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Studient> getById(@PathVariable("id") Long id) {
        return studientService.findById(id);
    }

    @PutMapping("/{id}")
    public Mono<Studient> update(@PathVariable ("id") Long id, @RequestBody Studient request){
        return studientService.findById(id).map(studient -> {
            studient.setIdStudient(request.getIdStudient());
            studient.setDocumentNumber(request.getDocumentNumber());
            studient.setDocumentType(request.getDocumentType());
            studient.setAge(request.getAge());
            studient.setIdUniversity(request.getIdUniversity());
            studient.setIdCivilStatus(request.getIdCivilStatus());
            studient.setStatus(request.getStatus());
            studient.setBirthDate(request.getBirthDate());
            studient.setAddress(request.getAddress());
            studient.setIdGender(request.getIdGender());
            return studient;
        }).flatMap(studient -> studientService.save(studient));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable ("id") Long id){
        return studientService.delete(id);
    }
}
