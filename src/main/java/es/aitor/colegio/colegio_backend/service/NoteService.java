package es.aitor.colegio.colegio_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.aitor.colegio.colegio_backend.dto.NoteDTO;
import es.aitor.colegio.colegio_backend.mapper.NoteMapper;
import es.aitor.colegio.colegio_backend.model.Note;
import es.aitor.colegio.colegio_backend.repository.NoteRepository;

@Service

public class NoteService {

    @Autowired
    public NoteRepository noteRepository;

    

    //GET obtener notas por DTO
    public List<NoteDTO> getAllNotesByDto(){
        return noteRepository.findAll().stream().map(NoteMapper::toDTO).toList();
    }

    //GET
    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    //POST
    public Note createNote(Note note){
        return noteRepository.save(note);
    }

    //PUT
    public Note updateNote(long id, Note note){
        Note noteExisting = noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Nota con " + id + " no encontrada"));
        noteExisting.setValor(note.getValor());
        noteExisting.setStudent(note.getStudent());
        noteExisting.setSubject(note.getSubject());
        return noteRepository.save(noteExisting);
    }

    //DELETE
    public void deleteNote(long id, Note note){
        noteRepository.deleteById(id);
    }
    
}
