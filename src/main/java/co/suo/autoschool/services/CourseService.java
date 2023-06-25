package co.suo.autoschool.services;

import co.suo.autoschool.dto.CourseDto;
import co.suo.autoschool.dto.creatingdto.CourseCreatingDto;
import co.suo.autoschool.model.Course;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

@Service
public interface CourseService {

    CourseDto saveCourse(CourseCreatingDto courseCreatingDto);

    Page<CourseDto> getAllCourses(Pageable pageable);

    CourseDto getCourseById(Long id);

    CourseDto updateCourseData(CourseCreatingDto courseCreatingDto, Long id);

    void deleteCourseById(Long id);

}
