package es.aitor.colegio.colegio_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.aitor.colegio.colegio_backend.model.Classroom;
import es.aitor.colegio.colegio_backend.repository.ClassroomRepository;

@Service
public class ClassroomService {

    @Autowired
    public ClassroomRepository classroomRepository;

    // Get
    public List<Classroom> GetAllClassroom() {
        return classroomRepository.findAll();
    }

    // Post
    public Classroom saveClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    // Put
    public Classroom updateClassroom(Long id, Classroom classroom) {
        Classroom classroomExisting = classroomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clase con " + id + " no encontrada"));
        classroomExisting.setName(classroom.getName());
        classroomExisting.setCourse(classroom.getCourse());
        classroomExisting.setStage(classroom.getStage());
        return classroomRepository.save(classroomExisting);
    }

    // Delete
    public void deleteClassroom(Long id, Classroom classroom) {
        classroomRepository.deleteById(id);
    }

}
