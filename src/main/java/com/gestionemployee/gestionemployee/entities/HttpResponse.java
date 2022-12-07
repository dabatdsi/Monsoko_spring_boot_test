package com.gestionemployee.gestionemployee.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;



@Data @AllArgsConstructor @NoArgsConstructor
public class HttpResponse {
    private int httpStatusCode;// 200 , 201 ,400,500
    private HttpStatus httpStatus;
    private String reason;
    private String message;

}
