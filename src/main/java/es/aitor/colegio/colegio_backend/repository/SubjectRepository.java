
package es.aitor.colegio.colegio_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.aitor.colegio.colegio_backend.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{
    
}
