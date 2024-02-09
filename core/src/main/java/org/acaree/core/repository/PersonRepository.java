package org.acaree.core.repository;

import org.acaree.core.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>Repository for the Person class.</p>
 * <p> This interface is used to access the database for the Person class.</p>
 * <p> This interface is used by the PersonService class.</p>
 */

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
