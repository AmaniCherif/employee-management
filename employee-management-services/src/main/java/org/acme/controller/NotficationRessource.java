package org.acme.controller;

import lombok.extern.slf4j.Slf4j;
import org.acme.entity.Notification;
import org.acme.entity.NotificationResponse;
import org.acme.services.INotifService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/notifications")
@Slf4j
public class NotficationRessource {
    @Inject
    private INotifService iNotifService;

    @Path("/notif")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public NotificationResponse getAllNotifications() {
        return new NotificationResponse(iNotifService.getAllNotifications());
    }

    @Path("/add")
    @POST
    public void add(@RequestBody Notification notification) {
        iNotifService.save(notification);
    }

    @Path("/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, Notification notification) {
        Response response = iNotifService.update(id, notification);
        log.info("Response status : {}", response.getStatus());
        return response;
    }
}
