package com.university.studient.controller;

import com.university.studient.model.Studient;
import com.university.studient.service.StudientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/studient")
@Tag(name = "Studient", description = "Studient Microservices API")
public class StudientController {

    @Autowired
    private StudientService studientService;

    @Operation(summary = "Add a new studient", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Studient Created",
                    content = @Content(schema = @Schema(implementation = Studient.class)))
    })
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Mono<Studient> create(@RequestBody Studient request){
        return studientService.save(request);
    }

    @Operation(summary = "Find all studients", description = "Returns all studients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Studient.class))))
    })
    @GetMapping(produces = "application/json")
    public Flux<Studient> getAll() {
        return studientService.findAll();
    }

    @Operation(summary = "Find studient by id", description = "Returns a single studient")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully operation",
                    content = @Content(schema = @Schema(implementation = Studient.class)))
    })
    @GetMapping(value = "/{id}", produces = "application/json")
    public Mono<Studient> getById(@PathVariable("id") Long id) {
        return studientService.findById(id);
    }

    @Operation(summary = "Update an existing studient", description = "Returns a single studient updated")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully operation",
                    content = @Content(schema = @Schema(implementation = Studient.class)))
    })
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public Mono<Studient> update(@PathVariable ("id") Long id, @RequestBody Studient request){
        return studientService.update(id, request);
    }

    @Operation(summary = "Delete an existing studient", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully operation")
    })
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable ("id") Long id){
        return studientService.delete(id);
    }
}
