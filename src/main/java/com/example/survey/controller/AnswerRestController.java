package com.example.survey.controller;

import com.example.survey.entity.Answer;
import com.example.survey.entity.Question;
import com.example.survey.service.interfaces.AnswerService;
import com.example.survey.service.interfaces.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер основных CRUD операций над Ответами
 */
@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AnswerRestController {
    @Autowired
    private final AnswerService answerService;

    @GetMapping("/answer/all")
    public ResponseEntity<List<Answer>> getAllQuestion() {
        return ResponseEntity.ok(answerService.findAllAnswer());
    }

    @PostMapping("/answer/create")
    public ResponseEntity<?> createAnswer (@RequestBody Answer _answer) {
        Answer answer = new Answer();

        answer.setQuestion(_answer.getQuestion());
        answer.setAnswer(_answer.getAnswer());

        answerService.addAnswer(answer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/answer/{id}/edit")
    public ResponseEntity<Answer> updateAnswer(@PathVariable("id") int id, @RequestBody Answer _answer ) {
        Answer answer = answerService.getAnswerById(id);

        answer.setQuestion(_answer.getQuestion());
        answer.setAnswer(_answer.getAnswer());

        return ResponseEntity.ok(answerService.updateAnswer(answer));
    }

    @DeleteMapping("/answer/{id}")
    public ResponseEntity deleteAnswer( @PathVariable("id") int id){
        answerService.deleteAnswer(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
