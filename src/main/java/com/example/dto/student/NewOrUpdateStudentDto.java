package com.example.dto.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewOrUpdateStudentDto {
    private Long studyClassId;
    private Long parentId;
    private String firstName;
    private String lastName;
    private Integer age;
}
