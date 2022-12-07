package com.gestionemployee.gestionemployee.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idUser;
    private  String userId;
    @Column(nullable = false , updatable = false)
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
   /*private Date lastLoginDate;
   private Date lastLoingDateDisplaye ;
   private Date jointDate;*/
    private String[] role ; // role_user { read edit }et role_admin ( delede)
    private String[] authorities;
     private boolean isActive;
     private boolean isNotlocked ;

}
