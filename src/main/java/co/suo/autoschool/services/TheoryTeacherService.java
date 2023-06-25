package co.suo.autoschool.services;


import co.suo.autoschool.dto.TheoryTeacherDto;
import co.suo.autoschool.model.TheoryTeacherModel;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@Service
public interface TheoryTeacherService {

    TheoryTeacherDto saveTheoryTeacher(TheoryTeacherModel theoryTeacher);

    Page<TheoryTeacherDto> getAllTeachers(Pageable pageable);

    TheoryTeacherDto getTeacherById(Long id);

    TheoryTeacherDto updateTheoryTeacherData(TheoryTeacherModel theoryTeacher, Long id);

    void deleteCourseById(Long id);

}
