package com.gestionemployee.gestionemployee.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
    @Getter
    private  ErrorsCode errorsCode;

    //public EntityNotFoundException() {
      // super();
   //}

    public EntityNotFoundException(String message) {
        super(message );
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public EntityNotFoundException(String message, Throwable cause,ErrorsCode errorsCode) {
        super(message, cause);
        this.errorsCode = errorsCode;
    }
    public EntityNotFoundException(String message,ErrorsCode errorsCode) {
        super(message);
        this.errorsCode = errorsCode;
    }
}
