package com.example.survey.service.interfaces;

import com.example.survey.entity.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAllQuestion();

    Question addQuestion(Question question);

    Question getQuestionById(int id);

    Question updateQuestion(Question question);

    void deleteQuestion(int id);
}
