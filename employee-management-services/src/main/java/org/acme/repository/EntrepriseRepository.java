package org.acme.repository;

import org.acme.entity.Entreprise;
import org.springframework.data.repository.CrudRepository;

public interface EntrepriseRepository extends CrudRepository<Entreprise,Long> {
}
