package com.gestionemployee.gestionemployee.service.implemente;
import com.gestionemployee.gestionemployee.dto.EmployesDto;
import com.gestionemployee.gestionemployee.dto.UsersDto;
import com.gestionemployee.gestionemployee.entities.Employes;
import com.gestionemployee.gestionemployee.entities.StatusTrans;
import com.gestionemployee.gestionemployee.entities.Transaction;
import com.gestionemployee.gestionemployee.dto.TransactionDto;
import com.gestionemployee.gestionemployee.entities.Users;
import com.gestionemployee.gestionemployee.exception.*;
import com.gestionemployee.gestionemployee.repository.TransactionRepository;
import com.gestionemployee.gestionemployee.service.TransactionService;
import com.gestionemployee.gestionemployee.validator.TransactionValidator;
import com.gestionemployee.gestionemployee.validator.UsersValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j // pour utilisation des log d'erreur

public class TransactionServiceImp  implements TransactionService {
    @Autowired
    //injection d'employes repository
    private TransactionRepository transactionRepository;
    @Autowired
    private UsersServiceImp usersServiceImp;
    @Autowired
    private EmployesServiceImp employesServiceImp;


    @Override
    public List<Transaction> findAll() {
        return  transactionRepository.findAll();
    }

    @Override
    public Transaction findById(Long  idTrans) {
        if(idTrans==null){
            log.error("Transacton null" );
            return null;
        }
        return transactionRepository.findById(idTrans)
                .orElseThrow(()->
                        new EntityNotFoundException("Aucun transaction n'a ete trouver avec l'ID" +
                                idTrans + ErrorsCode.TRANSACTION_NOT_FOUND));

    }

    @Override
    public Transaction save(TransactionDto transDto) {
        // il faut verifier si la transaction est valide
        List<String> errors = TransactionValidator.validate(transDto);
        if (!errors.isEmpty()) {
            log.error("Transaction non valide {}", transDto);
            throw new InvalidEntityException("La transaction  n'est pas valide",
                    ErrorsCode.TRANSACTION_NOT_VALID,errors);
        }
        Users users =UsersDto.toEntity(usersServiceImp.findById(transDto.getUserId()));
        if (users.equals(null))
            throw new EntityNotFoundException( "id user not found");
        Employes employes = EmployesDto.toEntity(employesServiceImp.findById(transDto.getEmployeId()));
        if (employes.equals(null))
            throw new EntityNotFoundException(" id emplyer not found");

       Transaction transaction =new Transaction();
       transaction.setDatePayment(ZonedDateTime.now());
       transaction.setUsers(users);
       transaction.setEmployes(employes);
       transaction.setStatus(transDto.getStatus());
       transaction.setDescription(transDto.getDescription());

        System.out.print("l'utilisateur est:"+transaction);

        return transactionRepository.save(transaction);
        //return TransactionDto.fromEntity(transactionRepository.save(TransactionDto.toEntity(transDto)));
    }

    @Override
    public Transaction update(Long idTrans,TransactionDto transactionDto) {
        Transaction transaction= transactionRepository.findById(idTrans).get();
        if (transaction.getStatus()==null) {
            throw new com.gestionemployee.gestionemployee.exception.EntityNotFoundException("id n'est pas present");
        }
        transaction.setStatus(transactionDto.getStatus());
        transaction.setDescription(transactionDto.getDescription());
        return transactionRepository.save(transaction);


    }



}
