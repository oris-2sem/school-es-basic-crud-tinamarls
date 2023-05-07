package com.example.repositories;

import com.example.models.StudyTimetable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyTimetableRepository extends JpaRepository<StudyTimetable, Long> {
}
