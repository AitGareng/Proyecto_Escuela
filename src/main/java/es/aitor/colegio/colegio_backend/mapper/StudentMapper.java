package es.aitor.colegio.colegio_backend.mapper;

import es.aitor.colegio.colegio_backend.dto.StudentDTO;
import es.aitor.colegio.colegio_backend.model.Student;


public class StudentMapper {

    public static StudentDTO toDTO(Student student){
        StudentDTO dto = new StudentDTO();

        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setSurname(student.getSurname());
        dto.setEmail(student.getEmail());
        dto.setBirthDate(student.getBirthDate());
        dto.setDelegado(student.getDelegado());
        dto.setSex(student.getSex());
        dto.setAge(student.getAge());
        dto.setAverage_grade(student.getAverage_grade());

         if (student.getClassroom() != null) {
            dto.setClassroomId(student.getClassroom().getId());
            dto.setClassroomName(student.getClassroom().getName());
        }

        if (student.getLegalguardian() != null) {
            dto.setLegalGuardianId(student.getLegalguardian().getId());
            dto.setLegalGuardianName(student.getLegalguardian().getName());
        }

        return dto;
    }
}
    
    

