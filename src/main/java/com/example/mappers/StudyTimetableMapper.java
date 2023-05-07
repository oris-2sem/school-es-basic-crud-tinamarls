package com.example.mappers;
import com.example.dto.studyTimetable.NewOrUpdateStudyTimetableDto;
import com.example.dto.studyTimetable.StudyTimetableDto;
import com.example.models.StudyTimetable;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudyTimetableMapper {
    StudyTimetableDto toDto(StudyTimetable studyTimetable);
    StudyTimetable toTimetable(StudyTimetableDto studyTimetableDto);
    StudyTimetable toTimetable(NewOrUpdateStudyTimetableDto studyTimetableDto);

    List<StudyTimetableDto> studyTimetableDtoList(List<StudyTimetable> studyTimetable);
}
