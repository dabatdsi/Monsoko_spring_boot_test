package com.gestionemployee.gestionemployee.validator;

import com.gestionemployee.gestionemployee.dto.EmployesDto;
//import antlr.StringUtils;
import java.lang.String;
import java.util.ArrayList;
import org.springframework.util.StringUtils;
import java.util.List;

public class EmployesValidator  {

    public static List<String> validate(EmployesDto employesDto) {
        List<String> errors = new ArrayList<>();
        //on faire un test   avec stringUtils.haslength permet de
        // convertir user tel qu'il est

         if (!StringUtils.hasLength(employesDto.getFirstName())) {
            errors.add("veillez energiser le nom de l'utilisateur");
        }
            if (!StringUtils.hasLength(employesDto.getLastName())) {
                errors.add("veillez renseigner le prenom de l'utilisateur");
            }
        if (employesDto.getAdress()==null || !StringUtils.hasLength(employesDto.getAdress())) {
            errors.add("veillez renseigner l'adresse de l'utilisateur");
        }
            if (!StringUtils.hasLength(employesDto.getEmail())) {
                errors.add("veillez renseigner l'email de l'utilisateur");
            }
            if (!StringUtils.hasLength(String.valueOf(employesDto.getCni()))) {
                errors.add("veillez renseigner numero cni de l'utilisateur");
            }
        if (!StringUtils.hasLength(String.valueOf(employesDto.getPhoneNumber()))) {
            errors.add("veillez renseigner numero de telephone de l'utilisateur");
        }
        if (!StringUtils.hasLength(employesDto.getPostOccupe())) {
            errors.add("veillez renseigner les fonctions de l'utilisateur");
        }

        //errors.add("veillez renseigner le nom de l'utilisateur");

        return errors;
    }
}
