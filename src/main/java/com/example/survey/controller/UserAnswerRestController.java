package com.example.survey.controller;

import com.example.survey.entity.UserAnswer;
import com.example.survey.service.interfaces.UserAnswerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Контроллер основных CRUD операций над ответами пользователя
 */
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserAnswerRestController {

    @Autowired
    private final UserAnswerService userAnswerService;

    @GetMapping("/survey/all")
    public ResponseEntity<List<UserAnswer>> getAllSurvey() {
        return ResponseEntity.ok(userAnswerService.findAllUserAnswer());
    }
}
