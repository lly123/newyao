package com.freeroom.repository;

import com.freeroom.domain.Person;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

/**
 * Created by richard on 6/8/15.
 */
public interface PersonRepository extends Repository<Person, Long> {
    Person save(final Person person);
}
