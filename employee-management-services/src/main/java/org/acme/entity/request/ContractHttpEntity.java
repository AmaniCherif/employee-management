package org.acme.entity.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ContractHttpEntity {
    private Long reference;
    private Date dateDebut;
    private Date dateFin;
    private String typeContrat;
    private float telephone;
    private float salaire;
    private Long employeeId;
}
