package com.example.dto.studyClass;

import com.example.dto.teacher.TeacherDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudyClassDto {
    private Long id;
    private String literal;
    private Date startDateOfStudying;
    private TeacherDto teacher;
}
