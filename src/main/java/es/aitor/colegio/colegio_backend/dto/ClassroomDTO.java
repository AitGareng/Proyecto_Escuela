package es.aitor.colegio.colegio_backend.dto;

import lombok.Data;

@Data
public class ClassroomDTO {

    private Long id;
    private String name;
    private String course;
    private String stage;
    private Integer year;


    
}
