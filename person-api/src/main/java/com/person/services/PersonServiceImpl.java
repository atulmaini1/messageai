package com.person.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.exceptions.InvalidPersonException;
import com.person.exceptions.PersonNotFoundException;
import com.person.model.Person;
import com.person.repositories.PersonDataRepository;

@Service
public class PersonServiceImpl implements PersonService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonDataRepository personDataRepository;
	

	
	@Override
	public List<Person> getAllPersons() throws PersonNotFoundException {
		logger.info("fetching all persons ");
		List<Person> persons =new ArrayList<>();
		try {
			
			personDataRepository.findAll().forEach(persons::add);
			logger.info("fetched all persons details");
			return persons;
		}
		
		catch(Exception ex) {
			logger.error("unable to get all persons ");
			throw new PersonNotFoundException(ex);
		}
	}

	@Override
	public Person getPersonById(String id) throws PersonNotFoundException {
		logger.info("fetching person details for id {}", id);
		
		try {
			Person p = personDataRepository.findOne(id);
			if(p == null) {
				throw new PersonNotFoundException("no person found with id " + id) ;
			}
			logger.info("fetched person details for id {}, person {}", id, p);
			return p;
		} catch(Exception ex) {
			logger.error("unable to get person for id {}", id);
			throw new PersonNotFoundException(ex);
		}
		
	}

	@Override
	public Person CreateNewPerson(Person person) throws InvalidPersonException {
		logger.info("creating new person for id {}, person {}", person.getId(), person);
		try {
			Person p = personDataRepository.save(person);
			logger.info("person created successfully for id {}, person {}", p.getId(), p);
			return p;
		}
		 catch(Exception ex) {
				logger.error("unable to create person for id {}, person {}", person.getId());
				throw new InvalidPersonException(ex);
			}
	}

	@Override
	public Person updatePersonById(String id,Person person) throws InvalidPersonException {
		logger.info("updating person for id {}, person {}", id, person);
		try {
			Person p = personDataRepository.save(person);
			logger.info("person updated successfully for id {}, person {}", p.getId(), p);
			return p;
		}
		 catch(Exception ex) {
				logger.error("unable to update person for id {}, person {}", person.getId(),person);
				throw new InvalidPersonException(ex);
			}
	}

	@Override
	public void deletePersonById(String id) throws PersonNotFoundException {
		logger.info("deleting person details for id {}", id);
		try {
		personDataRepository.delete(id);
		}  catch(Exception ex) {
			logger.error("unable to get person for id {}", id);
			throw new PersonNotFoundException(ex);
		}
		
	}

}
