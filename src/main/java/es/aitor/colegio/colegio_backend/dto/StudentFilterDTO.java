package es.aitor.colegio.colegio_backend.dto;

import lombok.Data;

@Data
public class StudentFilterDTO {

    private String name;
    private String surname;
    private String sex;
    private Long ClassroomId;
    
}
