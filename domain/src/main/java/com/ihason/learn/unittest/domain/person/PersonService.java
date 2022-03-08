package com.ihason.learn.unittest.domain.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person create(String name, int age) {
        Person person = Person.from(name, age);
        return repository.save(person);
    }

}
