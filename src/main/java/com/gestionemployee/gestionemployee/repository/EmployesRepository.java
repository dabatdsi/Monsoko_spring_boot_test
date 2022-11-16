package com.gestionemployee.gestionemployee.repository;

import com.gestionemployee.gestionemployee.entities.Employes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployesRepository extends JpaRepository<Employes,Long> {

}
