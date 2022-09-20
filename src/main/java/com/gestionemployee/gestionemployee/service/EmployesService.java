package com.gestionemployee.gestionemployee.service;

import com.gestionemployee.gestionemployee.dto.EmployesDto;

import java.util.List;

public interface EmployesService {
    //creation des methode
     List<EmployesDto> findAll();
     EmployesDto findById(Long idEmployes);
    EmployesDto save(  EmployesDto empDto);
    EmployesDto update(Long idEmployes , EmployesDto empDto);
    EmployesDto delete(Long idEmployes);



}
