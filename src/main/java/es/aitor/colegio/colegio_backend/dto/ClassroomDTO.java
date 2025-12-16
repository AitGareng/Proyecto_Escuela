package es.aitor.colegio.colegio_backend.dto;

import java.util.List;

import lombok.Data;

@Data
public class ClassroomDTO {

    private Long id;
    private String name;
    private List<StudentDTO> students;
    //private String course;
    //private String stage;
   // private Integer year;


    
}
