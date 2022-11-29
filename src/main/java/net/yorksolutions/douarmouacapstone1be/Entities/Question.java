package net.yorksolutions.douarmouacapstone1be.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Question {

    public Question() {}

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    Long id;

    String prompt;
    String answer;
    String responseType;

    Long questionOrder;

    @ManyToOne
    Survey surveyOwner;

    public Question(String prompt, String answer, String responseType, Long questionOrder, Survey surveyOwner) {
        this.prompt = prompt;
        this.answer = answer;
        this.responseType = responseType;
        this.questionOrder = questionOrder;
        this.surveyOwner = surveyOwner;
    }

    public Long getId() {
        return id;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String textAnswer) {
        this.answer = textAnswer;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public Long getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(Long questionOrder) {
        this.questionOrder = questionOrder;
    }

    public Survey getSurveyOwner() {
        return surveyOwner;


    }

    public void setSurveyOwner(Survey surveyOwner) {
        this.surveyOwner = surveyOwner;
    }
}
