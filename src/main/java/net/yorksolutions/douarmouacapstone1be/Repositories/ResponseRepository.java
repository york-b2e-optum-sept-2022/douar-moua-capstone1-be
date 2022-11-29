package net.yorksolutions.douarmouacapstone1be.Repositories;

import net.yorksolutions.douarmouacapstone1be.Entities.Response;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends CrudRepository<Response, Long> {
}
