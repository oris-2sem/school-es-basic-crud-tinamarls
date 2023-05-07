package com.example.services;

import com.example.dto.studyClass.NewOrUpdateStudyClassDto;
import com.example.dto.studyClass.StudyClassDto;
import com.example.models.StudyClass;

public interface StudyClassService {

    StudyClass findById(Long id);

    StudyClassDto getStudyClassById(Long id);

    StudyClassDto addStudyClass(NewOrUpdateStudyClassDto newStudyClass);

    StudyClassDto update(Long id, NewOrUpdateStudyClassDto updatedStudyClass);

    void deleteStudyClass(Long id);
}
