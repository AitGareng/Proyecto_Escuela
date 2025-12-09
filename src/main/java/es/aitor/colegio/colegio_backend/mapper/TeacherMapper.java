package es.aitor.colegio.colegio_backend.mapper;

import java.util.ArrayList;
import java.util.List;

import es.aitor.colegio.colegio_backend.dto.SubjectDTO;
import es.aitor.colegio.colegio_backend.dto.TeacherDTO;
import es.aitor.colegio.colegio_backend.model.Subject;
import es.aitor.colegio.colegio_backend.model.Teacher;


public class TeacherMapper {

    public static TeacherDTO toDTO(Teacher teacher){
        TeacherDTO dto = new TeacherDTO();

        dto.setId(teacher.getId());
        dto.setName(teacher.getName());
        dto.setSurname(teacher.getSurname());
        dto.setEmail(teacher.getEmail());
        
       List<SubjectDTO> subjectDTOs = new ArrayList<>();

        if(teacher.getSubject() !=null){
            for(Subject subject : teacher.getSubject()){
                SubjectDTO subjectDto = SubjectMapper.toDTO(subject);
                subjectDTOs.add(subjectDto);
            }
        }
            dto.setSubjects(subjectDTOs);

        return dto;
    }
    
}
