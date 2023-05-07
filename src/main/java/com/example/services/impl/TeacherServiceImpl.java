package com.example.services.impl;

import com.example.dto.teacher.NewOrUpdateTeacherDto;
import com.example.dto.teacher.TeacherDto;
import com.example.exceptions.NotFoundException;
import com.example.mappers.TeacherMapper;
import com.example.models.Parent;
import com.example.models.Teacher;
import com.example.repositories.TeacherRepository;
import com.example.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    private final TeacherMapper teacherMapper;

    @Override
    public Teacher findById(Long id) {
        return getTeacherOrThrow(id);
    }

    @Override
    public TeacherDto getTeacherById(Long id) {
        return teacherMapper.toDto(getTeacherOrThrow(id));
    }

    @Override
    public TeacherDto addTeacher(NewOrUpdateTeacherDto newTeacher) {

        Teacher teacher = teacherMapper.toTeacher(newTeacher);

        return teacherMapper.toDto(teacherRepository.save(teacher));

    }

    @Override
    public TeacherDto update(Long id, NewOrUpdateTeacherDto updatedTeacher) {

        Teacher teacher = getTeacherOrThrow(id);

        teacher.setExperience(updatedTeacher.getExperience());
        teacher.setAge(updatedTeacher.getAge());
        teacher.setFirstName(updatedTeacher.getFirstName());
        teacher.setLastName(updatedTeacher.getLastName());

        return teacherMapper.toDto(teacherRepository.save(teacher));

    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.delete(getTeacherOrThrow(id));
    }

    private Teacher getTeacherOrThrow(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Учитель с идентификатором <" + id + "> не найден"));
    }
}
