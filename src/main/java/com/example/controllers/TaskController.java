package com.example.controllers;

import com.example.dto.student.NewOrUpdateStudentDto;
import com.example.dto.student.StudentDto;
import com.example.dto.task.NewOrUpdateTaskDto;
import com.example.dto.task.TaskDto;
import com.example.services.StudentService;
import com.example.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @GetMapping({"/{id}"})
    public ResponseEntity<TaskDto> getTask(@PathVariable("id") Long id){
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PostMapping
    public ResponseEntity<TaskDto> addTask(@RequestBody NewOrUpdateTaskDto newTask){
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.addTask(newTask));
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<TaskDto> update(@PathVariable("id") Long id, NewOrUpdateTaskDto updatedTask){
        return ResponseEntity.accepted().body(taskService.update(id, updatedTask));
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        taskService.deleteTask(id);
        return ResponseEntity.accepted().build();
    }
}
