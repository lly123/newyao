package com.freeroom.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by richard on 6/8/15.
 */
@Entity
public class Person extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    public Person() {
    }

    public Person(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
