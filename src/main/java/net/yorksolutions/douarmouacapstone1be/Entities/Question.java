package net.yorksolutions.douarmouacapstone1be.Entities;

import javax.persistence.*;

@Entity
public class Question {

    public Question() {}

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    Long id;

    String prompt;
    String textAnswer;
//    Boolean booleanAnswer;

    @ManyToOne
    Survey surveyOwner;

    public Question(String prompt, String textAnswer, Survey surveyOwner) {
        this.prompt = prompt;
        this.textAnswer = textAnswer;
//        this.booleanAnswer = booleanAnswer;
        this.surveyOwner = surveyOwner;
    }

    public Long getId() {
        return id;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = "Prompt: " + prompt;
    }

    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }

//    public Boolean getBooleanAnswer() {
//        return booleanAnswer;
//    }

//    public void setBooleanAnswer(Boolean booleanAnswer) {
//        this.booleanAnswer = booleanAnswer;
//    }

    public Survey getSurveyOwner() {
        return surveyOwner;
    }
}
