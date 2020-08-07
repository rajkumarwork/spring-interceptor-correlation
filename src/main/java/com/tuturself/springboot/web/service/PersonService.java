package com.tuturself.springboot.web.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tuturself.springboot.web.model.Person;

@Service
public class PersonService {

	private static Map<Integer, Person> personDB;
	private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

	
	@PostConstruct
	public void init() throws Exception {
		personDB = new HashMap<>();
		for (int i = 0; i < 100; i++) {
			Person person = new Person(i, "Person-name-" + i, System.currentTimeMillis());
			personDB.put(new Integer(i), person);
		}
	}

	public Person getPersonById(Integer id) {
		logger.info("called get person by id");
		return personDB.get(id);
	}
}
