package com.example.services;

import com.example.dto.studyTimetable.NewOrUpdateStudyTimetableDto;
import com.example.dto.studyTimetable.StudyTimetableDto;
import com.example.dto.studyTimetable.StudyTimetablePage;

public interface StudyTimetableService {
    StudyTimetablePage getAllTimeTable(int page);

    StudyTimetableDto add(NewOrUpdateStudyTimetableDto newTimetable);
}
