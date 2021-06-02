package com.university.studient.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;

@Data
public class Studient {

    @Schema(description = "Unique identifier of the Studient", example = "1", required = true)
    @Id
    private Long idStudient;

    @Schema(description = "National identity document number", example = "47563829", required = true)
    private Integer documentNumber;

    @Schema(description = "Document type identifier", example = "1", required = true)
    private Long documentType;

    @Schema(description = "Studient's age", example = "23", required = true)
    private Integer age;

    @Schema(description = "University identifier", example = "2", required = true)
    private Long idUniversity;

    @Schema(description = "Civil Status identifier", example = "1", required = true)
    private Long idCivilStatus;

    @Schema(description = "Studient's status", example = "true", required = true)
    private Boolean status;

    @Schema(description = "Studient's birthdate", example = "1998-10-26", required = true)
    private LocalDate birthDate;

    @Schema(description = "Studient's address", example = "Av. Arequipa 712", required = true)
    private String address;

    @Schema(description = "Gender identifier", example = "1", required = true)
    private Long idGender;
}
