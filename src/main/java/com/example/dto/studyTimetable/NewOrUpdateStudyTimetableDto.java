package com.example.dto.studyTimetable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewOrUpdateStudyTimetableDto {
    private Long lessonId;
    private Long studyClassId;
    private Long teacherId;
    private String room;
    private Date lessonStartDate;
}
