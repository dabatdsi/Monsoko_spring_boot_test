package com.gestionemployee.gestionemployee.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestionemployee.gestionemployee.entities.Employes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployesDto {

    private long idEmployes;
    private String firstName;
    private String lastName;
    private String adress;
    private String email;
    private Long cni;
    private int phoneNumber;
    private String postOccupe;

// cette methode permer de faire un DTO

    public static EmployesDto  fromEntity(Employes employes) {
        if (employes == null) {
            // TODO throw on exception
            return null;
        }
        // de l"entite Employes vers l'entite EployesDto
        return EmployesDto.builder()
                .idEmployes(employes.getIdEmployes())
                .firstName(employes.getFirstName())
                .lastName(employes.getLastName())
                .adress(employes.getAdress())
                .email(employes.getEmail())
                .cni(employes.getCni())
                .phoneNumber(employes.getPhoneNumber())
                .postOccupe(employes.getPostOccupe())
                .build();
    }



    public static Employes toEntity(@Valid  EmployesDto employesDto){
       // this.employesDto = employesDto;
        if (employesDto == null) {
                // TODO throw on exception
                return  null;
                }
        Employes employes= new Employes();
            employes.setIdEmployes(employesDto.getIdEmployes());
            employes.setFirstName(employesDto.getFirstName());
            employes.setLastName(employesDto.getLastName());
            employes.setAdress(employesDto.getAdress());
            employes.setEmail(employesDto.getEmail());
            employes.setCni(employesDto.getCni());
            employes.setPhoneNumber(employesDto.getPhoneNumber());
            employes.setPostOccupe(employesDto.getPostOccupe());

        return employes;
    }



}



