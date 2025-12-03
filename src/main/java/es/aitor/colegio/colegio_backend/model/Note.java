package es.aitor.colegio.colegio_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="notas")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    @Column
    private Double valor;

    @ManyToOne 
    @JoinColumn(name= "student_id")
    private Student student;
    
    @ManyToOne
    @JoinColumn(name ="subject_id")
    private Subject subject;
}
