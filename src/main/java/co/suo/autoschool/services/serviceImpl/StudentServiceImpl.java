package co.suo.autoschool.services.serviceImpl;

import co.suo.autoschool.dto.CategoryDto;
import co.suo.autoschool.dto.StudentDto;
import co.suo.autoschool.dto.creatingdto.PracticalTeacherCreatingDto;
import co.suo.autoschool.dto.creatingdto.StudentCreatingDto;
import co.suo.autoschool.mapper.StudentMapper;
import co.suo.autoschool.model.*;
import co.suo.autoschool.repositoryInterface.CategoryRepository;
import co.suo.autoschool.repositoryInterface.CourseRepository;
import co.suo.autoschool.repositoryInterface.StudentRepository;
import co.suo.autoschool.services.StudentService;
import co.suo.autoschool.user.User;
import co.suo.autoschool.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Pageable;

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private StudentMapper studentMapper;
    private CourseRepository courseRepository;
    private CategoryRepository categoryRepository;
    private UserRepository userRepository;


    @Override
    @Transactional
    public Map<String, Object> getUserData(Principal email) {
        var studentDto = studentMapper.studentToStudentDto(studentRepository.findByUserId(userRepository.findByEmail(email.getName()).get().getId()));
        Map<String, Object> response = new HashMap<>();
        response.put("id", studentDto.id());
        response.put("name", studentDto.name());
        response.put("surname", studentDto.surname());
        response.put("age", studentDto.age());
        response.put("categories", studentDto.categories().stream().map(CategoryDto::category).collect(Collectors.toList()));
        return response;
    }

    @Override
    @Transactional
    public StudentDto createStudent(StudentCreatingDto studentCreatingDto, Long userId) {
        log.info("Student created");
        Student student = new Student();


        student.setName(studentCreatingDto.name());
        student.setSurname(studentCreatingDto.surname());
        student.setAge(studentCreatingDto.age());
        student.setUser(userRepository.findById(userId).orElseThrow());

        List<Category> categories = new ArrayList<>();
        studentCreatingDto.categoryIds().forEach(id -> categories.add(categoryRepository.findByIdAndActive(id, true).orElseThrow(() -> {
            throw new NoSuchElementException("Category not present by this id!!!");
        })));
        student.setCategories(categories);

        return studentMapper.studentToStudentDto(studentRepository.save(student));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<StudentDto> getAllStudents(Pageable pageable) {
        log.info("Gets students");
        return studentRepository.findAll(pageable).map(studentMapper::studentToStudentDto);
    }

    @Override
    @Transactional(readOnly = true)
    public StudentDto getStudentById(Long id) {
        log.info("Getting student");
        return studentMapper.studentToStudentDto(studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found by id: " + id)));
    }

    @Override
    @Transactional
    public StudentDto updateStudentData(StudentCreatingDto studentCreatingDto, Long id) {
        log.info("Students update");
        Optional<Student> tempStudent = studentRepository.findById(id);

        if (tempStudent.isPresent()) {
            Student student = tempStudent.get();

            return studentMapper.studentToStudentDto(studentRepository.save(updateStudentFromStudentCreatingDto(studentCreatingDto, student)));
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    @Transactional
    public void deleteCarById(Long id) {
        log.info("Student deleted, id: " + id);
        studentRepository.deleteById(id);
    }

    private Student updateStudentFromStudentCreatingDto(StudentCreatingDto studentCreatingDto, Student student) {
        if (studentCreatingDto == null) {
            return student;
        }


        if (studentCreatingDto.name() != null) {
            student.setName(studentCreatingDto.name());
        }
        if (studentCreatingDto.surname() != null) {
            student.setSurname(studentCreatingDto.surname());
        }
        if (studentCreatingDto.age() != null) {
            student.setAge(studentCreatingDto.age());
        }
//        if (studentCreatingDto.courseIds() != null) {
//            List<Course> courses = new ArrayList<>();
//            studentCreatingDto.courseIds().forEach(id -> courses.add(courseRepository.findByIdAndActive(id, true).orElseThrow(() -> {
//                throw new NoSuchElementException("Course not present by this id!!!");
//            })));
//            student.setCourses(courses);
//        }
        if (studentCreatingDto.categoryIds() != null) {
            List<Category> categories = new ArrayList<>();
            studentCreatingDto.categoryIds().forEach(id -> categories.add(categoryRepository.findByIdAndActive(id, true).orElseThrow(() -> {
                throw new NoSuchElementException("Category not present by this id!!!");
            })));
            student.setCategories(categories);
        }

        return student;
    }


}
