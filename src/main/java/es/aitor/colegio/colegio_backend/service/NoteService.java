package es.aitor.colegio.colegio_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.aitor.colegio.colegio_backend.model.Note;
import es.aitor.colegio.colegio_backend.repository.NoteRespository;

@Service

public class NoteService {

    @Autowired
    public NoteRespository noteRepository;

    //GET
    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    //POST
    public Note createNote(Note note){
        return noteRepository.save(note);
    }

    //PUT
    public Note updateNote(Long id, Note note){
        Note noteExisting = noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Nota con " + id + " no encontrada"));
        noteExisting.setValor(noteExisting.getValor());
        return noteRepository.save(noteExisting);
    }

    //DELETE
    public void deleteNote(Long id, Note note){
        noteRepository.deleteById(id);
    }
    
}
