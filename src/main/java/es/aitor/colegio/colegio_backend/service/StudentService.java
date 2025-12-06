package es.aitor.colegio.colegio_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.aitor.colegio.colegio_backend.repository.ClassroomRepository;
import es.aitor.colegio.colegio_backend.repository.StudentRepository;
import es.aitor.colegio.colegio_backend.model.Classroom;
import es.aitor.colegio.colegio_backend.model.Student;

@Service

public class StudentService {

    @Autowired
    public StudentRepository studentRepository;
    public ClassroomRepository classroomRepository;

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
    public Student getStudent (long id){
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Estudiante con id " + id + ", no encontrado"));
    }

    //GET obtener todos los estudiantes que hay en un clase
    public List<Student> getStudentByClassroomId (Long classroomId){
    return studentRepository.findByClassroomId(classroomId);
    }

    //GET obtener estudiantes por nombre
    public List<Student> getStudentByName(String name){
        return studentRepository.findStudentByName(name);
    }

    //GET obtener estudiantes por apellido
    public List<Student> getStudentBySurname(String surname){
        return studentRepository.findStudentBySurname(surname);
    }

    //GET obtener estudiantes por sexo
    public List<Student> getStudentBySex(String sex){
        return studentRepository.findStudentBySex(sex);
    }

    //GET obtener estudiantes por clase
    public List<Student> getStudentsByClassroom(Classroom classroom){
        return studentRepository.findStudentByClassroom(classroom);
    }

    //GET obtener estudiante por sexo y edad
    public List<Student> getStudentBySexAndAge(String sex, int age){
        return studentRepository.findStudentBySexAndAge(sex, age);
        } 

        //POST Guardar maximo 15 estudiantes por aula
    public Student getStudentsByClassroomId(long classroomId, Student student){
        int count = studentRepository.countByClassroomId(classroomId);
        if(count>=3){
            throw new IllegalStateException("La clase llego al maximo de alumnos permitidos");
        }
        Classroom classroom = classroomRepository.findById(classroomId).orElseThrow(() -> new RuntimeException("Clase no encontrada"));
        student.setClassroom(classroom);
        return studentRepository.save(student);
    }
     //   Classroom classroom = classroomRepository.findById(classroomId).orElseThrow(() -> new RuntimeException("Clase no encontrada"));
       // return classroom.getStudents();
    //}

    //GET obtener estudiantes por varios filtros
    public Student getStudentByParameters(String name, String surname, String sex){
        return studentRepository.findStudentByNameAndSurnameAndSex(name, surname, sex);

    }
    
}
    
