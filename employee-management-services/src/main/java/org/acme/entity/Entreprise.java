package org.acme.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "entreprises")
public class Entreprise implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String raisonSocial;

    public Entreprise() {
        super();
    }

    public Entreprise(String name, String raisonSocial) {
        this.name = name;
        this.raisonSocial = raisonSocial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }
}
