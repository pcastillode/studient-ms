package com.university.studient.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import java.time.LocalDate;

@Data
public class Studient {

    @Id
    private Long idStudient;

    @Column
    private Integer documentNumber;

    @Column
    private Long documentType;

    @Column
    private Integer age;

    @Column
    private Long idUniversity;

    @Column
    private Long idCivilStatus;

    @Column
    private Boolean status;

    @Column
    private LocalDate birthDate;

    @Column
    private String address;

    @Column
    private Long idGender;
}
