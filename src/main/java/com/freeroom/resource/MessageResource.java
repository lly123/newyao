package com.freeroom.resource;

import com.freeroom.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by richard on 6/8/15.
 */
@Service
@Path("/text")
public class MessageResource {

    @Autowired
    private MessageService messageService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Message getText() {
        return new Message("Hello");
    }

    @POST
    public void createPerson() {
        messageService.createPerson();
    }

    public final static class Message {
        private String text;

        public Message(final String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
