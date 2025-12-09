package es.aitor.colegio.colegio_backend.dto;

import lombok.Data;

@Data

public class LegalGuardianDTO {

    private Long id;
    private String name;
    private String surname;
    private Long phone;
    private String email;
    private String relationship;
    
}
