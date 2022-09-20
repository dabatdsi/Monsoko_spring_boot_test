package com.gestionemployee.gestionemployee.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestionemployee.gestionemployee.entities.StatusTrans;
import com.gestionemployee.gestionemployee.entities.Transaction;
import com.gestionemployee.gestionemployee.service.implemente.TransactionServiceImp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

    private long idTrans;
    private ZonedDateTime datePayment;
    private StatusTrans status;
    private String description;
    private Long  userId;
    private Long employeId;


    public static TransactionDto fromEntity(Transaction transaction) {
        if (transaction == null) {
            //TODO throw  on exception
            return null;
        }

        return TransactionDto.builder()
                .idTrans(transaction.getIdTrans())
                .datePayment((transaction.getDatePayment()))
                .status(transaction.getStatus())
                .description(transaction.getDescription())
                .build();

    }

    public static Transaction toEntity(TransactionDto transactionDto) {
        if (transactionDto == null) {
            return null;
            //TODO throw  on exception

        }
        Transaction transaction = new Transaction();
        transaction.setIdTrans(transactionDto.getIdTrans());
        transaction.setDatePayment(transactionDto.getDatePayment());
        transaction.setStatus(transactionDto.getStatus());
        transaction.setDescription(transactionDto.getDescription());

        return transaction;
    }


}
