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
    Boolean booleanAnswer;

//    @ManyToOne
//            @JoinColumn(name = "survey_id")
//    Survey survey;

    public Question(String prompt, String textAnswer, Boolean booleanAnswer) {
        this.prompt = prompt;
        this.textAnswer = textAnswer;
        this.booleanAnswer = booleanAnswer;
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

    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }

    public Boolean getBooleanAnswer() {
        return booleanAnswer;
    }

    public void setBooleanAnswer(Boolean booleanAnswer) {
        this.booleanAnswer = booleanAnswer;
    }
}
