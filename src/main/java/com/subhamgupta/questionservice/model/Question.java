package com.subhamgupta.questionservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "category")
    private String category;
    @Basic
    @Column(name = "difficulty_level")
    private String difficultyLevel;
    @Basic
    @Column(name = "option1")
    private String option1;
    @Basic
    @Column(name = "option2")
    private String option2;
    @Basic
    @Column(name = "option3")
    private String option3;
    @Basic
    @Column(name = "option4")
    private String option4;
    @Basic
    @Column(name = "question_title")
    private String questionTitle;
    @Basic
    @Column(name = "correct_answer")
    private String correctAnswer;


}
