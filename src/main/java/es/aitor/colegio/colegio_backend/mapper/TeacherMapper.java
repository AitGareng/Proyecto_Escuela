package es.aitor.colegio.colegio_backend.mapper;

import java.util.ArrayList;
import java.util.List;

import es.aitor.colegio.colegio_backend.dto.StudentDTO;
import es.aitor.colegio.colegio_backend.dto.SubjectDTO;
import es.aitor.colegio.colegio_backend.dto.TeacherDTO;
import es.aitor.colegio.colegio_backend.dto.TeacherSubjectsDTO;
import es.aitor.colegio.colegio_backend.model.Subject;
import es.aitor.colegio.colegio_backend.model.Teacher;

public class TeacherMapper {

    public static TeacherDTO toDTO(Teacher teacher) {
        if (teacher == null)
            return null;

        TeacherDTO dto = new TeacherDTO();
        dto.setId(teacher.getId());
        dto.setName(teacher.getName());
        // dto.setSurname(teacher.getSurname());
        dto.setEmail(teacher.getEmail());

        List<SubjectDTO> subjectDTOs = new ArrayList<>();

        if (teacher.getSubjects() != null) {
            for (Subject subject : teacher.getSubjects()) {
                SubjectDTO subjectDto = SubjectMapper.toDTO(subject);
                subjectDTOs.add(subjectDto);
            }
        }
        dto.setSubjects(subjectDTOs);

        return dto;
    }

    public static Teacher toEntity(TeacherDTO dto) {
        if (dto == null)
            return null;

        Teacher teacher = new Teacher();
        teacher.setId(dto.getId());
        teacher.setName(dto.getName());
        // teacher.setSurname(dto.getSurname());
        teacher.setEmail(dto.getEmail());

        return teacher;
    }

    public static TeacherSubjectsDTO toDto(Teacher teacher) {
        if (teacher == null)
            return null;

        TeacherSubjectsDTO dto = new TeacherSubjectsDTO();
        dto.setName(teacher.getName());

        List<SubjectDTO> subjectsDTO = new ArrayList<>();
        if (teacher.getSubjects() != null) {
            for (Subject subject : teacher.getSubjects()) {

                SubjectDTO subjectDTO = SubjectMapper.toDTO(subject);
                subjectsDTO.add(subjectDTO);
            }
        }
        dto.setSubjects(subjectsDTO);

        return dto;

    }

}
