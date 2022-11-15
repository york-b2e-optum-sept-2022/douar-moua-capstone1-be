package net.yorksolutions.douarmouacapstone1be.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<QuestionRepository, Long> {
}
