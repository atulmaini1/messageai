package com.person.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.person.exceptions.InvalidIdException;
import com.person.exceptions.InvalidPersonException;
import com.person.exceptions.PersonNotFoundException;
import com.person.model.Person;
import com.person.services.PersonServiceImpl;


@RestController
public class PersonController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonServiceImpl personServiceImpl;
	
	@RequestMapping(value="/person",method=RequestMethod.GET)
	public List<Person> getPersons() throws PersonNotFoundException {
		logger.info("Request for fetching all persons received");
		try {
			List<Person> persons = new ArrayList<>();
			persons= personServiceImpl.getAllPersons();
			logger.info("All persons fetched successfully");
			return persons;
		}
		 catch (PersonNotFoundException e) {
				logger.error("unable to get all persons" );
				throw new PersonNotFoundException("unable to get all persons");
			}
	}
	
	@RequestMapping(value="/person/{id}",method=RequestMethod.GET)
	public Person getPerson(@PathVariable String id) throws PersonNotFoundException,InvalidIdException {
		logger.info("request received to fetch person with id {}",id);
		if(id==null ||StringUtils.isEmpty(id)) {
			logger.error("invalid id");
			throw new InvalidIdException("invalid id");
		}
		try {
			Person person=personServiceImpl.getPersonById(id);
			logger.info("successfully fetched person for id {}",id);
			return person; 
		} catch (PersonNotFoundException e) {
			logger.error("unable to get person details for id {} ", id);
			throw e;
		}
	}
	
	@RequestMapping(value="/person",method=RequestMethod.POST)
	public Person createPerson(@RequestBody Person person) throws InvalidPersonException {
		logger.info("request for creating new person received with {person}",person.toString());
			if(person.getId()==null||StringUtils.isEmpty(person.getId())) {
				throw new InvalidPersonException("null id is not allowed");
		}
			try {
				
				Person persn=personServiceImpl.CreateNewPerson(person); 
				logger.info("person successfully created with id {}",person.getId());
				return persn;
			}
			catch(InvalidPersonException e) {
				logger.error("unable to create new person");
				throw e;
			}
			
	}
	
	@RequestMapping(value="/person/{id}",method=RequestMethod.PUT)
	public Person getPerson(@PathVariable String id,@RequestBody Person person) throws InvalidPersonException,InvalidIdException {
		logger.info("request for updating person received for id {}",id);
		if(id==null||StringUtils.isEmpty(id)) {
			logger.error("invalid id");
			throw new InvalidIdException("invalid id");
	}
		
		if(person.getId()==null||StringUtils.isEmpty(person.getId())) {
			throw new InvalidPersonException("null id is not allowed");
	}
		return personServiceImpl.updatePersonById(id,person);
	}
	
	@RequestMapping(value="/person/{id}",method=RequestMethod.DELETE)
	public void deletePerson(@PathVariable String id) throws InvalidPersonException,InvalidIdException, PersonNotFoundException{
		logger.info("request for deleting person received for id {}",id);
		if(id==null||StringUtils.isEmpty(id)) {
			logger.error("invalid id");
			throw new InvalidIdException("invalid id");
	}
		
		
		
		personServiceImpl.deletePersonById(id);
	}
	
	

}
