package es.aitor.colegio.colegio_backend.mapper;

import java.util.ArrayList;
import java.util.List;

import es.aitor.colegio.colegio_backend.dto.NoteDTO;
import es.aitor.colegio.colegio_backend.dto.StudentDTO;
import es.aitor.colegio.colegio_backend.model.Note;
import es.aitor.colegio.colegio_backend.model.Student;

public class StudentMapper {

    public static StudentDTO toDTO(Student student) {

        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        // dto.setSurname(student.getSurname());
        // dto.setEmail(student.getEmail());
        // dto.setBirthDate(student.getBirthDate());
        dto.setDelegado(student.getDelegado());
        // dto.setSex(student.getSex());
        // dto.setAge(student.getAge());
        dto.setAverage_grade(student.getAverage_grade());


       List<NoteDTO> noteDTOs = new ArrayList<>();

        if (student.getNotes() != null) {
            for (Note note : student.getNotes()) {
                NoteDTO noteDTO = NoteMapper.toDTO(note);
                noteDTOs.add(noteDTO);
            }

        }
        dto.setNotes(noteDTOs);

        if (student.getClassroom() != null) {
            dto.setClassroomId(student.getClassroom().getId());
            dto.setClassroomName(student.getClassroom().getName());
        }
        return dto;
    }

    
}

    // if (student.getLegalguardian() != null) {
    // dto.setLegalGuardianId(student.getLegalguardian().getId());
    // dto.setLegalGuardianName(student.getLegalguardian().getName());
    // }


