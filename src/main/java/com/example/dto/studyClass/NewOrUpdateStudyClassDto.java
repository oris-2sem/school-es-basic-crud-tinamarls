package com.example.dto.studyClass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewOrUpdateStudyClassDto {
    private String literal;
    private Date startDateOfStudying;
    private Long teacherId;
}
