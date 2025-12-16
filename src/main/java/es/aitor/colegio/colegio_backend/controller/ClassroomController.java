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

import es.aitor.colegio.colegio_backend.dto.ClassroomDTO;
import es.aitor.colegio.colegio_backend.model.Classroom;
import es.aitor.colegio.colegio_backend.service.ClassroomService;

@RestController
@RequestMapping("/classroom")

public class ClassroomController {

    @Autowired
    public ClassroomService classroomService;

    @GetMapping
    public List<Classroom> getAllClassroom(){
        return classroomService.GetAllClassroom();
    }

    @PostMapping
    public Classroom createClassroom(@RequestBody Classroom classroom){
    return classroomService.createClassroom(classroom);
    }

    @PutMapping("/{id}")
    public Classroom updateClassroom(@PathVariable Long id, @RequestBody Classroom classroom){
        return classroomService.updateClassroom(id, classroom);
    }

    @DeleteMapping("/{id}")
    public String delteClassroom(@PathVariable Long id){
        classroomService.deleteClassroom(id, null);
        return "El aula con " + id + ", fue eliminada con exito";
    }

    @GetMapping("/dto")
    public List<ClassroomDTO> getAllClassroomByDto(){
        return classroomService.getAllClassroomByDTO();
    }

    @PutMapping("/prueba/{id}")
    public String asignClassroomToStudent(@PathVariable Long id, @RequestBody ClassroomDTO classroomDTO ){
        return classroomService.asignClassroomToStudent(id, classroomDTO);
    }

    @GetMapping("/prueba")
    public List<ClassroomDTO> GetAllClassroomsByDTO2(){
        return classroomService.getAllClassroomByDTO2();
    }


    //@GetMapping("/{id}/students")
    //public List<Student> getStudentsForClass(){
      //return classroomService.getStudentsByClassroomId(0);
    //}

    
}
