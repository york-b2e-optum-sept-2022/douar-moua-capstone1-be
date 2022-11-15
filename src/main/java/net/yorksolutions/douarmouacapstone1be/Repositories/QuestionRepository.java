package net.yorksolutions.douarmouacapstone1be.Repositories;

import net.yorksolutions.douarmouacapstone1be.Entities.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
}
