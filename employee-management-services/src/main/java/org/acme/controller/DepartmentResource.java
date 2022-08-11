package org.acme.controller;


import lombok.extern.slf4j.Slf4j;
import org.acme.entity.Contrat;
import org.acme.entity.Department;
import org.acme.entity.Employe;
import org.acme.entity.Entreprise;
import org.acme.entity.request.ContractHttpEntity;
import org.acme.entity.request.DepartmentHttpEntity;
import org.acme.services.Iservice;
import org.apache.commons.beanutils.BeanUtils;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

@Path("/departments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Slf4j
public class DepartmentResource {
    @Inject
    Iservice iservice;

    @GET
    public List<DepartmentHttpEntity> getAllDepartments() {
        return iservice.getAllDepartments().stream().map(
                department -> {

                    DepartmentHttpEntity departmentHttpEntity = new DepartmentHttpEntity();
                    try {
                        BeanUtils.copyProperties(departmentHttpEntity, department);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }

                    if (department.getEntreprises() != null)
                        departmentHttpEntity.setEntrepriseId(department.getEntreprises().getId());

                    return departmentHttpEntity;
                }
        ).collect(Collectors.toList());
    }

    @POST
    public Long ajouterDepartment(@RequestBody DepartmentHttpEntity departmentHttpEntity)  throws InvocationTargetException, IllegalAccessException{
        log.info("eee {}", departmentHttpEntity.getId());
        Entreprise entreprise = iservice.getEntrepriseById(departmentHttpEntity.getEntrepriseId());

        Department department = new Department();

        BeanUtils.copyProperties(department, departmentHttpEntity);

        department.setEntreprises(entreprise);

        iservice.ajouterDepartment(department);

        return department.getId();
    }
    @PUT
    public Department updateDepartment(@RequestBody DepartmentHttpEntity departmentHttpEntity) throws InvocationTargetException, IllegalAccessException {
        Entreprise entreprise = iservice.getEntrepriseById(departmentHttpEntity.getEntrepriseId());

        Department department = new Department();

        BeanUtils.copyProperties(department, departmentHttpEntity);

        department.setEntreprises(entreprise);

        return iservice.updateDepartment(department);
    }

}

