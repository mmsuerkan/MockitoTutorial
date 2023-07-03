package org.example;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {

    Person save(Person person);

    Optional<Person> findById(Long id);

    List<Person> findAll();

    long count();

    void delete(Person person);
}
