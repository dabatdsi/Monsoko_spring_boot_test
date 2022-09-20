package com.gestionemployee.gestionemployee.repository;

import com.gestionemployee.gestionemployee.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository  extends JpaRepository<Users,Long> {
}
