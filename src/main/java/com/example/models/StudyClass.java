package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
