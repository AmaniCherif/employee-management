package org.acme.repository;

import org.acme.entity.Employe;
import org.springframework.data.repository.CrudRepository;

public interface EmployeRepository extends CrudRepository<Employe,Long> {
}
