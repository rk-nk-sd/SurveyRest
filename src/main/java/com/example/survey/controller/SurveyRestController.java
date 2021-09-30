package com.example.survey.controller;

import com.example.survey.entity.Survey;
import com.example.survey.service.interfaces.SurveyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class SurveyRestController {
    @Autowired
    private final SurveyService surveyService;

    @GetMapping("/survey/getAllSurvey")
    public ResponseEntity<List<Survey>> getAllUsers() {
        return ResponseEntity.ok(surveyService.findAllSurvey());
    }

    @PostMapping("/survey/create/survey")
    public ResponseEntity<?> createUser (@RequestBody Survey _survey) {
        Survey survey = new Survey();

        survey.setName(_survey.getName());
//        survey.setDataStart(_survey.getDataStart());
//        survey.setDataFinish(_survey.getDataFinish());
//        survey.setDescription(_survey.getDescription());

        surveyService.addSurvey(survey);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/survey/{id}")
    public ResponseEntity delete ( @PathVariable("id") int id){
        surveyService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
