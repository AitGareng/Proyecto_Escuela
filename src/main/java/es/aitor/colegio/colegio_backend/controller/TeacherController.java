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
import org.springframework.web.bind.annotation.RestController;

import es.aitor.colegio.colegio_backend.model.Teacher;
import es.aitor.colegio.colegio_backend.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    public TeacherService teacherService;

    @GetMapping
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher){
        Teacher saveTeacher = teacherService.createTeacher(teacher);
        return saveTeacher;
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher){
        return teacherService.updateTeacher(id, teacher);
    }

    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable Long id){
    teacherService.deleteTeacher(id, null);
    return "Profesor con id, " + id + " , eliminado correctamente";
    }
    
}
