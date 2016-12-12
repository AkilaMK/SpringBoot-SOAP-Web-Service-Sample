package com.example.endpoint;

import com.example.adaptor.PersonAdaptor;
import com.example.model.Person;
import com.example.service.PersonService;
import localhost._8888.person_service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.Set;

/**
 * Created by akila on 12/11/16.
 * Reference
 * http://docs.spring.io/spring-ws/site/reference/html/tutorial.html
 */
@Endpoint
public class PersonEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8888/person-service";

    @Autowired
    private PersonService personService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addPersonRequest")
    @ResponsePayload
    public AddPersonResponse addPerson(@RequestPayload AddPersonRequest request) {
        AddPersonResponse response = new AddPersonResponse();

        Person person = PersonAdaptor.getPersonModel(request.getPerson());

        response.setStatus(personService.addPerson(person));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonRequest")
    @ResponsePayload
    public GetPersonResponse getPerson(@RequestPayload GetPersonRequest request) {
        GetPersonResponse response = new GetPersonResponse();

        Person p = personService.getPerson(request.getId());

        if(p != null) {
            localhost._8888.person_service.Person person = PersonAdaptor.getGeneratedPerson(p);

            response.setPerson(person);
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deletePersonRequest")
    @ResponsePayload
    public DeletePersonResponse deletePerson(@RequestPayload DeletePersonRequest request) {
        DeletePersonResponse response = new DeletePersonResponse();

        response.setStatus(personService.deletePerson(request.getId()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllPersonRequest")
    @ResponsePayload
    public GetAllPersonResponse getAllPerson() {
        GetAllPersonResponse response = new GetAllPersonResponse();

        Set<Person> allPerson = personService.getAllPerson();

        List<localhost._8888.person_service.Person> personList = response.getPersonList();

        for (Person p: allPerson) {
            personList.add(PersonAdaptor.getGeneratedPerson(p));
        }

        return response;
    }
}
