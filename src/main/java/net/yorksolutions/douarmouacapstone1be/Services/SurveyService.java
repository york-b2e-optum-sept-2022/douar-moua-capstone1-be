package net.yorksolutions.douarmouacapstone1be.Services;

import net.yorksolutions.douarmouacapstone1be.DTOs.NewSurveyRequestDTO;
import net.yorksolutions.douarmouacapstone1be.DTOs.UpdateSurveyRequestDTO;
import net.yorksolutions.douarmouacapstone1be.Entities.Question;
import net.yorksolutions.douarmouacapstone1be.Entities.Survey;
import net.yorksolutions.douarmouacapstone1be.Repositories.QuestionRepository;
import net.yorksolutions.douarmouacapstone1be.Repositories.SurveyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class SurveyService {

    SurveyRepository surveyRepository;
    QuestionRepository questionRepository;

    public SurveyService(SurveyRepository surveyRepository, QuestionRepository questionRepository) {
        this.surveyRepository = surveyRepository;
        this.questionRepository = questionRepository;
    }

    public Survey createSurvey(NewSurveyRequestDTO requestDTO){
        try {
            return this.surveyRepository.save(
                    new Survey(requestDTO.id, requestDTO.title, requestDTO.surveyQuestions)
            );
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

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
        Optional<Survey> surveyOptional = this.surveyRepository.findById(surveyId);
        if (surveyOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Iterable<Question> surveyQuestions = this.questionRepository.findAllBySurveyOwner(surveyOptional.get());
        this.questionRepository.deleteAll(surveyQuestions);
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
