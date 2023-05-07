package com.example.mappers;
import com.example.dto.teacher.NewOrUpdateTeacherDto;
import com.example.dto.teacher.TeacherDto;
import com.example.models.Teacher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherDto toDto(Teacher teacher);
    Teacher toTeacher(TeacherDto teacherDto);
    Teacher toTeacher(NewOrUpdateTeacherDto teacherDto);

}
