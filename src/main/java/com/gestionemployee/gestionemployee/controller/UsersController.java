package com.gestionemployee.gestionemployee.controller;

import com.gestionemployee.gestionemployee.dto.UsersDto;
import com.gestionemployee.gestionemployee.entities.Users;
import com.gestionemployee.gestionemployee.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping(value = "/all")
    List<UsersDto> findAll(){
        return usersService.findAll();
    };

    @GetMapping(value = "/{idUser}")
    UsersDto findById(@PathVariable Long idUser){
        return usersService.findById(idUser);
    };

    @PostMapping(value = "/save")
    public UsersDto save(@RequestBody UsersDto usersDto) {
        return usersService.save(usersDto);
    }

    @PutMapping(path = "/update/{id}")
    UsersDto update(@PathVariable Long id,@RequestBody UsersDto usersDto){
        return usersService.update(id,usersDto);
    };

    @DeleteMapping(value = "/{idUser}")
    void delete(@PathVariable("idUser") Long idUser){
        usersService.delete(idUser);
    };
}
