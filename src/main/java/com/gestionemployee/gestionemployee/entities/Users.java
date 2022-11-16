package com.gestionemployee.gestionemployee.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idUser;
    @Column(nullable = false)
    private String firstName ;
    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private  String adress ;
    @Column(unique = true,nullable = false)
    private int  phoneNumber;
    @Column(unique = true,nullable = false)
    private  String email;
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    /*@JsonBackReference
    @OneToMany(mappedBy = "users")
    //@JoinColumn(name = "iUser")
    private List<Transaction> transaction ;*/
}
