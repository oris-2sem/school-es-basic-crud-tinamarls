package com.example.mappers;

import com.example.dto.student.NewOrUpdateStudentDto;
import com.example.dto.student.StudentDto;
import com.example.models.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto toDto(Student student);
    Student toStudent(StudentDto studentDto);
    Student toStudent(NewOrUpdateStudentDto studentDto);
}
