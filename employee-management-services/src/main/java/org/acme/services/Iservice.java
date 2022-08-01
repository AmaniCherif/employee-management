package org.acme.services;

import org.acme.entity.*;

import java.util.List;

public interface Iservice {

    public Employe ajouterEmploye(Employe employe);

    public List<Employe> getAllEmployes();

    public String getEmployePrenomById(Long id);

    public void deleteEmploye(Long id);

    public Employe updateEmploye(Employe employe);

    public List<Department> getAllDepartments();

    public Department ajouterDepartment(Department department);

    public Long ajouterEntreprise(Entreprise entreprise);

    public void deleteEntrepriseById(Long id);

    public Entreprise getEntrepriseById(Long id);

     public Long ajouterContrat(Contrat contrat);

     public void deleteContratById(Long id);

     public List<Contrat> getAllContrats();

     public void affecterContratAEmploye(Long contratId, Long employeId);

    public Contrat updateContrat(Contrat contrat);



}
