package net.yorksolutions.douarmouacapstone1be.Controllers;

import net.yorksolutions.douarmouacapstone1be.DTOs.NewQuestionRequestDTO;
import net.yorksolutions.douarmouacapstone1be.Entities.Question;
import net.yorksolutions.douarmouacapstone1be.Services.QuestionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/question")
@CrossOrigin
public class QuestionController {

    QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public Question createQuestion(@RequestBody NewQuestionRequestDTO requestDTO){
        return this.questionService.createQuestion(requestDTO);
    }

    @GetMapping
    public Iterable<Question> getSurveyQuestions(@RequestParam Long surveyId){
        return this.questionService.getSurveyQuestions(surveyId);
    }
}
