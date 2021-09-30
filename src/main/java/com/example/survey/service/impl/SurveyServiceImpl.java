package com.example.survey.service.impl;

import com.example.survey.entity.Survey;
import com.example.survey.repository.SurveyRepository;
import com.example.survey.service.interfaces.SurveyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SurveyServiceImpl implements SurveyService {
    private final SurveyRepository surveyRepository;
    @Override
    public List<Survey> findAllSurvey() {
        return surveyRepository.findAll();
    }

    @Override
    public Survey addSurvey(Survey survey) { return surveyRepository.save(survey); }

    @Override
    public Survey getSurveyById(int id) {
        return surveyRepository.getById(id);
    }

    @Override
    public Survey update(Survey survey) {
        return surveyRepository.saveAndFlush(survey);
    }

    @Override
    public void delete(int id) {
        surveyRepository.deleteById(id);
    }
}
