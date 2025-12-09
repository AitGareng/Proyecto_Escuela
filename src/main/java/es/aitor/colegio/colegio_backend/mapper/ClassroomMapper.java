package es.aitor.colegio.colegio_backend.mapper;

import es.aitor.colegio.colegio_backend.dto.ClassroomDTO;
import es.aitor.colegio.colegio_backend.model.Classroom;

public class ClassroomMapper {

    public static ClassroomDTO toDTO(Classroom classroom){
        ClassroomDTO dto = new ClassroomDTO();

        dto.setId(classroom.getId());
        dto.setName(classroom.getName());
        dto.setCourse(classroom.getCourse());
        dto.setStage(classroom.getStage());
        dto.setYear(classroom.getYear());
        

        return dto;

    }
    
}
