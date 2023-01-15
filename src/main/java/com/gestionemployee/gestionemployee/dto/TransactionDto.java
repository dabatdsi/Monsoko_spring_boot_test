package com.gestionemployee.gestionemployee.dto;

import com.gestionemployee.gestionemployee.entities.Employes;
import com.gestionemployee.gestionemployee.entities.PayBy;
import com.gestionemployee.gestionemployee.entities.Transaction;
import com.gestionemployee.gestionemployee.entities.TypeTrans;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

    private long idTrans;
    private ZonedDateTime datePayment;
    private PayBy statusPay;
    private TypeTrans statusType;
    private String description;
    private int montant;
    //private Long  userId;
    //private Employes employes;
    private long idEmployes;


    public static TransactionDto fromEntity(Transaction transaction) {
        if (transaction == null) {
            //TODO throw  on exception
            return null;
        }

        return TransactionDto.builder()
                .idTrans(transaction.getIdTrans())
                .datePayment((transaction.getDatePayment()))
                .statusPay(transaction.getStatusPay())
                .statusType(transaction.getStatusType())
                .description(transaction.getDescription())
                .montant(transaction.getMontant())
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
        transaction.setStatusPay(transactionDto.getStatusPay());
        transaction.setStatusType(transactionDto.getStatusType());
        transaction.setDescription(transactionDto.getDescription());
        transaction.setMontant(transactionDto.getMontant());

        return transaction;
    }


}
