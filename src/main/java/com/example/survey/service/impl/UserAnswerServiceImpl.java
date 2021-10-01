package com.example.survey.service.impl;

import com.example.survey.entity.UserAnswer;
import com.example.survey.repository.UserAnswerRepository;
import com.example.survey.service.interfaces.UserAnswerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserAnswerServiceImpl implements UserAnswerService {
    private final UserAnswerRepository userAnswerRepository;
    @Override
    public List<UserAnswer> findAllUserAnswer() {
        return userAnswerRepository.findAll();
    }

    @Override
    public UserAnswer addUserAnswer(UserAnswer userAnswer) {
        return userAnswerRepository.save(userAnswer);
    }

    @Override
    public UserAnswer getUserAnswerById(int id) {
        return userAnswerRepository.getById(id);
    }

    @Override
    public UserAnswer updateUserAnswer(UserAnswer userAnswer) {
        return userAnswerRepository.saveAndFlush(userAnswer);
    }

    @Override
    public void deleteUserAnswer(int id) {
        userAnswerRepository.deleteById(id);
    }
}
