package org.acme.services;

import org.acme.entity.Notification;
import org.acme.entity.NotificationResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RegisterRestClient(configKey = "notif-api")
@Path("/notifications")
public interface NotificationService {
    @GET
    @Path("/notif")
    NotificationResponse getAllNotifications();

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response update(@PathParam("id") Long id, Notification notification);
}