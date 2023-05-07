package com.example.controllers;

import com.example.dto.task.NewOrUpdateTaskDto;
import com.example.dto.task.TaskDto;
import com.example.dto.teacher.NewOrUpdateTeacherDto;
import com.example.dto.teacher.TeacherDto;
import com.example.services.TaskService;
import com.example.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping({"/{id}"})
    public ResponseEntity<TeacherDto> getTeacher(@PathVariable("id") Long id){
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }

    @PostMapping
    public ResponseEntity<TeacherDto> addTeacher(@RequestBody NewOrUpdateTeacherDto newTeacher){
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.addTeacher(newTeacher));
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<TeacherDto> update(@PathVariable("id") Long id, NewOrUpdateTeacherDto updatedTeacher){
        return ResponseEntity.accepted().body(teacherService.update(id, updatedTeacher));
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.accepted().build();
    }
}
