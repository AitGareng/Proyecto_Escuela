package es.aitor.colegio.colegio_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.aitor.colegio.colegio_backend.model.Subject;
import es.aitor.colegio.colegio_backend.repository.SubjectRepository;

@Service
public class SubjectService {

    @Autowired
    public SubjectRepository subjectRepository;

    // GET
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    // POST
    public Subject saveNewSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    // PUT
    public Subject updateSubject(long id, Subject subject) {
        Subject subjectExisting = subjectRepository.findById(id).orElseThrow(() -> new RuntimeException("Asignatura con " + id + " no encontrada"));
        subjectExisting.setName(subject.getName());
        subjectExisting.setDescription(subject.getDescription());
        subjectExisting.setTeacher(subject.getTeacher());
        subjectExisting.setClassroom(subject.getClassroom());

        return subjectRepository.save(subjectExisting);
    }

    // DELETE
    public void deleteSubject(long id, Subject subject) {
        subjectRepository.deleteById(id);
    }

    

}
