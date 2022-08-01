package org.acme.payload;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.quarkus.mailer.reactive.ReactiveMailer;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletionStage;

@Path("/Hello")
public class MailResource {
    @Inject
    Mailer mailer;
    @Inject
    ReactiveMailer reactiveMailer;

    @GET
    @Path("/mail")
    @Produces(MediaType.TEXT_PLAIN)
    public String mail() {

        Mail mail = Mail.withText("amanicherif431@gmail.com", "Mail Sent with quarkus", "Hello this mail has been sent for you.");
        mailer.send(mail);
        return "mail sent";
    }
    @GET
    @Path("/reactiveMail")
    @Produces(MediaType.TEXT_PLAIN)
    public CompletionStage<String> reactiveMail() {

        Mail mail = Mail.withHtml("amanicherif431@gmail.com", "Mail Sent with quarkus", "Hello this <strong>reactive</strong> mail has been sent for you.");
        return reactiveMailer.send(mail)
                .subscribeAsCompletionStage().thenApply(x -> "mail sent reactively");

    }
}
