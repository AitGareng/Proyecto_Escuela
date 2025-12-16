package es.aitor.colegio.colegio_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.aitor.colegio.colegio_backend.dto.SubjectDTO;
import es.aitor.colegio.colegio_backend.dto.TeacherDTO;
import es.aitor.colegio.colegio_backend.mapper.SubjectMapper;
import es.aitor.colegio.colegio_backend.mapper.TeacherMapper;
import es.aitor.colegio.colegio_backend.model.Subject;
import es.aitor.colegio.colegio_backend.model.Teacher;
import es.aitor.colegio.colegio_backend.repository.SubjectRepository;
import es.aitor.colegio.colegio_backend.repository.TeacherRepository;

@Service
public class SubjectService {

    @Autowired
    public SubjectRepository subjectRepository;
    public TeacherRepository teacherRepository;

    //Get obtener asignaturas por DTO
    public List<SubjectDTO> getAllSubjectsByDto(){
        return subjectRepository.findAll()
            .stream()
            .map(SubjectMapper::toDTO)
            .toList();
    }


        //POST
    public TeacherDTO asignedSubjectTeacher(Long teacherId, Subject subject){
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new RuntimeException("No se encuentra el profesor"));
        long currentCount = subjectRepository.countByTeacherId(teacherId);
        
        if ( currentCount >= 2){
            throw new RuntimeException("No se puede asignar la asignatura al profesor");
        }
        return TeacherMapper.toDTO(teacher);
        
    }


    // GET
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    // POST
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    // PUT
    public Subject updateSubject(long id, Subject subject) {
        Subject subjectExisting = subjectRepository.findById(id).orElseThrow(() -> new RuntimeException("Asignatura con " + id + " no encontrada"));
        subjectExisting.setName(subject.getName());
        subjectExisting.setDescription(subject.getDescription());
        subjectExisting.setTeacher(subject.getTeacher());
        //subjectExisting.setClassroom(subject.getClassroom());

        return subjectRepository.save(subjectExisting);
    }

    // DELETE
    public void deleteSubject(long id, Subject subject) {
        subjectRepository.deleteById(id);
    }

   



    

}
