package es.aitor.colegio.colegio_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.aitor.colegio.colegio_backend.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByStudentId(Long studentId);

    

    
}
