package org.acme.services.Impl;

import org.acme.entity.*;
import org.acme.repository.*;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

import org.acme.services.Iservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class ServiceImpl implements Iservice {

    @Inject
    EmployeRepository employeRepository;
    @Inject
    DepartmentRepository departmentRepository;
    @Inject
    EntrepriseRepository entrepriseRepository;
    @Inject
    ContratRepository contratRepository;
    @Inject
    NotificationRepository notificationRepository;


    private static final Logger logger = LoggerFactory.getLogger(ServiceImpl.class);
    @Override
    public Employe ajouterEmploye(Employe employe) {
        return employeRepository.save(employe);

    }

    @Override
    public List<Employe> getAllEmployes() {
        return (List<Employe>) employeRepository.findAll();
    }

    @Override
    public String getEmployePrenomById(Long id) {
        Employe employe = employeRepository.findById(id).get();
        return employe.getPrenom();
    }

    @Override
    public void deleteEmploye(Long id) {
        employeRepository.deleteById(id);

    }

    @Override
    public Employe updateEmploye(Employe employe) {
        Employe employeAdded = employeRepository.save(employe);
        return employeAdded;
    }

    @Override
    public List<Department> getAllDepartments() {
        return (List<Department>) departmentRepository.findAll();
    }

    @Override
    public Department ajouterDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Long ajouterEntreprise(Entreprise entreprise) {
        entrepriseRepository.save(entreprise);
        return entreprise.getId();
    }

    @Override
    public void deleteEntrepriseById(Long id) {
        entrepriseRepository.delete(entrepriseRepository.findById(id).get());
    }

    @Override
    public Entreprise getEntrepriseById(Long id) {
        return entrepriseRepository.findById(id).get();

    }

    @Override
    public Long ajouterContrat(Contrat contrat) {
        contratRepository.save(contrat);
        return contrat.getReference();
    }

    @Override
    public void deleteContratById(Long id) {
        Contrat contrat = contratRepository.findById(id).get();
        contratRepository.delete(contrat);
    }

    @Override
    public List<Contrat> getAllContrats() {
        return (List<Contrat>) contratRepository.findAll();
    }

    @Override
    public void affecterContratAEmploye(Long contratId, Long employeId) {
        Contrat c = contratRepository.findById(contratId).get();
        Employe e = employeRepository.findById(employeId).get();
        c.setEmploye(e);
        contratRepository.save(c);
    }

    @Override
    public Contrat updateContrat(Contrat contrat) {
        return null;
    }


}
