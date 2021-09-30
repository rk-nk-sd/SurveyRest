package com.example.survey.service.impl;

import com.example.survey.entity.Answer;
import com.example.survey.repository.AnswerRepository;
import com.example.survey.service.interfaces.AnswerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    @Override
    public List<Answer> findAllAnswer() {
        return answerRepository.findAll();
    }

    @Override
    public Answer addAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Answer getAnswerById(int id) {
        return answerRepository.getById(id);
    }

    @Override
    public Answer updateAnswer(Answer answer) {
        return answerRepository.saveAndFlush(answer);
    }

    @Override
    public void deleteAnswer(int id) {
        answerRepository.deleteById(id);
    }
}
