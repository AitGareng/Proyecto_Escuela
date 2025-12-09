package es.aitor.colegio.colegio_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.aitor.colegio.colegio_backend.dto.ClassroomDTO;
import es.aitor.colegio.colegio_backend.mapper.ClassroomMapper;
import es.aitor.colegio.colegio_backend.model.Classroom;
import es.aitor.colegio.colegio_backend.model.Student;
import es.aitor.colegio.colegio_backend.repository.ClassroomRepository;


@Service
public class ClassroomService {

    @Autowired
    public ClassroomRepository classroomRepository;

    //Get obtener Classroom por DTO
    public List<ClassroomDTO> getAllClassroomByDTO(){
        return classroomRepository.findAll()
            .stream()
            .map(ClassroomMapper::toDTO)
            .toList();
    }

    // Get
    public List<Classroom> GetAllClassroom() {
        return classroomRepository.findAll();
    }

    // Post
    public Classroom createClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    // Put
    public Classroom updateClassroom(long id, Classroom classroom) {
        Classroom classroomExisting = classroomRepository.findById(id).orElseThrow(() -> new RuntimeException("Clase con " + id + " no encontrada"));
        classroomExisting.setName(classroom.getName());
        classroomExisting.setCourse(classroom.getCourse());
        classroomExisting.setStage(classroom.getStage());
        return classroomRepository.save(classroomExisting);
    }

    // Delete
    public void deleteClassroom(long id, Classroom classroom) {
        classroomRepository.deleteById(id);
    }

    
    

}
