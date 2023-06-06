package com.example.models;

import com.example.models.enums.Subject;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

