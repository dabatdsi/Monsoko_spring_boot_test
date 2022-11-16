package com.gestionemployee.gestionemployee.controller;
import com.gestionemployee.gestionemployee.dto.UsersDto;
import com.gestionemployee.gestionemployee.entities.Users;
import com.gestionemployee.gestionemployee.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import static org.hibernate.id.enhanced.StandardOptimizerDescriptor.log;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping(value = "/all")
    List<UsersDto> findAll() {
        return usersService.findAll();
    }

    ;

    @GetMapping(value = "/{idUser}")
    UsersDto findById(@PathVariable Long idUser) {
        return usersService.findById(idUser);
    }

    ;

    @PostMapping(value = "/save")
    public UsersDto save(@RequestBody UsersDto usersDto) {
        return usersService.save(usersDto);
    }

    @PutMapping(path = "/update/{id}")
    UsersDto update(@PathVariable Long id, @RequestBody UsersDto usersDto) {
        return usersService.update(id, usersDto);
    }

    ;

    @DeleteMapping(value = "/{idUser}")
    void delete(@PathVariable("idUser") Long idUser) {
        usersService.delete(idUser);
    }



    @PostMapping(path= "/register")

    public UsersDto registerUsers(@RequestBody UsersDto usersDto) throws Exception {
        String tempEmail = usersDto.getEmail();
        Object tempEmai = null;
        if (tempEmai != null && !"".equals(tempEmail)) {
            UsersDto usersObj = usersService.fechUsersByEmail(tempEmail);

            //pour eviter de creer un compte avec le meme email

            if (usersObj != null) {
                throw new Exception("cet user avec email" + tempEmail + "existe déja");
            }
        }
           UsersDto usersObj = null;
           usersObj = usersService.save(usersDto);
           return usersObj;

        }
    @PostMapping(path= "/login")
    public  Users loginUsers(@RequestBody Users users) throws Exception {
        String tempEmail = users.getEmail();
        String tempPass = users.getPassword();
        Users usersObj=null;
        if(tempEmail!= null && tempPass!= null ){
            usersObj=  usersService.fechUsersByEmailAndPassword(tempEmail,tempPass);


        }
        if(usersObj == null){
            throw new Exception("mauvais identité");
        }

        return usersObj;
    }


}






