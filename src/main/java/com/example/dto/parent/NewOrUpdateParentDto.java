package com.example.dto.parent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewOrUpdateParentDto {
    private Long studentId;
    private String firstName;
    private String lastName;
    private Integer age;
}
