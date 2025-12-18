package es.aitor.colegio.colegio_backend.mapper;

import java.util.ArrayList;
import java.util.List;

import es.aitor.colegio.colegio_backend.dto.ClassroomDTO;
import es.aitor.colegio.colegio_backend.dto.StudentDTO;
import es.aitor.colegio.colegio_backend.model.Classroom;
import es.aitor.colegio.colegio_backend.model.Student;

public class ClassroomMapper {

    public static ClassroomDTO toDTO(Classroom classroom) {
        if (classroom == null)
            return null;

        ClassroomDTO dto = new ClassroomDTO();
        dto.setId(classroom.getId());
        dto.setName(classroom.getName());
        // dto.setCourse(classroom.getCourse());
        // dto.setStage(classroom.getStage());
        dto.setYear(classroom.getYear());

        List<StudentDTO> studentDTOs = new ArrayList<>();

        if (classroom.getStudents() != null) {
            for (Student student : classroom.getStudents()) {
                StudentDTO studentDTO = StudentMapper.toDTO(student);
                studentDTOs.add(studentDTO);
            }
        }
        dto.setStudents(studentDTOs);

        return dto;

    }

    public static Classroom toEntity(ClassroomDTO dto) {
        if (dto == null)
            return null;

        Classroom classroom = new Classroom();
        classroom.setId(dto.getId());
        classroom.setName(dto.getName());
       //classroom.setStudents(dto.getStudents());
        return classroom;

    }

}
