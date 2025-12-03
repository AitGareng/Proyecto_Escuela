package es.aitor.colegio.colegio_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.aitor.colegio.colegio_backend.model.Note;
import es.aitor.colegio.colegio_backend.service.NoteService;

@RestController
@RequestMapping("/notas")
public class NoteController {

    @Autowired
    public NoteService noteService;

    @GetMapping
    public List<Note> getAllNotes(){
        return noteService.getAllNotes();
    }

    @PostMapping
    public Note createNote(@RequestBody Note note){
    Note noteSaved = noteService.createNote(note);
    return noteSaved;
    }

    @PutMapping("/{id}")
    public String updateNote(@PathVariable Long id, @RequestBody Note note){
        noteService.updateNote(id, note);
        return "Nota con id " + id + ", actualizada correctamente";
    }

    @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable Long id){
        noteService.deleteNote(id, null);
        return "La nota con id " + id + ", fue eliminada correctamente";
    }

    
    
}
