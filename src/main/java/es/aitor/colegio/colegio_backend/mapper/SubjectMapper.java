package es.aitor.colegio.colegio_backend.mapper;

import es.aitor.colegio.colegio_backend.dto.SubjectDTO;
import es.aitor.colegio.colegio_backend.model.Subject;

public class SubjectMapper {

    public static SubjectDTO toDTO(Subject subject){
        SubjectDTO dto = new SubjectDTO();

        dto.setId(subject.getId());
        dto.setName(subject.getName());
        dto.setDescription(subject.getDescription());


        //if(subject.getClassroom() !=null){
          //  dto.setClassroomId(subject.getClassroom().getId());
           // dto.setClassroomName(subject.getClassroom().getName());
        //}

        if(subject.getTeacher() != null){
           dto.setTeacherid(subject.getTeacher().getId());
            dto.setTeacherName(subject.getTeacher().getName());
        }

        return dto;
    }
    
}
