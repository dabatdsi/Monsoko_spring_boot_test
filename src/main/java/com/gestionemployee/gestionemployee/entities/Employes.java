package com.gestionemployee.gestionemployee.entities;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
//import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



@Data
//@Builder
//@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name= "employes")
public class Employes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployes;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String adress;
    @Column(nullable = false)
    private String email;
    @Column(unique = true,nullable = false)
    private Long cni;
    @Column(unique = true,nullable = false)
    private int phoneNumber;
    @Column(nullable = false)
    private String postOccupe;
    /*@JsonBackReference
    @OneToMany(mappedBy = "employes",fetch=FetchType.EAGER)
    //@JoinColumn(name = "idEmployes")
    private List<Transaction> transaction ;
*/


}




