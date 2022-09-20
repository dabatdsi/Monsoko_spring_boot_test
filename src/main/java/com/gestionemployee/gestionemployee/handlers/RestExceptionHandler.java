package com.gestionemployee.gestionemployee.handlers;
import com.gestionemployee.gestionemployee.exception.InvalidEntityException;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.persistence.EntityNotFoundException;
import com.gestionemployee.gestionemployee.handlers.ErrorsDto;
import com.gestionemployee.gestionemployee.exception.ErrorsCode;
@RestControllerAdvice
@Builder
// cette classe permet de lever l'exception general
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    //public     ErrorsDto errorsDto;

    @ExceptionHandler(EntityNotFoundException.class)
    public  ResponseEntity<ErrorsDto> handlerException(EntityNotFoundException exception
            , WebRequest webRequest){
        final HttpStatus notFound = HttpStatus.NOT_FOUND;

         final    ErrorsDto errorsDto= ErrorsDto.builder()
              // .code(exception.getErrorsCode ())
                .httpCode(notFound.value())
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(errorsDto , notFound);
    }
    @ExceptionHandler(InvalidEntityException.class)
    public  ResponseEntity<ErrorsDto> handlerException( InvalidEntityException exception , WebRequest webRequest){
        final HttpStatus badRequest= HttpStatus.BAD_REQUEST;

       final  ErrorsDto errorsDto = ErrorsDto.builder()
               .code(exception.getErrorsCode ())
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(errorsDto , badRequest);
    }
}
