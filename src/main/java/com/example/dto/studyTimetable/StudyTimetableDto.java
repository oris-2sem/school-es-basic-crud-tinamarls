package com.example.dto.studyTimetable;

import com.example.dto.lesson.LessonDto;
import com.example.dto.studyClass.StudyClassDto;
import com.example.dto.teacher.TeacherDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudyTimetableDto {
    private Long id;
    private LessonDto lesson;
    private StudyClassDto studyClass;
    private TeacherDto teacher;
    private String room;
    private Date lessonStartDate;
}
