package com.example.mappers;

import com.example.dto.studyClass.NewOrUpdateStudyClassDto;
import com.example.dto.studyClass.StudyClassDto;
import com.example.models.StudyClass;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudyClassMapper {
    StudyClassDto toDto(StudyClass studyClass);
    StudyClass toClass(StudyClassDto studyClassDto);
    StudyClass toClass(NewOrUpdateStudyClassDto studyClassDto);
}
