package org.acme.controller;


import org.acme.entity.Employe;
import org.acme.entity.Entreprise;
import org.acme.services.Iservice;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/entreprises")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EntrepriseResource {
    @Inject
    Iservice iservice;


    @POST
    public Long ajouterEntreprise(@RequestBody Entreprise entreprise) {
        iservice.ajouterEntreprise(entreprise);
        return entreprise.getId();
    }

    @DELETE
    @Path("/{identreprise}")
    public void deleteEntrepriseById(@PathParam("identreprise") Long id) {
        iservice.deleteEntrepriseById(id);
    }

    @GET
    @Path("/{identreprise}")
    public Entreprise getEntrepriseById(@PathParam("identreprise") Long id) {
        return iservice.getEntrepriseById(id);
    }

    @PUT
    @Path("/{iddept}/{identreprise}")
    public void affecterDepartementAEntreprise(@PathParam("iddept") Long depId, @PathParam("identreprise") Long entrepriseId) {
        iservice.affecterDepartementAEntreprise(depId, entrepriseId);
    }

    @GET
    public List<Entreprise> getAllEntreprises() {
        return iservice.getAllEntreprises();
    }

    @PUT
    // @Path("/{idemp}")
    public Entreprise updateEntreprise (@RequestBody Entreprise entreprise ) {
        return iservice.updateEntreprise(entreprise);
    }
}
