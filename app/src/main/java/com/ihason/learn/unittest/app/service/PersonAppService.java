package com.ihason.learn.unittest.app.service;

import com.ihason.learn.unittest.app.dto.request.CreatePersonRequest;
import com.ihason.learn.unittest.app.dto.response.PersonDTO;
import com.ihason.learn.unittest.domain.person.Person;
import com.ihason.learn.unittest.domain.person.PersonRepository;
import com.ihason.learn.unittest.domain.person.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonAppService {

    private PersonService personService;

    private PersonRepository personRepository;

    public PersonAppService(PersonService personService, PersonRepository personRepository) {
        this.personService = personService;
        this.personRepository = personRepository;
    }

    public PersonDTO create(CreatePersonRequest request) {
        int age = request.getAge() != null ? request.getAge() : 16;
        Person person = personService.create(request.getName(), age);
        return toDto(person);
    }

    public PersonDTO get(Long id) {
        return personRepository.findById(id)
                .map(this::toDto)
                .orElse(null);
    }

    public List<PersonDTO> listAll() {
        return personRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private PersonDTO toDto(Person person) {
        if (person == null) {
            return null;
        }
        PersonDTO dto = new PersonDTO();
        BeanUtils.copyProperties(person, dto);
        return dto;
    }

}
