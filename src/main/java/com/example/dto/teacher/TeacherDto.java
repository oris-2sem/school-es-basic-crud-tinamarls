package com.example.dto.teacher;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {
    private Long id;
    private Integer experience;
    private String firstName;
    private String lastName;
    private Integer age;
}
