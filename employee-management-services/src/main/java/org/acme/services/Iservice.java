package org.acme.services;

import org.acme.entity.Contrat;
import org.acme.entity.Department;
import org.acme.entity.Employe;
import org.acme.entity.Entreprise;

import java.util.List;

public interface Iservice {

    Employe ajouterEmploye(Employe employe);

    List<Employe> getAllEmployes();

    String getEmployePrenomById(Long id);

    Employe getEmployeById(Long id);

    void deleteEmploye(Long id);

    Employe updateEmploye(Employe employe);

    List<Department> getAllDepartments();

    Department ajouterDepartment(Department department);

    Long ajouterEntreprise(Entreprise entreprise);

    void deleteEntrepriseById(Long id);

    Entreprise getEntrepriseById(Long id);

    Long ajouterContrat(Contrat contrat);

    void deleteContratById(Long id);

    List<Contrat> getAllContrats();

    void affecterContratAEmploye(Long contratId, Long employeId);

    Contrat updateContrat(Contrat contrat);

    void affecterDepartementAEntreprise(Long depId, Long entrepriseId);

    List<Entreprise> getAllEntreprises();
    Department updateDepartment(Department department);

    Entreprise updateEntreprise(Entreprise entreprise);
}
