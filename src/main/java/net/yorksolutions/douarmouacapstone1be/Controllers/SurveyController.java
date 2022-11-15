package net.yorksolutions.douarmouacapstone1be.Controllers;

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
    public Survey createSurvey(@RequestBody Survey newSurvey){
        return this.surveyService.createSurvey(newSurvey);
    }

}
