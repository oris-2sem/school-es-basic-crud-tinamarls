package com.example.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "study_timetable")
public class StudyTimetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private StudyClass studyClass;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    private String room;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lesson_start_date")
    private Date lessonStartDate;
}
