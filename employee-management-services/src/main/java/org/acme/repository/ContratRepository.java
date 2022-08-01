package org.acme.repository;

import org.acme.entity.Contrat;
import org.springframework.data.repository.CrudRepository;

public interface ContratRepository extends CrudRepository<Contrat,Long> {
}
