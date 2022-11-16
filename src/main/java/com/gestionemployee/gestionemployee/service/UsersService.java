package com.gestionemployee.gestionemployee.service;


import com.gestionemployee.gestionemployee.dto.UsersDto;
import com.gestionemployee.gestionemployee.entities.Users;

import java.util.List;
//import java.util.Optional;

public interface UsersService {
    //creation des methode
    List<UsersDto> findAll();
    UsersDto findById(Long idUser);
    UsersDto save(UsersDto usersDto);
    UsersDto update( Long idUser , UsersDto usersDto);
    void delete(Long idUser);

     UsersDto fechUsersByEmail(String email);


    Users fechUsersByEmailAndPassword(String tempEmail, String tempPass);
}
