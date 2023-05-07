package com.example.models;

import com.example.models.enums.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Subject subject;

    private String topic;

    @OneToMany(mappedBy = "lesson")
    private List<StudyTimetable> studyTimetableList;

    @OneToMany(mappedBy = "lesson")
    private List<Task> tasks;


}

