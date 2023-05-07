package com.example.dto.student;

import com.example.dto.parent.ParentDto;
import com.example.dto.studyClass.StudyClassDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private StudyClassDto studyClass;
    private ParentDto parent;
    private String firstName;
    private String lastName;
    private Integer age;

}
