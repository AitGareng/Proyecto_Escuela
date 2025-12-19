package es.aitor.colegio.colegio_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.aitor.colegio.colegio_backend.repository.NoteRepository;
import es.aitor.colegio.colegio_backend.repository.StudentRepository;
import es.aitor.colegio.colegio_backend.model.Classroom;
import es.aitor.colegio.colegio_backend.model.Note;
import es.aitor.colegio.colegio_backend.model.Student;
import es.aitor.colegio.colegio_backend.model.Teacher;
import es.aitor.colegio.colegio_backend.dto.NoteDTO;
import es.aitor.colegio.colegio_backend.dto.StudentDTO;
import es.aitor.colegio.colegio_backend.dto.StudentFilterDTO;
import es.aitor.colegio.colegio_backend.dto.TeacherDTO;
import es.aitor.colegio.colegio_backend.mapper.StudentMapper;

@Service
public class StudentService {

    @Autowired
    public StudentRepository studentRepository;
    @Autowired
    public NoteRepository noteRepository;
    @Autowired
    public ModelMapper modelMapper;

    // GET listar todos los estudiantes por DTO
    public List<StudentDTO> getAllStudentsByDTO() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> result = new ArrayList<>();

        for (Student student : students) {
            StudentDTO dto = StudentMapper.toDTO(student);
            result.add(dto);
        }
        return result;
    }

    // GET lista de todos los estudiantes
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // POST crear un nuevo estudiante
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // PUT actualizar un estudiante
    public Student updateStudent(long id, Student student) {
        Student studentExisting = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante con " + id + " no encontrado"));
        studentExisting.setName(student.getName());
        studentExisting.setSurname(student.getSurname());
        studentExisting.setEmail(student.getEmail());
        studentExisting.setBirthDate(student.getBirthDate());
        studentExisting.setDelegado(student.getDelegado());
        studentExisting.setClassroom(student.getClassroom());
        return studentRepository.save(studentExisting);
    }

    // DELETE borrar un estudiante
    public void deleteStudent(long id, Student student) {
        studentRepository.deleteById(id);
    }

    // GET sacar solo un estudiante por Id
    public Student getStudent(long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante con id " + id + ", no encontrado"));
    }

    // GET obtener todos los estudiantes que hay en un clase
    public List<Student> getStudentByClassroomId(Long classroomId) {
        return studentRepository.findByClassroomId(classroomId);
    }

    // GET obtener estudiantes por nombre
    public List<Student> getStudentByName(String name) {
        return studentRepository.findStudentByName(name);
    }

    // GET obtener estudiantes por apellido
    public List<Student> getStudentBySurname(String surname) {
        return studentRepository.findStudentBySurname(surname);
    }

    // GET obtener estudiantes por sexo
    public List<Student> getStudentBySex(String sex) {
        return studentRepository.findStudentBySex(sex);
    }

    // GET obtener estudiantes por clase
    public List<Student> getStudentsByClassroom(Classroom classroom) {
        return studentRepository.findStudentByClassroom(classroom);
    }

    // GET obtener estudiante por sexo y edad
    public List<Student> getStudentBySexAndAge(String sex, int age) {
        return studentRepository.findStudentBySexAndAge(sex, age);
    }

    // GET obtener estudiantes por varios filtros
    public Student getStudentByParameters(String name, String surname, String sex) {
        return studentRepository.findStudentByNameAndSurnameAndSex(name, surname, sex);
    }

    // GET Listar student mediante DTO /// HECHO CON STREAM NO USAR ///
    public List<StudentDTO> getAllStudentsByDTOStream() {
        return studentRepository.findAll().stream().map(StudentMapper::toDTO).toList();
    }

    // GET obtener lista estudiantes de 2025
    public List<StudentDTO> studentsOf2025() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> result = new ArrayList<>();

        for (Student student : students) {
            if (student.getClassroom() != null && student.getClassroom().getYear() == 2025) {

                double suma = 0;
                int contador = 0;

                if (student.getNotes() != null) {
                    for (Note note : student.getNotes()) {
                        if (note != null && note.getValor() != null) {
                            suma += note.getValor();
                            contador++;
                        }
                    }
                }
                Double media = (contador == 0) ? null : (suma / contador);
                student.setAverage_grade(media);

                StudentDTO dto = StudentMapper.toDTO(student);
                result.add(dto);
            }

        }
        return result;

    }

    // GET Edad promedio de delegados por curso
    public Double averageAgeDelegateByDTO() {
        List<Student> students = studentRepository.findAll();
        int suma = 0;
        int contador = 0;

        for (Student student : students) {
            if (student.getClassroom() != null && student.getClassroom().getYear() == 2025
                    && student.getDelegado() == true) {

                suma += student.getAge();
                contador++;

            }

        }
        return (contador == 0) ? null : (double) suma / contador;

    }

    // GET calculo de notas medias por año y genero
    public Double averageRatingsBySex(String sex) {
        List<Student> students = studentRepository.findAll();
        Double suma = 0.0;
        Double contador = 0.0;
        for (Student student : students) {

            if (student != null && student.getClassroom().getYear() == 2025
                    && student.getSex().equalsIgnoreCase(sex)) {

                if (student.getNotes() != null) {
                    for (Note note : student.getNotes()) {
                        if (note != null && note.getValor() != null) {
                            suma += note.getValor();
                            contador++;
                        }

                    }

                }
            }
        }
        return (contador == 0) ? null : (double) suma / contador;
    }

    // } else {
    // if (student != null && student.getClassroom().getYear() == 2025
    // && student.getSex().contentEquals("Femenino")) {

    // if (student.getNotes() != null) {
    // for (Note note : student.getNotes()) {
    // if (note != null && note.getValor() != null) {
    // suma += note.getValor();
    // contador++;
    // }

    // }
    // }

    // }

    // }

    // }
    // return (contador == 0) ? null : (double) suma / contador;

    //}

    /*
     * private Teacher convertToEntity(TeacherDTO teacherDTO) {
     * return modelMapper.map(teacherDTO, Teacher.class);
     * }
     * 
     * private TeacherDTO convertToDto(Teacher teacher) {
     * return modelMapper.map(teacher, TeacherDTO.class);
     * }
     */

    // =================
    // Con Chat GPT:
    // =================

    // GET filtro por nombre, apellido, sex o clase
    public List<StudentDTO> getStudentFiltered(String name, String surname, String sex, Long classroomId) {

        return studentRepository.findAll().stream().filter(student -> name == null
                || (student.getName() != null && student.getName().equalsIgnoreCase(name)))
                .filter(student -> surname == null
                        || (student.getSurname() != null && student.getSurname().equalsIgnoreCase(surname)))
                .filter(student -> sex == null
                        || (student.getSex() != null && student.getSex().equalsIgnoreCase(sex)))
                .filter(student -> classroomId == null
                        || (student.getClassroom() != null && student.getClassroom().getId().equals(classroomId)))
                .map(StudentMapper::toDTO).toList();

    }

    // POST recalcular nota media de los estudiantes para un año concreto
    // public List<StudentDTO> recalculateAverageForYear(Integer year) {}

    // POST filtro por nombre, apellido, sex o clase usando json
    public List<StudentDTO> getStudentFiltered(StudentFilterDTO filter) {
        String name = filter.getName();
        String surname = filter.getSurname();
        String sex = filter.getSex();
        Long classroomId = filter.getClassroomId();

        return studentRepository.findAll().stream()
                .filter(student -> name == null
                        || (student.getName() != null && student.getName().equalsIgnoreCase(name)))
                .filter(student -> surname == null
                        || (student.getSurname() != null && student.getSurname().equalsIgnoreCase(surname)))
                .filter(student -> sex == null
                        || (student.getSex() != null && student.getSex().equalsIgnoreCase(sex)))
                .filter(student -> classroomId == null
                        || (student.getClassroom() != null && student.getClassroom().getId().equals(classroomId)))
                .map(StudentMapper::toDTO)
                .toList();
    }

    // mismo metodo que arriba pero sin lambdas ni stream...
    /*
     * public List<StudentDTO> getStudentFiltered(String name, String surname,
     * String sex, Long classroomId) {
     * 
     * List<Student> students = studentRepository.findAll();
     * List<StudentDTO> result = new ArrayList<>();
     * 
     * for (Student student : students) {
     * 
     * // filtro name
     * if (name != null) {
     * if (student.getName() == null || !student.getName().equalsIgnoreCase(name)) {
     * continue; // no cumple -> pasa al siguiente estudiante
     * }
     * }
     * 
     * // filtro surname
     * if (surname != null) {
     * if (student.getSurname() == null ||
     * !student.getSurname().equalsIgnoreCase(surname)) {
     * continue;
     * }
     * }
     * 
     * // filtro sex
     * if (sex != null) {
     * if (student.getSex() == null || !student.getSex().equalsIgnoreCase(sex)) {
     * continue;
     * }
     * }
     * 
     * // filtro classroomId
     * if (classroomId != null) {
     * if (student.getClassroom() == null ||
     * !student.getClassroom().getId().equals(classroomId)) {
     * continue;
     * }
     * }
     * 
     * // si ha pasado todos los filtros, lo convierto a DTO
     * StudentDTO dto = StudentMapper.toDTO(student);
     * result.add(dto);
     * }
     * 
     * return result;
     * }
     */

}
