package com.example.survey.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String questionText;

    @Column
    private String questionType;

    @ManyToMany
    @JoinTable (name="question_survey",
            joinColumns=@JoinColumn (name="question_id"),
            inverseJoinColumns=@JoinColumn(name="survey_id"))
    private Set<Survey> survey;
}
