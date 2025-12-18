package es.aitor.colegio.colegio_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.aitor.colegio.colegio_backend.dto.SubjectDTO;
import es.aitor.colegio.colegio_backend.dto.TeacherDTO;
import es.aitor.colegio.colegio_backend.mapper.TeacherMapper;
import es.aitor.colegio.colegio_backend.model.Subject;
import es.aitor.colegio.colegio_backend.model.Teacher;
import es.aitor.colegio.colegio_backend.repository.SubjectRepository;
import es.aitor.colegio.colegio_backend.repository.TeacherRepository;

@Service
public class TeacherService {

    @Autowired //Para inyecy
    public TeacherRepository teacherRepository;

    @Autowired
    public SubjectRepository subjectRepository;

    @Autowired
    public ModelMapper modelMapper;

    // Get listar profesores por DTO
    public List<TeacherDTO> getAllTeachersByDTO() {
        List<Teacher> teachers = teacherRepository.findAll();
        List<TeacherDTO> result = new ArrayList<>();

        for (Teacher teacher : teachers) {
            TeacherDTO dto = TeacherMapper.toDTO(teacher);
            result.add(dto);
        }
        return result;
    }

    // GET Listar todos los Teacher con sus asignaturas
    public List<TeacherDTO> listarTeacherPorDTO() {
        List<Teacher> teachers = teacherRepository.findAll();
        List<TeacherDTO> result = new ArrayList<>();
        return result;
        // List<Teacher> teachers = teacherRepository.findAll();
        // List<TeacherDTO> result = new ArrayList<>();
        // return result;
    }

    // POST añadir un nuevo profesor (Sin asignatura asignada)
    public Teacher createNewTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    // HIDRIDO para Crear un nuevo profesor y guardar una asignatura existente.
    public TeacherDTO createTeacher(TeacherDTO teacherDTO) {

        Teacher teacher = TeacherMapper.toEntity(teacherDTO);
        Teacher savedTeacher = teacherRepository.save(teacher);

        if (teacherDTO.getSubjects() != null && !teacherDTO.getSubjects().isEmpty()) {
            List<Subject> subjects = new ArrayList<>();

            for (SubjectDTO sDto : teacherDTO.getSubjects()) {
                if (sDto.getId() == null) {
                    continue;
                }

                Subject subject = subjectRepository.findById(sDto.getId())
                        .orElseThrow(() -> new RuntimeException("Asignatura " + sDto.getId() + " no existe"));
                if (subjects.size() <= 2) {
                    subject.setTeacher(savedTeacher);
                    subjectRepository.save(subject);
                    subjects.add(subject);
                }
                savedTeacher.setSubjects(subjects);
            }
        }
        return TeacherMapper.toDTO(savedTeacher);
    }

    // Put
    public TeacherDTO updateTeacherByDTO(Long id, TeacherDTO teacherDTO) {
        Teacher teacherExisting = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor con " + id + " no encontrado"));
        teacherExisting.setName(teacherDTO.getName());
        // teacherExisting.setSurname(teacherDTO.getSurname());
        // teacherExisting.setEmail(teacherDTO.getEmail());
        // teacherExisting.setSubjects(teacherDTO.getSubjects());

        Teacher updated = teacherRepository.save(teacherExisting);
        return TeacherMapper.toDTO(updated);
    }

    // Detele
    public void deleteTeacher(long id, Teacher teacher) {
        teacherRepository.deleteById(id);
    }

    // Delete
    public void deleteTeacherByDTO(long id, TeacherDTO teacherDTO) {
        teacherRepository.deleteById(id);
    }

    // PUT
    public String updateAndVerifySubjectsTeacher(Long id, Teacher teacher) {
        Teacher teacherExisting = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor con id  " + id + " no encontrado"));

        if (teacherExisting.getSubjects().size() < 2) {
            teacherExisting.setSubjects(teacher.getSubjects());

            if (teacher.getSubjects() != null) {
                for (Subject subjects : teacher.getSubjects()) {

                    Subject subjectDb = subjectRepository.findById(subjects.getId()).orElseThrow(
                            () -> new RuntimeException("Asignatura con id " + subjects.getId() + " no encontrada"));
                    subjectDb.setTeacher(teacherExisting);
                    subjectRepository.save(subjectDb);
                }
            }

            teacherRepository.save(teacherExisting);
            return "Asignatura asociada correctamente al teacher";

        } else {
            return "No se puede guarda la asignatura al profesor";
        }

    }

    // POST Ivette whatsapp
    public TeacherDTO createTeacherDto(TeacherDTO teacherDTO) {
        Teacher teacher = this.convertToEntity(teacherDTO);
        teacher = teacherRepository.save(teacher);
        TeacherDTO savedTeacherDTO = this.convertToDto(teacher);
        return savedTeacherDTO;
    }

    private Teacher convertToEntity(TeacherDTO teacherDTO) {
        return modelMapper.map(teacherDTO, Teacher.class);
    }

    private TeacherDTO convertToDto(Teacher teacher) {
        return modelMapper.map(teacher, TeacherDTO.class);
    }

    

    // PUT con DTO asignar una asignatura a un profesor
    public String updateTeacherDto(Long id, TeacherDTO teacherDTO) {
        Teacher teacherExisting2 = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor con id  " + id + " no encontrado"));

        if (teacherExisting2.getSubjects().size() >= 2) {
            return "No se pudo agregar la asignatura, este profesor no puede tener mas asignaturas";

        } else {
            teacherExisting2.setName(teacherDTO.getName());
            teacherExisting2.setEmail(teacherDTO.getEmail());
            teacherRepository.save(teacherExisting2);

            Long subjectId = teacherDTO.getSubjects().get(0).getId();

            Subject subjectDb = subjectRepository.findById(subjectId)
                    .orElseThrow(() -> new RuntimeException("Asignatura con id " + subjectId + " no encontrada"));

            subjectDb.setTeacher(teacherExisting2);

            subjectRepository.save(subjectDb);

        }
        return "Asignatura guardada correctamente en el profesor " + id;

        // Teacher teacher = this.convertToEntity(teacherDTO);
        // teacher = teacherRepository.save(teacher);

    }

     // PUT con DTO asignar una asignatura a un profesor
    public TeacherDTO updateTeacherDto2(Long id, TeacherDTO teacherDTO) {
        Teacher teacherExisting2 = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor con id  " + id + " no encontrado"));

        if (teacherExisting2.getSubjects().size() >= 2) {
            throw new IllegalStateException("Este profesor ya tiene 2 asignaturas. No se pueden agregar mas.");

        } else {
            teacherExisting2.setName(teacherDTO.getName());
            teacherExisting2.setEmail(teacherDTO.getEmail());
            teacherRepository.save(teacherExisting2);

            Long subjectId = teacherDTO.getSubjects().get(0).getId();

            Subject subjectDb = subjectRepository.findById(subjectId)
                    .orElseThrow(() -> new RuntimeException("Asignatura con id " + subjectId + " no encontrada"));

            subjectDb.setTeacher(teacherExisting2);

            subjectRepository.save(subjectDb);
                
        }
        return TeacherMapper.toDTO(teacherExisting2);
    }

        // Teacher teacher = this.convertToEntity(teacherDTO);
        // teacher = teacherRepository.save(teacher);

     

}
