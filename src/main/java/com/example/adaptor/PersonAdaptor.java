package com.example.adaptor;

import com.example.model.Person;

/**
 * Created by akila on 12/12/16.
 */
public class PersonAdaptor {
    public static Person getPersonModel(localhost._8888.person_service.Person p) {
        Person person = new Person();
        person.setName(p.getName());
        person.setAge(p.getAge());
        person.setId(p.getId());

        return person;
    }

    public static localhost._8888.person_service.Person getGeneratedPerson(Person p) {
        localhost._8888.person_service.Person person = new localhost._8888.person_service.Person();
        person.setName(p.getName());
        person.setAge(p.getAge());
        person.setId(p.getId());

        return person;
    }
}
