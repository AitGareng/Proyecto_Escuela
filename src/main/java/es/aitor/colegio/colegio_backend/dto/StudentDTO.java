package es.aitor.colegio.colegio_backend.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class StudentDTO {

    
    private Long id;
    private String name;
    private String surname;
    private String email;
    private Date birthDate;
    private Boolean delegado;
    private String sex;
    private int age;
    private Double average_grade;

    private Long classroomId;
    private String classroomName;

    private Long legalGuardianId;
    private String legalGuardianName;
    
}
