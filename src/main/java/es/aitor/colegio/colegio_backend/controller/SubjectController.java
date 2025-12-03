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

import es.aitor.colegio.colegio_backend.model.Subject;
import es.aitor.colegio.colegio_backend.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    public SubjectService subjectService;

    @GetMapping
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @PostMapping
    public Subject createSubject(@RequestBody Subject subject){
        Subject saveSubject = subjectService.saveNewSubject(subject);
        return saveSubject;
    }

    @PutMapping("/{id}")
    public Subject updateSubject(@PathVariable Long id, @RequestBody Subject subject){
        return subjectService.updateSubject(id, subject);
    }

    @DeleteMapping("/{id}")
    public String deleteSubject(@PathVariable Long id){
        subjectService.deleteSubject(id, null);
        return "La asignatura con id " + id + ", fue eliminado correctamente";
    }

    
    
    
}
