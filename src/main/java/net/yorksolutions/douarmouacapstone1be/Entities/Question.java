package net.yorksolutions.douarmouacapstone1be.Entities;

import javax.persistence.*;

@Entity
public class Question {

    public Question() {}

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    Long id;

    String prompt;
    String answer;

    @ManyToOne
    Survey surveyOwner;

    public Question(String prompt, String answer, Survey surveyOwner) {
        this.prompt = prompt;
        this.answer = answer;
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

    public Survey getSurveyOwner() {
        return surveyOwner;
    }

    public void setSurveyOwner(Survey surveyOwner) {
        this.surveyOwner = surveyOwner;
    }
}
