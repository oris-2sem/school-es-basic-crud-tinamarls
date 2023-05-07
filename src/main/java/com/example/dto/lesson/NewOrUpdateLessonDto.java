package com.example.dto.lesson;

import com.example.dto.studyTimetable.StudyTimetableDto;
import com.example.dto.task.TaskDto;
import com.example.models.enums.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewOrUpdateLessonDto {
    private Subject subject;
    private String topic;
}
