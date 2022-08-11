package org.acme.controller;

import org.acme.entity.Contrat;
import org.acme.entity.Employe;
import org.acme.entity.request.ContractHttpEntity;
import org.acme.services.Iservice;
import org.apache.commons.beanutils.BeanUtils;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

@Path("/contrats")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContratResource {
    @Inject
    Iservice iservice;

    @POST
    public Long ajouterContrat(@RequestBody ContractHttpEntity contractHttpEntity) throws InvocationTargetException, IllegalAccessException {
        Employe employe = iservice.getEmployeById(contractHttpEntity.getEmployeeId());

        Contrat contrat = new Contrat();

        BeanUtils.copyProperties(contrat, contractHttpEntity);

        contrat.setEmploye(employe);

        iservice.ajouterContrat(contrat);
        return contrat.getReference();
    }

    @DELETE
    @Path("/{idcontrat}")
    public void deleteContratById(@PathParam("idcontrat") Long id) {
        iservice.deleteContratById(id);
    }

    @GET
    public List<ContractHttpEntity> getAllContrats() {

        return iservice.getAllContrats().stream().map(
                contrat -> {

                    ContractHttpEntity contractHttpEntity = new ContractHttpEntity();
                    try {
                        BeanUtils.copyProperties(contractHttpEntity, contrat);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }

                    if (contrat.getEmploye() != null) contractHttpEntity.setEmployeeId(contrat.getEmploye().getId());

                    return contractHttpEntity;
                }
        ).collect(Collectors.toList());
    }

    @PUT
    public Contrat updateContrat(@RequestBody ContractHttpEntity contractHttpEntity) throws InvocationTargetException, IllegalAccessException {
        Employe employe = iservice.getEmployeById(contractHttpEntity.getEmployeeId());

        Contrat contrat = new Contrat();

        BeanUtils.copyProperties(contrat, contractHttpEntity);

        contrat.setEmploye(employe);

        return iservice.updateContrat(contrat);
    }

}
