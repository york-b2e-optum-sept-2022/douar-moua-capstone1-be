package net.yorksolutions.douarmouacapstone1be.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Response {

    public Response() {
    }

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    Long id;

    String answer;

    Long surveyId;
    String surveyTitle;

    Long questionId;
    String question;

    public Response(String answer, Long surveyId, String surveyTitle, Long questionId, String question) {
        this.answer = answer;
        this.surveyId = surveyId;
        this.surveyTitle = surveyTitle;
        this.questionId = questionId;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public String getSurveyTitle() {
        return surveyTitle;
    }

    public void setSurveyTitle(String surveyTitle) {
        this.surveyTitle = surveyTitle;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
