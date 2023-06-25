package co.suo.autoschool.services;


import co.suo.autoschool.dto.StudentDto;
import co.suo.autoschool.dto.creatingdto.StudentCreatingDto;
import co.suo.autoschool.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import java.security.Principal;
import java.util.Map;

@Service
public interface StudentService {
    Map<String, Object> getUserData(Principal email);

    StudentDto createStudent(StudentCreatingDto studentCreatingDto,Long userId);

    Page<StudentDto> getAllStudents(Pageable pageable);

    StudentDto getStudentById(Long id);

    StudentDto updateStudentData(StudentCreatingDto studentCreatingDto, Long id);

    void deleteCarById(Long id);

}
