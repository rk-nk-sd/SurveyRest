package com.example.survey.controller;

import com.example.survey.entity.Question;
import com.example.survey.service.interfaces.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class QuestionRestController {
    @Autowired
    private final QuestionService questionService;

    @GetMapping("/question/all")
    public ResponseEntity<List<Question>> getAllQuestion() {
        return ResponseEntity.ok(questionService.findAllQuestion());
    }

    @PostMapping("/question/create")
    public ResponseEntity<?> createUser (@RequestBody Question _question) {
        Question question = new Question();

        question.setQuestionText(_question.getQuestionText());
        question.setQuestionType(_question.getQuestionType());
        question.setSurvey(_question.getSurvey());

        questionService.addQuestion(question);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/question/{id}/edit")
    public ResponseEntity<Question> updateQuestion(@PathVariable("id") int id, @RequestBody Question _question ) {
        Question question = questionService.getQuestionById(id);

        question.setQuestionText(_question.getQuestionText());
        question.setQuestionType(_question.getQuestionType());
        question.setSurvey(_question.getSurvey());

        return ResponseEntity.ok(questionService.updateQuestion(question));
    }

    @DeleteMapping("/question/{id}")
    public ResponseEntity deleteQuestion( @PathVariable("id") int id){
        questionService.deleteQuestion(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
