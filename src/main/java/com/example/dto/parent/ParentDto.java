package com.example.dto.parent;

import com.example.dto.student.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentDto {
    private Long id;
//    private StudentDto children;
    private String firstName;
    private String lastName;
    private Integer age;
}
