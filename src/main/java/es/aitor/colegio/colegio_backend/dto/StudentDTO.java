package es.aitor.colegio.colegio_backend.dto;

import java.sql.Date;
import java.util.List;

import lombok.Data;



@Data
public class StudentDTO {

    
    private Long id;
    private String name;
    //private String surname;
    //private String email;
    //private Date birthDate;
    private Boolean delegado;
    //private String sex;
    private int age;
    private Double average_grade;
    //private Integer average_age_delegate;

    private Long classroomId;
    private String classroomName;

    private List<NoteDTO> notes;
    //private Long student_id;
    //private Long subject_id;

    //private Long legalGuardianId;
    //private String legalGuardianName;
    
}
