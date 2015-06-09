package com.freeroom.repository;

import com.freeroom.domain.Gender;
import com.freeroom.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by richard on 6/8/15.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findFirstByName(final String name);
    List<Person> findTop10ByGenderOrderByAgeDesc(final Gender gender);
    Page<Person> findByGender(final Gender gender, final Pageable pageable);
}
