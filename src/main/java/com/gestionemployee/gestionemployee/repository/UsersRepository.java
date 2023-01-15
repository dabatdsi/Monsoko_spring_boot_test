package com.gestionemployee.gestionemployee.repository;

import com.gestionemployee.gestionemployee.dto.UsersDto;
import com.gestionemployee.gestionemployee.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//import java.util.Optional;

@Repository
public interface UsersRepository  extends JpaRepository<Users,Long> {
    //Optional<Users> findByUsername(String name);
    public  UsersDto findByEmail(String email);
    UsersDto findByUsername(String username);

    public Users findByUsernameAndPassword(String username, String password);
    Optional<UsersDto> findByUsernameOrEmail(String username, String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);



}
