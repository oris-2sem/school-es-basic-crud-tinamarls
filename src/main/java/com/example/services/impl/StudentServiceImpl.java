package com.example.services.impl;

import com.example.dto.student.NewOrUpdateStudentDto;
import com.example.dto.student.StudentDto;
import com.example.exceptions.NotFoundException;
import com.example.mappers.StudentMapper;
import com.example.models.Parent;
import com.example.models.Student;
import com.example.models.StudyClass;
import com.example.models.Teacher;
import com.example.repositories.StudentRepository;
import com.example.services.ParentService;
import com.example.services.StudentService;
import com.example.services.StudyClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final ParentService parentService;

    private final StudyClassService studyClassService;

    private final StudentMapper studentMapper;

    @Override
    public Student findById(Long id) {
        return getStudentOrThrow(id);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        return studentMapper.toDto(getStudentOrThrow(id));
    }

    @Override
    public StudentDto addStudent(NewOrUpdateStudentDto newStudent) {

        Student student = studentMapper.toStudent(newStudent);

        if(newStudent.getParentId() != null){
            student.setParent(parentService.findById(newStudent.getParentId()));
        }

        if(newStudent.getStudyClassId() != null){
            student.setStudyClass(studyClassService.findById(newStudent.getStudyClassId()));
        }

        return studentMapper.toDto(studentRepository.save(student));

    }

    @Override
    public StudentDto update(Long id, NewOrUpdateStudentDto updatedStudent) {
        Student student = getStudentOrThrow(id);

        Parent parent = null;
        StudyClass clazz = null;

        if(updatedStudent.getParentId() != null){
            parent = parentService.findById(updatedStudent.getParentId());
        }

        if(updatedStudent.getStudyClassId() != null){
            clazz = studyClassService.findById(updatedStudent.getStudyClassId());
        }

        student.setAge(updatedStudent.getAge());
        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setParent(parent);
        student.setStudyClass(clazz);

        return studentMapper.toDto(studentRepository.save(student));

    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.delete(getStudentOrThrow(id));
    }

    private Student getStudentOrThrow(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Студент с идентификатором <" + id + "> не найден"));
    }

}
