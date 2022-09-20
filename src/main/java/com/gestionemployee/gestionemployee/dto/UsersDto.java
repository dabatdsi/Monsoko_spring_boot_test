package com.gestionemployee.gestionemployee.dto;

import com.gestionemployee.gestionemployee.entities.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {

    private Long  idUser;
    private String firstName;
    private String lastName;
    private String adress;
    private int phoneNumber;
    private String email;
    private String username;
    private String password;


    // private List<UsersDto> users;

    // mapping de l'entite vers le DTO
    public static UsersDto fromEntity(Users users) {
        if (users == null) {
            // TODO throw on exception
            return null;
        }
        return UsersDto.builder()
                .idUser(users.getIdUser())
                .firstName(users.getFirstName())
                .lastName(users.getLastName())
                .adress(users.getAdress())
                .phoneNumber(users.getPhoneNumber())
                .email(users.getEmail())
                .username(users.getUsername())
                .password(users.getPassword())
                .build();
    }
    //mapping de DTO vers l'entite
   public static Users toEntity(UsersDto usersDto){
       if (usersDto == null) {
           // TODO throw on exception
           return  null;
       }
       Users users = new Users ();

       users.setIdUser(usersDto.getIdUser());

       users.setFirstName(usersDto.getFirstName());
       users.setLastName(usersDto.getLastName());
       users.setAdress(usersDto.getAdress());
       users.setPhoneNumber(usersDto.getPhoneNumber());
       users.setEmail(usersDto.getEmail());
       users.setUsername(usersDto.getUsername());
       users.setPassword(usersDto.getPassword());

       return users;
   }
}
