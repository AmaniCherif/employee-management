package org.acme.controller;


import org.acme.entity.Contrat;
import org.acme.services.INotifService;
import org.acme.services.Iservice;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/contrats")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContratResource {
    @Inject
    Iservice iservice;

    @Inject
    INotifService iNotifService;

    @POST
    public Long ajouterContrat(@RequestBody Contrat contrat) {
        iservice.ajouterContrat(contrat);
        return contrat.getReference();
    }

    @DELETE
    @Path("/{idcontrat}")
    public void deleteContratById(@PathParam("idcontrat") Long id) {
        iservice.deleteContratById(id);
    }

    @GET
    public List<Contrat> getAllContrats() {
        return iservice.getAllContrats();
    }
}
