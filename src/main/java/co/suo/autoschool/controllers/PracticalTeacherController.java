package co.suo.autoschool.controllers;

import co.suo.autoschool.dto.PracticalTeacherDto;
import co.suo.autoschool.dto.creatingdto.PracticalTeacherCreatingDto;
import co.suo.autoschool.services.PracticalTeacherService;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/practicalTeachers")
public class PracticalTeacherController{

    private final PracticalTeacherService practicalTeacherService;
    public PracticalTeacherController(PracticalTeacherService practicalTeacherService) {this.practicalTeacherService = practicalTeacherService;}

    @GetMapping
    public ResponseEntity<Page<PracticalTeacherDto>> getAllPracticalTeachers(@PageableDefault Pageable pageable){
        Page<PracticalTeacherDto> teachers = practicalTeacherService.getAllPracticalTeachers(pageable);
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<PracticalTeacherDto> getPracticalTeacherById(@PathVariable Long id){
        PracticalTeacherDto teacher = practicalTeacherService.getPracticalTeacherById(id);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<PracticalTeacherDto> updateTeacher(@RequestBody PracticalTeacherCreatingDto teacherCreatingDto, @PathVariable Long id){
        practicalTeacherService.updatePracticalTeacherData(teacherCreatingDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PracticalTeacherDto> createTeacher(@Valid @RequestBody PracticalTeacherCreatingDto teacherCreatingDto){
            practicalTeacherService.createPracticalTeacher(teacherCreatingDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PracticalTeacherDto> deleteSPracticalTeacherCar(@PathVariable Long id){
        practicalTeacherService.deletePracticalTeacherById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
