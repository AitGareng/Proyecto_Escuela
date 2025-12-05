package es.aitor.colegio.colegio_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.aitor.colegio.colegio_backend.repository.StudentRepository;
import es.aitor.colegio.colegio_backend.model.Student;

@Service

public class StudentService {

    @Autowired
    public StudentRepository studentRepository;

    //GET
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }


    //POST
    public Student saveStudent (Student student){
        return studentRepository.save(student);
    }

    //PUT
    public Student updateStudent(long id, Student student){
        Student studentExisting = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Estudiante con " + id + " no encontrado"));
        studentExisting.setName(student.getName());
        studentExisting.setSurname(student.getSurname());
        studentExisting.setEmail(student.getEmail());
        studentExisting.setBirthDate(student.getBirthDate());
        studentExisting.setDelegado(student.getDelegado());
        studentExisting.setClassroom(student.getClassroom());
        return studentRepository.save(studentExisting);
    }

    //DELETE
    public void deleteStudent(long id, Student student){
        studentRepository.deleteById(id);
    }

    //GET sacar solo un estudiante por Id

    public Student getStudent (long id, Student student){
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Estudiante con id " + id + ", no encontrado"));
    }



    //GET obtener todos los estudiantes que hay en un clase

    //public List<Student> studentPerClass (Long id, Student student){

        //if (Student

        //}




    //}
    
    
}
