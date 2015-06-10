package com.freeroom.resource;

import com.freeroom.domain.Person;
import com.freeroom.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by richard on 6/8/15.
 */
@Component
@Path("/person")
public class PersonResource {

    @Autowired
    private PersonService personService;

    @POST
    public void createPerson(@QueryParam("name") final String name) {
        personService.createPerson(name);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPersons() {
        return personService.topPersons();
    }

    @GET
    @Path("/{page:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPersons(@PathParam("page") final int page) {
        return personService.getPersons(page);
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson(@PathParam("name") final String name) {
        return personService.findPerson(name);
    }
}
