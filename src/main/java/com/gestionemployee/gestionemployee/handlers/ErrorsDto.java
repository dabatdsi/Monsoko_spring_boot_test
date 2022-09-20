package com.gestionemployee.gestionemployee.handlers;

import com.gestionemployee.gestionemployee.exception.ErrorsCode;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorsDto {
    private int httpCode; //http code 404 OU 403
    private ErrorsCode code;
    private String message;
    private List<String> errors = new ArrayList<>();

}
