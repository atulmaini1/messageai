package com.person.repositories;

import org.springframework.data.repository.CrudRepository;

import com.person.model.Person;

public interface PersonDataRepository extends CrudRepository<Person, String> {

}
