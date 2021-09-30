package com.example.survey.service.interfaces;

import com.example.survey.entity.UserAnswer;
import com.example.survey.repository.UserAnswerRepository;

import java.util.List;

public interface UserAnswerService {
    List<UserAnswerRepository> findAllUserAnswer();

    UserAnswer addUserAnswer(UserAnswer userAnswer);

    UserAnswer getUserAnswerById(int id);

    UserAnswer updateUserAnswer(UserAnswer userAnswer);

    void deleteUserAnswer(int id);
}
