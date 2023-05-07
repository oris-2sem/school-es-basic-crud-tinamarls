package com.example.mappers;

import com.example.dto.lesson.LessonDto;
import com.example.dto.lesson.NewOrUpdateLessonDto;
import com.example.models.Lesson;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    LessonDto toDto(Lesson lesson);
    Lesson toLesson(LessonDto lessonDto);
    Lesson toLesson(NewOrUpdateLessonDto lessonDto);
}
