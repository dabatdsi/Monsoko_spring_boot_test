package com.gestionemployee.gestionemployee.entities;

import lombok.Data;

import javax.persistence.*;

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
}
