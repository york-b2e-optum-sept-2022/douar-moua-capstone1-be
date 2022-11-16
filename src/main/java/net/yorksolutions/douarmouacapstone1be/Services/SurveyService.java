package net.yorksolutions.douarmouacapstone1be.Services;

import net.yorksolutions.douarmouacapstone1be.DTOs.UpdateSurveyRequestDTO;
import net.yorksolutions.douarmouacapstone1be.Entities.Survey;
import net.yorksolutions.douarmouacapstone1be.Repositories.SurveyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class SurveyService {

    SurveyRepository surveyRepository;

    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public Survey createSurvey(Survey newSurvey){
        return this.surveyRepository.save(newSurvey);
    }

    public Survey getSurvey(Long surveyId){
        Optional<Survey> surveyOptional = this.surveyRepository.findById(surveyId);
        if (surveyOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return surveyOptional.get();
    }

    public Iterable<Survey> getAllSurveys(){
        return this.surveyRepository.findAll();
    }

    public void deleteSurvey(Long surveyId){
        this.surveyRepository.deleteById(surveyId);
    }

    public Survey updateSurvey(UpdateSurveyRequestDTO requestDTO){
        Optional<Survey> surveyOptional = this.surveyRepository.findById(requestDTO.id);
        if (surveyOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Survey updateSurvey = surveyOptional.get();
        updateSurvey.setTitle(requestDTO.title);

        return this.surveyRepository.save(updateSurvey);
    }
}
