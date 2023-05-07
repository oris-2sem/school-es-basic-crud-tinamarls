package com.example.services.impl;

import com.example.dto.lesson.LessonDto;
import com.example.dto.lesson.NewOrUpdateLessonDto;
import com.example.exceptions.NotFoundException;
import com.example.mappers.LessonMapper;
import com.example.models.Lesson;
import com.example.repositories.LessonRepository;
import com.example.services.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    private final LessonMapper lessonMapper;

    @Override
    public Lesson findById(Long id) {
        return getLessonOrThrow(id);
    }

    @Override
    public LessonDto getLessonById(Long id) {
        return lessonMapper.toDto(getLessonOrThrow(id));
    }

    @Override
    public LessonDto addLesson(NewOrUpdateLessonDto newLesson) {

        Lesson lesson = lessonRepository.save(lessonMapper.toLesson(newLesson));

        return lessonMapper.toDto(lesson);

    }

    @Override
    public LessonDto updateLesson(Long id, NewOrUpdateLessonDto updatedLesson) {

        Lesson lesson = getLessonOrThrow(id);

        lesson.setTopic(updatedLesson.getTopic());
        lesson.setSubject(updatedLesson.getSubject());

        return lessonMapper.toDto(lessonRepository.save(lesson));

    }

    @Override
    public void deleteLesson(Long id) {
        lessonRepository.delete(getLessonOrThrow(id));
    }

    private Lesson getLessonOrThrow(Long id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Урок с идентификатором <" + id + "> не найден"));
    }

}
