package com.gestionemployee.gestionemployee.validator;

import com.gestionemployee.gestionemployee.dto.EmployesDto;
import com.gestionemployee.gestionemployee.dto.TransactionDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TransactionValidator {

    public static List<String> validate(TransactionDto transactionDto) {
        List<String> errors = new ArrayList<>();
        //on faire un test   avec stringUtils.haslength permet de
        // convertir user tel qu'il est
        /*
        if (!StringUtils.hasLength(String.valueOf(transactionDto.getIdTrans()))) {
            errors.add("la transaction est null");
        }*/
        if (!StringUtils.hasLength(String.valueOf(transactionDto.getDatePayment()))) {
            errors.add("veillez renseigner la date de la transaction");

        }

        if (!StringUtils.hasLength(String.valueOf(transactionDto.getStatusPay()))) {
            errors.add("veillez energiser  le payBy de la transaction");

        }
        if (!StringUtils.hasLength(String.valueOf(transactionDto.getStatusType()))) {
            errors.add("veillez energiser le type de la transaction");

        }
        if (!StringUtils.hasLength(String.valueOf(transactionDto.getDescription()))) {
            errors.add("revoir la description");
        }
        return errors;
    }
}

