package org.acme.controller;


import org.acme.entity.Employe;
import org.acme.services.Iservice;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeResource {
    @Inject
    Iservice iservice;

    @POST
    public Employe ajouterEmploye(@RequestBody Employe employe) {
        return iservice.ajouterEmploye(employe);
    }

    @GET
    @Path("/{idemp}")
    public String getEmployePrenomById(@PathParam("idemp") Long id) {
        return iservice.getEmployePrenomById(id);
    }

    @GET
    public List<Employe> getAllEmployes() {
        return iservice.getAllEmployes();
    }

    @DELETE
    @Path("/{idemp}")
    public void deleteEmploye(@PathParam("idemp") Long id) {
        iservice.deleteEmploye(id);
    }

    @PUT
    // @Path("/{idemp}")
    public Employe updateEmploye(@RequestBody Employe employe) {
        return iservice.updateEmploye(employe);
    }

    @PUT
    @Path("/{idemp}/{idcontrat}")
    public void affecterContratAEmploye(@PathParam("idcontrat") Long contratId, @PathParam("idemp") Long employeId) {
        iservice.affecterContratAEmploye(contratId, employeId);
    }
}
