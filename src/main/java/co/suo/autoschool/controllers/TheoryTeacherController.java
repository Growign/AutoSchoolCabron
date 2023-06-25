package co.suo.autoschool.controllers;


import co.suo.autoschool.dto.TheoryTeacherDto;
import co.suo.autoschool.model.TheoryTeacherModel;
import co.suo.autoschool.services.TheoryTeacherService;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/TheoryTeacher")
public class TheoryTeacherController {

    private final TheoryTeacherService theoryTeacherService;
    public TheoryTeacherController(TheoryTeacherService theoryTeacherService){this.theoryTeacherService = theoryTeacherService;}

    @GetMapping
    public ResponseEntity<Page<TheoryTeacherDto>> getAllTeachers(@PageableDefault Pageable pageable){
        Page<TheoryTeacherDto> teachers = theoryTeacherService.getAllTeachers(pageable);
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<TheoryTeacherDto> getTeacherById(@PathVariable Long id){
        TheoryTeacherDto teacher = theoryTeacherService.getTeacherById(id);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TheoryTeacherDto> createTheoryTeacher(@Valid @RequestBody TheoryTeacherModel teacher){
        theoryTeacherService.saveTheoryTeacher(teacher);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<TheoryTeacherDto> updateTheoryTeacherData(@RequestBody TheoryTeacherModel teacher,@PathVariable Long id){
        theoryTeacherService.updateTheoryTeacherData(teacher, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TheoryTeacherDto> deleteTeacher(@PathVariable Long id){
        theoryTeacherService.deleteCourseById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
