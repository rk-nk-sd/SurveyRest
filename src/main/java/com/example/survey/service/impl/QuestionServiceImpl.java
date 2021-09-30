package com.example.survey.service.impl;

import com.example.survey.entity.Question;
import com.example.survey.repository.QuestionRepository;
import com.example.survey.repository.SurveyRepository;
import com.example.survey.service.interfaces.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    @Override
    public List<Question> findAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question getQuestionById(int id) {
        return questionRepository.getById(id);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepository.saveAndFlush(question);
    }

    @Override
    public void deleteQuestion(int id) {
        questionRepository.deleteById(id);
    }
}
