package com.example.survey.service.interfaces;

import com.example.survey.entity.Survey;

import java.util.List;

public interface SurveyService {
    List<Survey> findAllSurvey();

    Survey addSurvey(Survey survey);

    Survey getSurveyById(int id);

    Survey update(Survey survey);

    void delete(int id);
}
