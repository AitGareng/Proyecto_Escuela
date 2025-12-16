package es.aitor.colegio.colegio_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class LegalGuardian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column
    public String name;

    @Column
    public String surname;

    @Column
    public Long phone;

    @Column
    public String email;

    @Column
    public String relationship;

    //@ManyToOne
    //@JoinColumn(name = "student_id")
    //private Student student;

}
