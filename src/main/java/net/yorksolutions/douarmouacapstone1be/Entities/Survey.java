package net.yorksolutions.douarmouacapstone1be.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Survey {

    public Survey() {}

    @Id
//    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    @Column (unique = true)
    Long id;

    String title;

    @OneToMany
    List<Question> surveyQuestions;

    public Survey(Long id, String title, List<Question> surveyQuestions) {
        this.id = id;
        this.title = title;
        this.surveyQuestions = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getSurveyQuestions() {
        return surveyQuestions;
    }

    public void setSurveyQuestions(List<Question> surveyQuestions) {
        this.surveyQuestions = surveyQuestions;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "title='" + title + '\'' +
                ", surveyQuestions=" + surveyQuestions +
                '}';
    }
}
