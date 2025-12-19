package es.aitor.colegio.colegio_backend.dto;

import java.util.List;

import lombok.Data;

@Data
public class TeacherSubjectsDTO {

    //public Long id;
    public String name;
    //public String surname;
    //public String email;
    public List<SubjectDTO> subjects;
    //public Long subjectId;
    //public String subjectName;
    public List<StudentDTO> students;



    
}
