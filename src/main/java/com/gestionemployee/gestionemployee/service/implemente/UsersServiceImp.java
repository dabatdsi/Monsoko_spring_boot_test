package com.gestionemployee.gestionemployee.service.implemente;

import com.gestionemployee.gestionemployee.dto.UsersDto;
import com.gestionemployee.gestionemployee.entities.Users;
import com.gestionemployee.gestionemployee.exception.EntityNotFoundException;
import com.gestionemployee.gestionemployee.exception.ErrorsCode;
import com.gestionemployee.gestionemployee.exception.InvalidEntityException;
import com.gestionemployee.gestionemployee.repository.UsersRepository;
import com.gestionemployee.gestionemployee.service.UsersService;
import com.gestionemployee.gestionemployee.validator.UsersValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class UsersServiceImp implements UsersService {
    @Autowired
    private UsersRepository usersRepository;
    /*@Autowired
    private AppRoleRepository appRoleRepository;*/
    /*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
*/

    @Override
    public List<UsersDto> findAll() {
        return usersRepository.findAll().stream()
                .map(UsersDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UsersDto findById(Long idUser) {
        if (idUser == null) {
            log.error("l'utilisateur n'a pas  d'identifian");
            return null;
        }
        return usersRepository.findById(idUser)
                .map(UsersDto::fromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Aucun employe n'a ete trouver avec l'ID" + idUser + ErrorsCode.USERS_NOT_FOUND));
    }

    @Override
    public UsersDto save(UsersDto usDto) {
        //pour encrypter le password
        //String hashPW=bCryptPasswordEncoder.encode(usDto.getPassword());
        //usDto.setPassword(hashPW);

        // il faut verifier si la transaction est valide
        List<String> errors = UsersValidator.validate(usDto);
        if (!errors.isEmpty()) {
            log.error("enregistrement non valide {}", usDto);
            throw new InvalidEntityException("L'enregistrement  n'est pas valide",
                    ErrorsCode.USERS_NOT_VALID, errors);
        }
        Users savedUsers = UsersDto.toEntity(usDto);
        System.out.print("l'utilisateur est:" + savedUsers);
        return UsersDto.fromEntity(usersRepository.save(savedUsers));
    }

   /* @Override
    public AppRole addNewRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        UsersDto usersDto =usersRepository.findByUsername(username);
        AppRole role= appRoleRepository.findByRoleName(roleName);
        usersDto.getAppRoles().add(role);

    }*/

    @Override
    public UsersDto loadUserByUsername(String username) {
       return usersRepository.findByUsername(username);
    }

    @Override
    public UsersDto update(Long idUser, UsersDto usersDto) {
        Users user = usersRepository.findById(idUser).get();
        if (user.getEmail() == null) {
            throw new EntityNotFoundException("id n'est pas present");
        }
        user.setUsername(usersDto.getUsername());
        user.setFirstName(usersDto.getFirstName());
        user.setLastName(usersDto.getLastName());
        user.setEmail(usersDto.getEmail());
        user.setAdress(usersDto.getAdress());
        user.setPhoneNumber(usersDto.getPhoneNumber());
        user.setPassword(usersDto.getPassword());
        return UsersDto.fromEntity(usersRepository.save(user));

    }

    @Override
    public void delete(Long idUser) {
        if (idUser == null) {
            log.error("l'utilisateur n'a pas  d'identifian");
        }
        usersRepository.deleteById(idUser);
    }

    @Override
    public UsersDto fechUsersByUsername(String username) {
        return  usersRepository.findByUsername(username);
    }

    @Override
    public Users fechUsersByEmailAndPassword(String tempEmail, String tempPass) {
        return null;
    }


   public Users fechUsersByUsernameAndPassword(String username, String password) {
        return usersRepository.findByUsernameAndPassword(username, password);
    }



}
