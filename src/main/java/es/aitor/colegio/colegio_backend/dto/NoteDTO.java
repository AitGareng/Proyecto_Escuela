package es.aitor.colegio.colegio_backend.dto;

import lombok.Data;

@Data
public class NoteDTO {

    private Long id;
    private Double valor;

    private Long StudentId;
    private String StudentName;

    private Long SubjectId;
    private String SubjectName;





    
}
