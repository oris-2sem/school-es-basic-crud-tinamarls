package com.example.services.impl;

import com.example.dto.studyClass.NewOrUpdateStudyClassDto;
import com.example.dto.studyClass.StudyClassDto;
import com.example.exceptions.NotFoundException;
import com.example.mappers.StudyClassMapper;
import com.example.models.Parent;
import com.example.models.StudyClass;
import com.example.models.Teacher;
import com.example.repositories.StuduClassRepository;
import com.example.services.StudyClassService;
import com.example.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudyClassServiceImpl implements StudyClassService {

    private final StuduClassRepository studuClassRepository;

    private final TeacherService teacherService;

    private final StudyClassMapper studyClassMapper;

    @Override
    public StudyClass findById(Long id) {
        return getStudyClassOrThrow(id);
    }

    @Override
    public StudyClassDto getStudyClassById(Long id) {
        return studyClassMapper.toDto(getStudyClassOrThrow(id));
    }

    @Override
    public StudyClassDto addStudyClass(NewOrUpdateStudyClassDto newStudyClass) {

        StudyClass studyClass = studyClassMapper.toClass(newStudyClass);

        if(newStudyClass.getTeacherId() != null){
            studyClass.setTeacher(teacherService.findById(newStudyClass.getTeacherId()));
        }

        return studyClassMapper.toDto(studuClassRepository.save(studyClass));
    }

    @Override
    public StudyClassDto update(Long id, NewOrUpdateStudyClassDto updatedStudyClass) {

        StudyClass studyClass = getStudyClassOrThrow(id);

        Teacher teacher = null;

        if(updatedStudyClass.getTeacherId() != null){
            teacher = teacherService.findById(updatedStudyClass.getTeacherId());
        }

        studyClass.setStartDateOfStudying(updatedStudyClass.getStartDateOfStudying());
        studyClass.setLiteral(updatedStudyClass.getLiteral());
        studyClass.setTeacher(teacher);

        return studyClassMapper.toDto(studuClassRepository.save(studyClass));
    }

    @Override
    public void deleteStudyClass(Long id) {
        studuClassRepository.delete(getStudyClassOrThrow(id));
    }

    private StudyClass getStudyClassOrThrow(Long id) {
        return studuClassRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Класс с идентификатором <" + id + "> не найден"));
    }

}
