package com.example.service.impl;

import com.example.model.Person;
import com.example.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by akila on 12/11/16.
 */
@Component
public class PersonServiceImpl implements PersonService {

    private static Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    private static Map<Integer,Person> persons = new HashMap<Integer,Person>();

    @Override
    public boolean addPerson(Person p) {
        if(persons.get(p.getId()) != null) {
            logger.info("{} : this person already exist", p.toString());
            return false;
        }
        persons.put(p.getId(), p);
        logger.info("{} : person added", p.toString());
        return true;
    }

    @Override
    public boolean deletePerson(int id) {
        if(persons.get(id) == null) {
            logger.info("There is no person with id {}", id);
            return false;
        }
        persons.remove(id);
        logger.info("Person with id {} is deleted", id);
        return true;
    }

    @Override
    public Person getPerson(int id) {
        logger.info("Getting person with id {}", id);
        return persons.get(id);
    }

    @Override
    public Set<Person> getAllPerson() {

        if (persons.values().size() > 0) {
            return new HashSet<>(persons.values());
        }

        return new HashSet<>();
    }
}
