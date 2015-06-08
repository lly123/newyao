package com.freeroom.service;

import com.freeroom.domain.Person;
import com.freeroom.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by richard on 6/8/15.
 */
@Service
public class MessageService {

    @Autowired
    private PersonRepository personRepository;

    public void createPerson() {
        personRepository.save(new Person("Richard Li"));
    }
}
