package com.example.services;

import com.example.dto.student.NewOrUpdateStudentDto;
import com.example.dto.student.StudentDto;
import com.example.models.Student;

public interface StudentService {

    Student findById(Long id);

    StudentDto getStudentById(Long id);

    StudentDto addStudent(NewOrUpdateStudentDto newStudent);

    StudentDto update(Long id, NewOrUpdateStudentDto updatedStudent);

    void deleteStudent(Long id);
}
