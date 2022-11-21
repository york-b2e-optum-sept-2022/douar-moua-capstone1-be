package net.yorksolutions.douarmouacapstone1be.Services;

import net.yorksolutions.douarmouacapstone1be.DTOs.NewQuestionRequestDTO;
import net.yorksolutions.douarmouacapstone1be.DTOs.UpdateQuestionRequestDTO;
import net.yorksolutions.douarmouacapstone1be.Entities.Question;
import net.yorksolutions.douarmouacapstone1be.Entities.Survey;
import net.yorksolutions.douarmouacapstone1be.Repositories.QuestionRepository;
import net.yorksolutions.douarmouacapstone1be.Repositories.SurveyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;
    private SurveyRepository surveyRepository;

    public QuestionService(QuestionRepository questionRepository, SurveyRepository surveyRepository) {
        this.questionRepository = questionRepository;
        this.surveyRepository = surveyRepository;
    }

    public Question createQuestion(NewQuestionRequestDTO requestDTO){
        Optional<Survey> surveyOptional = this.surveyRepository.findById(requestDTO.surveyId);
        if (surveyOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return this.questionRepository.save(
                new Question(requestDTO.prompt, requestDTO.answer, requestDTO.responseType, surveyOptional.get())
        );
    }

    public Iterable<Question> newQuestionList (Iterable<Question> questions, Long surveyId){
        Optional<Survey> surveyOptional = this.surveyRepository.findById(surveyId);
        if (surveyOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Survey newSurvey = surveyOptional.get();

        Iterable<Question> newQuestions = questions;
        for (Question question: newQuestions){
            question.setSurveyOwner(newSurvey);
        }

        return this.questionRepository.saveAll(newQuestions);
    }

    public Iterable<Question> getSurveyQuestions(Long surveyId){
        Optional<Survey> surveyOptional = this.surveyRepository.findById(surveyId);
        if (surveyOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return this.questionRepository.findAllBySurveyOwner(surveyOptional.get());
    }

    public void deleteQuestion (Long questionId){
        this.questionRepository.deleteById(questionId);
    }

    public Question updateQuestion(UpdateQuestionRequestDTO requestDTO){
        Optional<Question> questionOptional = this.questionRepository.findById(requestDTO.id);
        if (questionOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Question updateQuestion = questionOptional.get();
        updateQuestion.setPrompt(requestDTO.prompt);
        updateQuestion.setResponseType(requestDTO.responseType);

        return this.questionRepository.save(updateQuestion);
    }
}
