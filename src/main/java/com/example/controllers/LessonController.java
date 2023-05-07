package com.example.controllers;

import com.example.dto.lesson.LessonDto;
import com.example.dto.lesson.NewOrUpdateLessonDto;
import com.example.services.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lesson")
public class LessonController {

    private final LessonService lessonService;

    @GetMapping({"/{id}"})
    public ResponseEntity<LessonDto> getLesson(@PathVariable("id") Long id){
        return ResponseEntity.ok(lessonService.getLessonById(id));
    }

    @PostMapping
    public ResponseEntity<LessonDto> addLesson(@RequestBody NewOrUpdateLessonDto newLesson){
        return ResponseEntity.status(HttpStatus.CREATED).body(lessonService.addLesson(newLesson));
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<LessonDto> updateLesson(@PathVariable("id") Long id,
                                                  @RequestBody NewOrUpdateLessonDto updatedLesson){
        return ResponseEntity.accepted().body(lessonService.updateLesson(id, updatedLesson));
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<?> deleteLesson(@PathVariable("id") Long id){
        lessonService.deleteLesson(id);
        return ResponseEntity.accepted().build();

    }

}
