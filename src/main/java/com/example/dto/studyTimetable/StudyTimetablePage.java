package com.example.dto.studyTimetable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudyTimetablePage {

    private List<StudyTimetableDto> timetable;

    private Integer totalPagesCount;

}
