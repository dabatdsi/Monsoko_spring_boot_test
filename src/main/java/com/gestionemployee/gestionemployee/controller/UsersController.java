package com.gestionemployee.gestionemployee.controller;

import com.gestionemployee.gestionemployee.dto.UsersDto;
import com.gestionemployee.gestionemployee.entities.Users;
import com.gestionemployee.gestionemployee.service.implemente.UsersServiceImp;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import static org.hibernate.id.enhanced.StandardOptimizerDescriptor.log;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private UsersServiceImp usersService;

   // @PreAuthorize()
    @GetMapping(value = "/all")
   // @PostAuthorize("hasAuthority('USER')")
    List<UsersDto> findAll() {
        return usersService.findAll();
    }
    ;
    @GetMapping(value = "/{idUser}")
    //@PostAuthorize("hasAuthority('USER')")
    UsersDto findById(@PathVariable Long idUser) {
        return usersService.findById(idUser);
    }
    ;

    @PostMapping(value = "/save")
    //@PostAuthorize("hasAuthority('ADMIN')")
    public UsersDto save(@RequestBody UsersDto usersDto) {
        return usersService.save(usersDto);
    }




    @PutMapping(path = "/update/{id}")
    //@PostAuthorize("hasAuthority('ADMIN')")
    UsersDto update(@PathVariable Long id, @RequestBody UsersDto usersDto) {
        return usersService.update(id, usersDto);
    }

    ;

    @DeleteMapping(value = "/{idUser}")
   // @PostAuthorize("hasAuthority('ADMIN')")
    void delete(@PathVariable("idUser") Long idUser) {
        usersService.delete(idUser);
    }


   /* @PostMapping(path= "/register")
    @CrossOrigin( origins = "http://localhost:4200/")
    public UsersDto registerUsers(@RequestBody UsersDto usersDto) throws Exception {
        String tempUsername = usersDto.getUsername();
        //Object tempUsername = null;
        if (tempUsername != null && !"".equals(tempUsername)) {
            UsersDto usersObj = usersService.fechUsersByUsername((String) tempUsername);
            //pour eviter de creer un compte avec le meme user
            if (usersObj != null) {
                throw new Exception("cet user avec username" + tempUsername + "existe déja");
            }
        }
           UsersDto usersObj = null;
           usersObj = usersService.save(usersDto);
           return usersObj;
        }*/
  /*@PostMapping(path= "/login")
    public Users loginUsers(@RequestBody Users users) throws Exception {
        String tempUsername = users.getUsername();
        String tempPass = users.getPassword();
        Users usersObj=null;
        Object username = null;
        if(tempUsername!= null && tempPass!= null ){
            usersObj= usersService.fechUsersByUsernameAndPassword(tempUsername,tempPass);
        }
        if(usersObj == null){
            throw new Exception("mauvais identité");
        }
        return usersObj;
    }*/

}






