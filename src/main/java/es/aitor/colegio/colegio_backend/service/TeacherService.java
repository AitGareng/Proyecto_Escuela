package es.aitor.colegio.colegio_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.aitor.colegio.colegio_backend.model.Teacher;
import es.aitor.colegio.colegio_backend.repository.TeacherRepository;

@Service
public class TeacherService {

    @Autowired
    public TeacherRepository teacherRepository;

    // Get
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    // Post
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    // Put
    public Teacher updateTeacher(long id, Teacher teacher) {
        Teacher teacherExisting = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor con " + id + " no encontrado"));
        teacherExisting.setName(teacher.getName());
        teacherExisting.setSurname(teacher.getSurname());
        teacherExisting.setEmail(teacher.getEmail());
        return teacherRepository.save(teacherExisting);
    }

    // Detele
    public void deleteTeacher(long id, Teacher teacher) {
        teacherRepository.deleteById(id);
    }

}
