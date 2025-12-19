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
import es.aitor.colegio.colegio_backend.dto.TeacherDTO;
import es.aitor.colegio.colegio_backend.model.Teacher;
import es.aitor.colegio.colegio_backend.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    public TeacherService teacherService;

    @GetMapping
    public List<TeacherDTO> getAllTeachersByDto(){
        return teacherService.getAllTeachersByDTO();
    }

    @PostMapping
    public Teacher createNewTeacher(@RequestBody Teacher teacher){
        Teacher  saveTeacher = teacherService.createNewTeacher(teacher);
        return saveTeacher;
    }
    
    @PostMapping("/CrearHibrido")//crear un nuevo Teacher y asignar una asignatura YA existente.
    public TeacherDTO createTeacher(@RequestBody TeacherDTO teacherDTO){
        TeacherDTO saveTeacher = teacherService.createTeacher(teacherDTO);
        return saveTeacher;
    }

    @PutMapping("/{id}")
    public TeacherDTO updateTeacher(@PathVariable Long id, @RequestBody TeacherDTO teacherDTO){
        return teacherService.updateTeacherByDTO(id, teacherDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable Long id){
    teacherService.deleteTeacher(id, null);
    return "Profesor con id, " + id + " , eliminado correctamente";
    }

    @DeleteMapping("/dto/{id}")
    public String deleteTeacherByDTO(@PathVariable Long id){
        teacherService.deleteTeacherByDTO(id, null);
        return "Profesor con id, " + id + " , eliminado correctamente";
    }
    
    @PutMapping("/agregarSubject/{id}") //no cambia teacher, solo agrega asignatura
    public String updateAndVerifySubjectsTeacher(@PathVariable Long id, @RequestBody Teacher teacher){
        return teacherService.updateAndVerifySubjectsTeacher(id, teacher);
    }

    @PostMapping("/CrearByDTO")
    public TeacherDTO createTeacherDTO(@RequestBody TeacherDTO teacherDTO){
        TeacherDTO teacherSavedDTO = teacherService.createTeacherDto(teacherDTO);
        return teacherSavedDTO;
    }

    @PutMapping("/updateByDTO/{id}")
    public String updateTeacherDto(@PathVariable Long id, @RequestBody TeacherDTO teacherDTO){
        return teacherService.updateTeacherDtoByString(id, teacherDTO);
    }

    @PutMapping("/updateTeacherbyDTO/{id}")
    public TeacherDTO updateTeacherDto(@PathVariable TeacherDTO teacherDTO){
        return teacherService.createTeacherDto(teacherDTO);
    }
}
