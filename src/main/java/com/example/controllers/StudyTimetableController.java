package com.example.controllers;

import com.example.dto.studyTimetable.NewOrUpdateStudyTimetableDto;
import com.example.dto.studyTimetable.StudyTimetableDto;
import com.example.dto.studyTimetable.StudyTimetablePage;
import com.example.models.StudyTimetable;
import com.example.services.StudyTimetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/timetable")
public class StudyTimetableController {

    private final StudyTimetableService timetableService;

    @Value("${default.page-size}")
    private int defaultPageSize;

    @GetMapping
    public ResponseEntity<StudyTimetablePage> getTimetable(@RequestParam("page") int page){
        return ResponseEntity
                .ok(timetableService.getAllTimeTable(page));

    }

    @PostMapping
    public ResponseEntity<StudyTimetableDto> add(@RequestBody NewOrUpdateStudyTimetableDto newTimetable){
        return ResponseEntity.status(HttpStatus.CREATED).body(timetableService.add(newTimetable));
    }
}
