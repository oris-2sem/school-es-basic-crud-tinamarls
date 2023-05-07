package com.example.models;

import com.example.models.enums.Mark;
import com.example.models.enums.TypeOfWork;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Enumerated(value = EnumType.STRING)
    private Mark mark;

    private String description;

    private String commentary;

    @Enumerated(value = EnumType.STRING)
    private TypeOfWork type;
}
