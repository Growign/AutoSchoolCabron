package co.suo.autoschool.controllers;

import co.suo.autoschool.dto.StudentDto;
import co.suo.autoschool.dto.creatingdto.StudentCreatingDto;
import co.suo.autoschool.model.Student;
import co.suo.autoschool.services.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    public StudentController(StudentService studentService){this.studentService = studentService;}

    @GetMapping
    public ResponseEntity<Page<StudentDto>> getAllStudents(@PageableDefault Pageable pageable){
        Page<StudentDto> students = studentService.getAllStudents(pageable);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        StudentDto student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody StudentCreatingDto studentCreatingDto){
//            StudentDto studentDto = studentService.createStudent(studentCreatingDto);
//            return new ResponseEntity<>(studentDto, HttpStatus.CREATED);
//
//    }

    @PutMapping(value="/{id}")
    public ResponseEntity<StudentDto> updateStudentData(@RequestBody StudentCreatingDto studentCreatingDto, @PathVariable Long id){
        StudentDto studentDto = studentService.updateStudentData(studentCreatingDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<StudentDto> deleteStudent(@PathVariable Long id){
        studentService.deleteCarById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
