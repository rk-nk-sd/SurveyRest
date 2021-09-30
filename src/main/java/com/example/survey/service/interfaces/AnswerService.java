package com.example.survey.service.interfaces;

import com.example.survey.entity.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer> findAllAnswer();

    Answer addAnswer(Answer answer);

    Answer getAnswerById(int id);

    Answer updateAnswer(Answer answer);

    void deleteAnswer(int id);
}
