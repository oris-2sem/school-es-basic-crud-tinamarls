package com.example.controllers;

import com.example.dto.student.NewOrUpdateStudentDto;
import com.example.dto.student.StudentDto;
import com.example.dto.studyClass.NewOrUpdateStudyClassDto;
import com.example.dto.studyClass.StudyClassDto;
import com.example.services.StudentService;
import com.example.services.StudyClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/class")
public class StudyClassController {
    private final StudyClassService studyClassService;

    @GetMapping({"/{id}"})
    public ResponseEntity<StudyClassDto> getStudyClass(@PathVariable("id") Long id){
        return ResponseEntity.ok(studyClassService.getStudyClassById(id));
    }

    @PostMapping
    public ResponseEntity<StudyClassDto> addStudyClass(@RequestBody NewOrUpdateStudyClassDto newStudyClass){
        return ResponseEntity.status(HttpStatus.CREATED).body(studyClassService.addStudyClass(newStudyClass));
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<StudyClassDto> update(@PathVariable("id") Long id, NewOrUpdateStudyClassDto updatedStudyClass){
        return ResponseEntity.accepted().body(studyClassService.update(id, updatedStudyClass));
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        studyClassService.deleteStudyClass(id);
        return ResponseEntity.accepted().build();
    }
}
