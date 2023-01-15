package com.gestionemployee.gestionemployee.controller;

import com.gestionemployee.gestionemployee.dto.TransactionDto;
import com.gestionemployee.gestionemployee.dto.UsersDto;
import com.gestionemployee.gestionemployee.entities.Transaction;
import com.gestionemployee.gestionemployee.service.TransactionService;
import com.gestionemployee.gestionemployee.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/transaction")
public class TransactionController  {
    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/all")
    List<Transaction> findAll(){
        return transactionService.findAll();
    };
    
    @GetMapping(value = "/{idTrans}")
    Transaction findById(@PathVariable Long idTrans){
        return transactionService.findById(idTrans);
    };

    @PostMapping(value = "/save")
    public Transaction save(@RequestBody TransactionDto transactionDto) {
        return transactionService.save(transactionDto);
    }

    @PutMapping(path = "/update/{id}")
    Transaction update(@PathVariable Long idTrans,@RequestBody TransactionDto transactionDto){
        return transactionService.update(idTrans,transactionDto);
    };



    }





