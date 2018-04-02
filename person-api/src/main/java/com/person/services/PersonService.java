package com.person.services;

import java.util.List;

import com.person.exceptions.InvalidPersonException;
import com.person.exceptions.PersonNotFoundException;
import com.person.model.Person;

public interface PersonService {
	
	/**
	 * 
	 * @return
	 * @throws PersonNotFoundException
	 */
	List<Person> getAllPersons() throws PersonNotFoundException;
	Person getPersonById(String id) throws PersonNotFoundException;
	Person CreateNewPerson(Person person) throws InvalidPersonException;
	Person updatePersonById(String id,Person person) throws InvalidPersonException;
	void deletePersonById(String id) throws PersonNotFoundException;
	

}
