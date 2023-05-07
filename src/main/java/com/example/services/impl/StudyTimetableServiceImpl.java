package com.example.services.impl;

import com.example.dto.studyTimetable.NewOrUpdateStudyTimetableDto;
import com.example.dto.studyTimetable.StudyTimetableDto;
import com.example.dto.studyTimetable.StudyTimetablePage;
import com.example.mappers.StudyTimetableMapper;
import com.example.models.StudyClass;
import com.example.models.StudyTimetable;
import com.example.models.Teacher;
import com.example.repositories.StudyTimetableRepository;
import com.example.services.LessonService;
import com.example.services.StudyClassService;
import com.example.services.StudyTimetableService;
import com.example.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudyTimetableServiceImpl implements StudyTimetableService {

    private final StudyTimetableRepository studyTimetableRepository;

    private final StudyTimetableMapper timetableMapper;

    private final LessonService lessonService;
    private final TeacherService teacherService;
    private final StudyClassService studyClassService;

    @Value("${default.page-size}")
    private int defaultPageSize;

    @Override
    public StudyTimetablePage getAllTimeTable(int page) {
        PageRequest pageRequest = PageRequest.of(page, defaultPageSize);
        Page<StudyTimetable> timetablePage = studyTimetableRepository.findAll(pageRequest);

        return StudyTimetablePage.builder()
                .timetable(timetableMapper.studyTimetableDtoList(timetablePage.getContent()))
                .totalPagesCount(timetablePage.getTotalPages())
                .build();
    }

    @Override
    public StudyTimetableDto add(NewOrUpdateStudyTimetableDto newTimetable) {
        StudyTimetable studyTimetable = timetableMapper.toTimetable(newTimetable);

        if(newTimetable.getLessonId() != null){
            studyTimetable.setLesson(lessonService.findById(newTimetable.getLessonId()));
        }
        if(newTimetable.getStudyClassId() != null){
            studyTimetable.setStudyClass(studyClassService.findById(newTimetable.getStudyClassId()));
        }
        if(newTimetable.getTeacherId() != null){
            studyTimetable.setTeacher(teacherService.findById(newTimetable.getTeacherId()));
        }

        return timetableMapper.toDto(studyTimetableRepository.save(studyTimetable));
    }
}
