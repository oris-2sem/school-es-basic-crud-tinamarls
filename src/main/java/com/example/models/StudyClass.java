package com.example.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "study_class")
public class StudyClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1)
    private String literal;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date_of_studying")
    private Date startDateOfStudying;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "studyClass", cascade = CascadeType.ALL)
    private List<Student> students;

    @OneToMany(mappedBy = "studyClass")
    private List<StudyTimetable> studyTimetableList;
}
