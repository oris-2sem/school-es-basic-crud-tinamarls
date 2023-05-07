package com.example.services;

import com.example.dto.teacher.NewOrUpdateTeacherDto;
import com.example.dto.teacher.TeacherDto;
import com.example.models.Teacher;

public interface TeacherService {

    Teacher findById(Long id);

    TeacherDto getTeacherById(Long id);

    TeacherDto addTeacher(NewOrUpdateTeacherDto newTeacher);

    TeacherDto update(Long id, NewOrUpdateTeacherDto updatedTeacher);

    void deleteTeacher(Long id);
}
