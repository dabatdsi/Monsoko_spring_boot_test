package com.gestionemployee.gestionemployee.exception;

public enum ErrorsCode {
    EMPLOYEES_NOT_FOUND(1000),
    USERS_NOT_FOUND(2000),



    TRANSACTION_NOT_VALID(3000), TRANSACTION_NOT_FOUND(4000), EMPLOYEES_NOT_VALID(5000), USERS_NOT_VALID(6000);


    //TODO complete the rest of rhe Error Codes
    private int code;
    ErrorsCode(int code){

    }

    public int getCode() {
        return code;
    }
}
