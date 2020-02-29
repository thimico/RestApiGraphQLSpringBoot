package com.thimico.repository;


import com.thimico.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author <a href="mailto:thg.mnzs@gmail.com">Thiago Menezes</a>
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findById(Long id);
    Optional<Boolean> deletePersonById(Long id);
}