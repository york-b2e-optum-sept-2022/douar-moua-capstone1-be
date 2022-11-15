package net.yorksolutions.douarmouacapstone1be.Repositories;

import net.yorksolutions.douarmouacapstone1be.Entities.Survey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long> {
}
