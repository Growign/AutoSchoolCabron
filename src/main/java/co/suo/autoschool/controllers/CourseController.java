package co.suo.autoschool.controllers;


import co.suo.autoschool.dto.CourseDto;
import co.suo.autoschool.dto.creatingdto.CourseCreatingDto;
import co.suo.autoschool.model.Course;
import co.suo.autoschool.services.CourseService;
import co.suo.autoschool.services.serviceImpl.CourseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    public CourseController(CourseService courseService){this.courseService = courseService;}

    @GetMapping
    public ResponseEntity<Page<CourseDto>> getAllCourses(@PageableDefault Pageable pageable){
        Page<CourseDto> courses = courseService.getAllCourses(pageable);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Long id){
        CourseDto course = courseService.getCourseById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@Valid @RequestBody CourseCreatingDto courseCreatingDto){
        courseService.saveCourse(courseCreatingDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<CourseDto> updateCourse(@RequestBody CourseCreatingDto courseCreatingDto, @PathVariable Long id){
        courseService.updateCourseData(courseCreatingDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CourseDto> deleteCourse(@PathVariable Long id){
        courseService.deleteCourseById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
