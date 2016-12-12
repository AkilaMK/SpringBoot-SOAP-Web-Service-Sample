package com.example.service;

import com.example.model.Person;

import java.util.Set;

/**
 * Created by akila on 12/11/16.
 */
public interface PersonService {
    public boolean addPerson(Person p);

    public boolean deletePerson(int id);

    public Person getPerson(int id);

    public Set<Person> getAllPerson();
}
