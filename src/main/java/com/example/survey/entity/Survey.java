package com.example.survey.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private Date dateStart;

    @Column
    private Date dateFinish;

    @Column
    private String description;

    @ManyToMany
    @JoinTable(name="question_survey",
            joinColumns=@JoinColumn(name="survey_id"),
            inverseJoinColumns=@JoinColumn(name="question_id"))
    private Set<Question> questions;
}
