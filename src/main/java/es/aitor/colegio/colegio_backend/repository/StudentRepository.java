package es.aitor.colegio.colegio_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.aitor.colegio.colegio_backend.model.Classroom;
import es.aitor.colegio.colegio_backend.model.Student;
import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByClassroomId(long classroomId);

    List<Student> findStudentByName(String name);

    List<Student> findStudentBySurname(String surname);

    List<Student> findStudentBySex(String sex);

    List<Student> findStudentByClassroom(Classroom classroom );

    List<Student> findStudentBySexAndAge(String sex, int age);

     int countByClassroomId(Long classroomId);

     Student findStudentByNameAndSurnameAndSex(String name, String surname, String sex);
}
