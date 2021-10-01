package com.example.survey.service.interfaces;

import com.example.survey.entity.UserAnswer;

import java.util.List;

public interface UserAnswerService {
    List<UserAnswer> findAllUserAnswer();

    UserAnswer addUserAnswer(UserAnswer userAnswer);

    UserAnswer getUserAnswerById(int id);

    UserAnswer updateUserAnswer(UserAnswer userAnswer);

    void deleteUserAnswer(int id);
}
