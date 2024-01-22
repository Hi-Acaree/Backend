package org.acaree.core.repository;

import org.acaree.core.model.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * <p>Repository for the Person class.</p>
 * <p> This interface is used to access the database for the Person class.</p>
 * <p> This interface is used by the PersonService class.</p>
 */

public interface PersonRepository extends CrudRepository<Person, Long> {
}
