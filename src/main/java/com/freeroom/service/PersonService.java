package com.freeroom.service;

import com.freeroom.domain.Gender;
import com.freeroom.domain.Person;
import com.freeroom.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by richard on 6/8/15.
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createPerson(final String name) {
        personRepository.save(new Person(name, Gender.Male, 20));
    }

    public List<Person> topPersons() {
        return personRepository.findTop10ByGenderOrderByAgeDesc(Gender.Male);
    }

    public Person findPerson(final String name) {
        return personRepository.findFirstByName(name);
    }

    public List<Person> getPersons(final int page) {
        return personRepository.findByGender(Gender.Male, new PageRequest(page, 5)).getContent();
    }
}
