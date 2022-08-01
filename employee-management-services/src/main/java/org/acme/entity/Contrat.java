package org.acme.entity;

import lombok.ToString;
import org.acme.entity.listener.ContratListener;

import javax.enterprise.context.RequestScoped;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "contrats")
@EntityListeners(ContratListener.class)
@ToString
@RequestScoped
public class Contrat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reference;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    private String typeContrat;
    private float telephone;
    private float salaire;
    @OneToOne
    private Employe employe;

    public Contrat() {
        super();
    }

    public Contrat(Date dateDebut, Date dateFin, String typeContrat, float salaire) {
        this.dateDebut = dateDebut;
        this.typeContrat = typeContrat;
        this.salaire = salaire;
        this.dateFin = dateFin;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Long getReference() {
        return reference;
    }

    public void setReference(Long reference) {
        this.reference = reference;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public float getTelephone() {
        return telephone;
    }

    public void setTelephone(float telephone) {
        this.telephone = telephone;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}
