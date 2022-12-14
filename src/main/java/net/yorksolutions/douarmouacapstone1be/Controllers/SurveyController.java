package net.yorksolutions.douarmouacapstone1be.Controllers;

import net.yorksolutions.douarmouacapstone1be.DTOs.NewSurveyRequestDTO;
import net.yorksolutions.douarmouacapstone1be.DTOs.UpdateSurveyRequestDTO;
import net.yorksolutions.douarmouacapstone1be.Entities.Survey;
import net.yorksolutions.douarmouacapstone1be.Services.SurveyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/survey")
@CrossOrigin
public class SurveyController {

    SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PostMapping
    public Survey createSurvey(@RequestBody NewSurveyRequestDTO requestDTO){
        return this.surveyService.createSurvey(requestDTO);
    }

    @GetMapping("/all-survey")
    public Iterable<Survey> getAllSurvey(){
        return this.surveyService.getAllSurveys();
    }

    @GetMapping
    public Survey getSurvey(@RequestParam Long surveyId){
        return this.surveyService.getSurvey(surveyId);
    }

    @DeleteMapping
    public void deleteSurvey(Long surveyId){
        this.surveyService.deleteSurvey(surveyId);
    }

    @PutMapping
    public Survey updateSurvey(@RequestBody UpdateSurveyRequestDTO requestDTO){
        return this.surveyService.updateSurvey(requestDTO);
    }
}
