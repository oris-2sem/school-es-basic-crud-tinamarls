package com.example.dto.teacher;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewOrUpdateTeacherDto {
    private Integer experience;
    private String firstName;
    private String lastName;
    private Integer age;
}
