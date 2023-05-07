package com.example.services;

import com.example.dto.lesson.LessonDto;
import com.example.dto.lesson.NewOrUpdateLessonDto;
import com.example.models.Lesson;

public interface LessonService {

    Lesson findById(Long id);

    LessonDto getLessonById(Long id);

    LessonDto addLesson(NewOrUpdateLessonDto newLesson);

    LessonDto updateLesson(Long id, NewOrUpdateLessonDto updatedLesson);

    void deleteLesson(Long id);
}
