package org.acme.controller;


import org.acme.entity.Department;
import org.acme.entity.Employe;
import org.acme.services.Iservice;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/departments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartmentResource {
    @Inject
    Iservice iservice;

    @GET
    public List<Department> getAllDepartments() {
        return iservice.getAllDepartments();
    }
    @POST
    public Department ajouterDepartment(@RequestBody Department department) {
        return iservice.ajouterDepartment(department);
    }
}

