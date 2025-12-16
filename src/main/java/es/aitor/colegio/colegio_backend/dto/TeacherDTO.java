package es.aitor.colegio.colegio_backend.dto;

import java.util.List;

import es.aitor.colegio.colegio_backend.model.Subject;
import lombok.Data;


@Data
public class TeacherDTO {

    public Long id;
    public String name;
    //public String surname;
    public String email;
    public List<SubjectDTO> subjects;
    //private Long subjectId;
    //private String subjectName;
    



    
}
