package es.aitor.colegio.colegio_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.aitor.colegio.colegio_backend.model.Classroom;
import es.aitor.colegio.colegio_backend.model.Student;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

   
    
}
