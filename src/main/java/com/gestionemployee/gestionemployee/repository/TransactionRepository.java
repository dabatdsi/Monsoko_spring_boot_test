package com.gestionemployee.gestionemployee.repository;

import com.gestionemployee.gestionemployee.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepository extends JpaRepository<Transaction ,Long > {


}
