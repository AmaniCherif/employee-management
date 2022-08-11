package org.acme.controller;


import org.acme.entity.Employe;
import org.acme.services.Iservice;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeResource {
    @Inject
    Iservice iservice;

    @Inject
    JsonWebToken jwt;

    @Inject
    @Claim(standard = Claims.birthdate)
    String birthdate;

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
    @Path("roles-allowed")
    @RolesAllowed({ "User", "Admin" })
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
    public Employe updateEmploye (@RequestBody Employe employe ) {
        return iservice.updateEmploye(employe);
    }
    @PUT
    @Path("/{idemp}/{idcontrat}")
    public void affecterContratAEmploye(@PathParam("idcontrat") Long contratId, @PathParam("idemp")Long employeId)
    {
        iservice.affecterContratAEmploye(contratId, employeId);
    }

    @GET
    @Path("roles-allowed-admin")
    @RolesAllowed("Admin")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloRolesAllowedAdmin(@Context SecurityContext ctx) {
        return getResponseString(ctx) + ", birthdate: " + birthdate;
    }

    private String getResponseString(SecurityContext ctx) {
        String name;
        if (ctx.getUserPrincipal() == null) {
            name = "anonymous";
        } else if (!ctx.getUserPrincipal().getName().equals(jwt.getName())) {
            throw new InternalServerErrorException("Principal and JsonWebToken names do not match");
        } else {
            name = ctx.getUserPrincipal().getName();
        }
        return String.format("hello + %s,"
                        + " isHttps: %s,"
                        + " authScheme: %s,"
                        + " hasJWT: %s",
                name, ctx.isSecure(), ctx.getAuthenticationScheme(), hasJwt());
    }

    private boolean hasJwt() {
        return jwt.getClaimNames() != null;
    }

}
