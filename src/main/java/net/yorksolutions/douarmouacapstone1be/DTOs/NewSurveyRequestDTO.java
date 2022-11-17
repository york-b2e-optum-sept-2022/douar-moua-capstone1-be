package net.yorksolutions.douarmouacapstone1be.DTOs;

import net.yorksolutions.douarmouacapstone1be.Entities.Question;

import java.util.List;

public class NewSurveyRequestDTO {
    public Long id;
    public String title;
    public List<Question> surveyQuestions;

}
