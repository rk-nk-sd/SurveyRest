package com.example.survey.controller;

import com.example.survey.entity.Survey;
import com.example.survey.service.interfaces.SurveyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер основных CRUD операций над опросниками
 */
@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class SurveyRestController {
    @Autowired
    private final SurveyService surveyService;

    @GetMapping("/survey/all")
    public ResponseEntity<List<Survey>> getAllSurvey() {
        return ResponseEntity.ok(surveyService.findAllSurvey());
    }

    @PostMapping("/survey/create")
    public ResponseEntity<?> createSurvey(@RequestBody Survey _survey) {
        Survey survey = new Survey();

        survey.setName(_survey.getName());
        survey.setDateStart(_survey.getDateStart());
        survey.setDateFinish(_survey.getDateFinish());
        survey.setDescription(_survey.getDescription());

        surveyService.addSurvey(survey);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/survey/{id}/edit")
    public ResponseEntity<Survey> updateSurvey(@PathVariable("id") int id, @RequestBody Survey _survey ) {
        Survey survey = surveyService.getSurveyById(id);

        survey.setName(_survey.getName());
        survey.setDateStart(_survey.getDateStart());
        survey.setDateFinish(_survey.getDateFinish());
        survey.setDescription(_survey.getDescription());

        return ResponseEntity.ok(surveyService.update(survey));
    }

    @DeleteMapping("/survey/{id}")
    public ResponseEntity deleteSurvey( @PathVariable("id") int id){
        surveyService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
