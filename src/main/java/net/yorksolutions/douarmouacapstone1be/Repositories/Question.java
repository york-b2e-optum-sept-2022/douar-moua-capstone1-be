package net.yorksolutions.douarmouacapstone1be.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Question extends CrudRepository<Question, Long> {
}
