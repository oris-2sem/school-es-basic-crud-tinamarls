package com.example.controllers;

import com.example.dto.student.NewOrUpdateStudentDto;
import com.example.dto.student.StudentDto;
import com.example.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping({"/{id}"})
    public ResponseEntity<StudentDto> getStudent(@PathVariable("id") Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> addStudent(@RequestBody NewOrUpdateStudentDto newStudent){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(newStudent));
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<StudentDto> update(@PathVariable("id") Long id, NewOrUpdateStudentDto updatedStudent){
        return ResponseEntity.accepted().body(studentService.update(id, updatedStudent));
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.accepted().build();
    }

}
