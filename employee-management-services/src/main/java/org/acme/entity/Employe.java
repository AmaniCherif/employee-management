package org.acme.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "employes")
public class Employe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prenom;

    private String nom;

    private String email;

    private String password;

    private boolean actif;

    @Enumerated(EnumType.STRING)
    private Role role;


    public Employe() {
        super();
    }


    public Employe(Long id, String prenom, String nom, String email, String password, boolean actif, Role role) {
        super();
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.actif = actif;
        this.role = role;
    }

    public Employe(String nom, String prenom, String email, String password, boolean actif, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.actif = actif;
        this.role = role;
    }

    public Employe(String nom, String prenom, String email, boolean actif, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.actif = actif;
        this.role = role;
    }


    @Override
    public String toString() {
        return "Employe [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", email=" + email + ", password="
                + password + ", actif=" + actif + ", role=" + role + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
