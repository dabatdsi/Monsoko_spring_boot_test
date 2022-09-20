package com.gestionemployee.gestionemployee.service;

import com.gestionemployee.gestionemployee.dto.TransactionDto;
import com.gestionemployee.gestionemployee.entities.Transaction;

import java.util.List;

public interface TransactionService {
    //creation des methode
    List<Transaction> findAll();
     Transaction findById(Long idTrans);
    Transaction save(TransactionDto transDto);
    Transaction update( Long idTrans, TransactionDto transactionDto);

}
