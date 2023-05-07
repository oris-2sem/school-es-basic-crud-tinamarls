package com.example.dto.task;

import com.example.dto.lesson.LessonDto;
import com.example.dto.student.StudentDto;
import com.example.models.enums.Mark;
import com.example.models.enums.TypeOfWork;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private Long id;
    private LessonDto lesson;
    private StudentDto student;
    private Mark mark;
    private String description;
    private String commentary;
    private TypeOfWork type;
}
