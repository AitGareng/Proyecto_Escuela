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

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    public StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        Student studentSaved = studentService.saveStudent(student);
        return studentSaved;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id, null);
        return "Estudiante eliminado";
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable long id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/byClassroom/{classroomId}")
    public List<Student> getStudentPerClassroom(@PathVariable long classroomId) {
        return studentService.getStudentByClassroomId(classroomId);
    }

    @GetMapping("/name/{name}")
    public List<Student> getStudentByName(@PathVariable String name) {
        return studentService.getStudentByName(name);
    }

    @GetMapping("/surname/{surname}")
    public List<Student> getStudentBySurname(@PathVariable String surname){
        return studentService.getStudentBySurname(surname);
    }

    @GetMapping("/sex/{sex}")
    public List<Student> getStudentBySex(@PathVariable String sex){
        return studentService.getStudentBySex(sex);
    }

    @GetMapping("/classroom/{classroom}")
    public List<Student> getStudentByClassroom(@PathVariable Classroom classroom){
        return studentService.getStudentsByClassroom(classroom);
    }

    @GetMapping("/sexandage/{sex}/age")
    public List<Student> getStudentBySexAndAge(@PathVariable String sex, int age){
        return studentService.getStudentBySexAndAge(sex, age);
    }

    @GetMapping("/filters/{name}/{surname}/{sex}")
    public Student getStudentByParameters(@PathVariable String name, @PathVariable String surname, @PathVariable String sex){
        return studentService.getStudentByParameters(name, surname, sex);
    }

}
