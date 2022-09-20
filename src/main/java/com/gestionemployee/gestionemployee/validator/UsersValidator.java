package com.gestionemployee.gestionemployee.validator;
//import antlr.StringUtils;
import java.lang.String;
import com.gestionemployee.gestionemployee.dto.UsersDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UsersValidator {

    public static List<String> validate(UsersDto usersDto){
        List<String> errors = new ArrayList<>();
        //on faire un test   avec stringUtils.haslength permet de
        // convertir user tel qu'il est

       /* if(!StringUtils.hasLength(String.valueOf(usersDto.getIdUser()))) {
            errors.add("veillez renseigner l'identifiant de l'utilisateur");
        }*/
        if(!StringUtils.hasLength(usersDto.getFirstName())){
            errors.add("veillez renseigner le prenom l'utilisateur");
        }
        if(!StringUtils.hasLength(usersDto.getLastName())){
            errors.add("veillez renseigner le nom l'utilisateur");

        }
        if(!StringUtils.hasLength(usersDto.getAdress())){
            errors.add("veillez renseigner l'adress de  l'utilisateur");
        }
        if(!StringUtils.hasLength(String.valueOf(usersDto.getPhoneNumber()))){
            errors.add("veillez renseigner le numero de telephone de  l'utilisateur");
        }
        if(!StringUtils.hasLength(usersDto.getEmail())){
            errors.add("veillez renseigner l'email l'utilisateur");
        }
        if(!StringUtils.hasLength(usersDto.getUsername())){
            errors.add("veillez renseigner le login de l'utilisateur");
        }
        if(!StringUtils.hasLength(usersDto.getPassword())){
            errors.add("veillez renseigner le mot de passe de l'utilisateur");
        }


        return errors;
    }




}
