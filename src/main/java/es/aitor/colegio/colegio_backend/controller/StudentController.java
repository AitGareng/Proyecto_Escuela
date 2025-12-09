package es.aitor.colegio.colegio_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.aitor.colegio.colegio_backend.service.StudentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import es.aitor.colegio.colegio_backend.model.Classroom;
import es.aitor.colegio.colegio_backend.model.Student;
import es.aitor.colegio.colegio_backend.dto.StudentDTO;
import es.aitor.colegio.colegio_backend.dto.StudentFilterDTO;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping //obtener todos los student
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping //crear un nuevo student
    public Student createStudent(@RequestBody Student student) {
        Student studentSaved = studentService.createStudent(student);
        return studentSaved;
    }

    @PutMapping("/{id}") //actualizar student
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}") //borrar student
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id, null);
        return "Estudiante eliminado";
    }

    @PostMapping("/filterjson") //filtrar student por json
    public List<StudentDTO> getStudentsFiltered(@RequestBody StudentFilterDTO filter) {
        return studentService.getStudentFiltered(filter);
    }

    //@PostMapping("/average/2025") //
    //public List<StudentDTO> recalculateAverage2025() {
        //return studentService.recalculateAverageForYear(2025);
    //}

    @GetMapping("/{id}") //filtrar student por id
    public Student getStudent(@PathVariable long id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/byClassroom/{classroomId}") //filtrar students por clase
    public List<Student> getStudentPerClassroom(@PathVariable long classroomId) {
        return studentService.getStudentByClassroomId(classroomId);
    }

    @GetMapping("/name/{name}") //filtrar students por nombre
    public List<Student> getStudentByName(@PathVariable String name) {
        return studentService.getStudentByName(name);
    }

    @GetMapping("/surname/{surname}") //filtrar students por apellido
    public List<Student> getStudentBySurname(@PathVariable String surname) {
        return studentService.getStudentBySurname(surname);
    }

    @GetMapping("/sex/{sex}") //filtrar students por sex
    public List<Student> getStudentBySex(@PathVariable String sex) {
        return studentService.getStudentBySex(sex);
    }

    @GetMapping("/classroom/{classroom}") //filtrar students por clase(duplicado)
    public List<Student> getStudentByClassroom(@PathVariable Classroom classroom) {
        return studentService.getStudentsByClassroom(classroom);
    }

    @GetMapping("/sexandage/{sex}/age")
    public List<Student> getStudentBySexAndAge(@PathVariable String sex, int age) {
        return studentService.getStudentBySexAndAge(sex, age);
    }

    @GetMapping("/filters/{name}/{surname}/{sex}")
    public Student getStudentByParameters(@PathVariable String name, @PathVariable String surname,
            @PathVariable String sex) {
        return studentService.getStudentByParameters(name, surname, sex);
    }

    @GetMapping("/dto") //obtener todos los students por dto
    public List<StudentDTO> getAllStudentsByDTO() {
        return studentService.getAllStudentsByDTO();
    }

    @GetMapping("/filter") //filtrar students por parametros
    public List<StudentDTO> getStudentsFiltered(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String sex,
            @RequestParam(required = false) Long classroomId) {

        return studentService.getStudentFiltered(name, surname, sex, classroomId);
    }

}
