package com.gestionemployee.gestionemployee.entities;

import lombok.*;
import org.hibernate.mapping.Collection;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;


//@Builder
@Data
//@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="transaction")
public class Transaction  {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idTrans;
    private ZonedDateTime datePayment;
    @Enumerated(EnumType.STRING)
     private StatusTrans status;
     private String description;
    @ManyToOne
    @JoinColumn(name="idEmployes",nullable = false)
    private Employes employes;
    @ManyToOne
    @JoinColumn(name="idUser",nullable = false)
    private Users users;



}
