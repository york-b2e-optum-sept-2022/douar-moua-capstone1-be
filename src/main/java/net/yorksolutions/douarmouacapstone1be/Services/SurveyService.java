package net.yorksolutions.douarmouacapstone1be.Services;

import net.yorksolutions.douarmouacapstone1be.Entities.Survey;
import net.yorksolutions.douarmouacapstone1be.Repositories.SurveyRepository;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {

    SurveyRepository surveyRepository;

    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public Survey createSurvey(Survey newSurvey){
        return this.surveyRepository.save(newSurvey);
    }
}
