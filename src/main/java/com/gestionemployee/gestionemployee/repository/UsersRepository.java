package com.gestionemployee.gestionemployee.repository;

import com.gestionemployee.gestionemployee.dto.UsersDto;
import com.gestionemployee.gestionemployee.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import java.util.Optional;

@Repository
public interface UsersRepository  extends JpaRepository<Users,Long> {
    //Optional<Users> findByUsername(String name);
    public  UsersDto findByEmail(String email);
    public Users findByEmailAndPassword(String email, String password);



}
