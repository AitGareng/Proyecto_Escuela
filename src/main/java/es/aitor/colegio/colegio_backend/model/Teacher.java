package es.aitor.colegio.colegio_backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    //@ManyToOne
    //@JoinColumn(name ="subject_id")
    //private Subject subject;
    
    @OneToMany(mappedBy = "teacher")
    @JsonManagedReference
    //@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="id")
    private List<Subject> subject;
    
    



    
}
