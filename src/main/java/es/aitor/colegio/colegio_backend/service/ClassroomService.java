package es.aitor.colegio.colegio_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.aitor.colegio.colegio_backend.dto.ClassroomDTO;
import es.aitor.colegio.colegio_backend.mapper.ClassroomMapper;
import es.aitor.colegio.colegio_backend.model.Classroom;
import es.aitor.colegio.colegio_backend.model.Student;
import es.aitor.colegio.colegio_backend.repository.ClassroomRepository;
import es.aitor.colegio.colegio_backend.repository.StudentRepository;


@Service
public class ClassroomService {

    @Autowired
    public ClassroomRepository classroomRepository;

    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    public StudentRepository studentRepository;

    private Classroom convertToEntity(ClassroomDTO classroomDTO) {
        return modelMapper.map(classroomDTO, Classroom.class);
    }

    private ClassroomDTO convertToDto(Classroom classroom) {
        return modelMapper.map(classroom, ClassroomDTO.class);
    }

    //Get obtener Classroom por DTO
    public List<ClassroomDTO> getAllClassroomByDTO(){
        return classroomRepository.findAll()
            .stream()
            .map(ClassroomMapper::toDTO)
            .toList();
    }

    //GET obtener Classroom por DTO con students
    public List<ClassroomDTO> getAllClassroomByDTO2(){
        List<Classroom> classrooms = classroomRepository.findAll();
        List<ClassroomDTO> result = new ArrayList<>();

        for (Classroom classroom : classrooms){
            ClassroomDTO dto = ClassroomMapper.toDTO(classroom);
            result.add(dto);
        }
        return result;
        

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


    

    //PUT guardar maximo 3 alumnos por clase
    public String asignClassroomToStudent (Long id, ClassroomDTO classroomDTO ){
        Classroom classroomExisting = classroomRepository.findById(id).orElseThrow(() -> new RuntimeException("Aula con id  " + id + " no encontrada"));
        
        if(classroomExisting.getStudents().size()>=3){
            return "No se pudo agregar el alumno a esta aula, el aula ya tiene el numero maximo de alumnos permitidos";

        }else{
            //Classroom classroom = this.convertToEntity(classroomDTO);
            //classroom = classroomRepository.save(classroom);
            //ClassroomDTO savedClassroomDTO = this.convertToDto(classroom);
            classroomExisting.setName(classroomDTO.getName());
            classroomRepository.save(classroomExisting);

            Long studentId = classroomDTO.getStudents().get(0).getId();

            Student studentDb = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Alumno con id " + studentId + " no encontrado"));

            studentDb.setClassroom(classroomExisting);
            studentRepository.save(studentDb);

            return "Alumno agregado al aula correctamente";

        }
    }

    
    

}
