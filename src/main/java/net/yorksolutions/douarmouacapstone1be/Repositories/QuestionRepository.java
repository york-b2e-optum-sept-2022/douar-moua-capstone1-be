package net.yorksolutions.douarmouacapstone1be.Repositories;

import net.yorksolutions.douarmouacapstone1be.Entities.Question;
import net.yorksolutions.douarmouacapstone1be.Entities.Survey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
    Iterable<Question> findAllBySurveyOwner(Survey surveyOwner);
}
