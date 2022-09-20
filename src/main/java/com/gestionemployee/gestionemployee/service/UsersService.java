package com.gestionemployee.gestionemployee.service;


import com.gestionemployee.gestionemployee.dto.UsersDto;

import java.util.List;

public interface UsersService {
    //creation des methode
    List<UsersDto> findAll();
    UsersDto findById(Long idUser);
    UsersDto save(UsersDto usersDto);
    UsersDto update( Long idUser , UsersDto usersDto);
    void delete(Long idUser);
}
