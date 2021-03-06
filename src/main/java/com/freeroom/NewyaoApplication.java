package com.freeroom;

import com.freeroom.container.NewyaoContainer;
import com.freeroom.resource.PersonResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by richard on 6/8/15.
 */
public class NewyaoApplication extends Application<NewyaoConfiguration> {
    private AnnotationConfigApplicationContext context;

    public static void main(String[] args) throws Exception {
        new NewyaoApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<NewyaoConfiguration> bootstrap) {
        context = new AnnotationConfigApplicationContext(NewyaoContainer.class);
    }

    @Override
    public void run(final NewyaoConfiguration newyaoConfiguration, final Environment environment) throws Exception {
        environment.jersey().register(context.getBean(PersonResource.class));
//        environment.getApplicationContext().getServletHandler()
//                .addServletWithMapping(TalkServlet.class, "/ws/*");
    }
}
