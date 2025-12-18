package es.aitor.colegio.colegio_backend.mapper;

import es.aitor.colegio.colegio_backend.dto.NoteDTO;
import es.aitor.colegio.colegio_backend.model.Note;

public class NoteMapper {

    public static NoteDTO toDTO(Note note){
        NoteDTO dto = new NoteDTO();

        //dto.setId(note.getId());
        dto.setValor(note.getValor());

       // if(note.getStudent() !=null){
         //   dto.setStudentId(note.getStudent().getId());
           // dto.setStudentName(note.getStudent().getName());
        //}

        if(note.getSubject() !=null){
         // dto.setSubjectId(note.getSubject().getId());
        dto.setSubjectName(note.getSubject().getName());
        }

        return dto;


    }
    
    
}
