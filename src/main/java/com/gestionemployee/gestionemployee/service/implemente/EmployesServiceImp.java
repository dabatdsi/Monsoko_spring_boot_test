package com.gestionemployee.gestionemployee.service.implemente;
import com.gestionemployee.gestionemployee.dto.EmployesDto;
import com.gestionemployee.gestionemployee.dto.UsersDto;
import com.gestionemployee.gestionemployee.entities.Employes;
import com.gestionemployee.gestionemployee.entities.Users;
import com.gestionemployee.gestionemployee.exception.ErrorsCode;
import com.gestionemployee.gestionemployee.exception.InvalidEntityException;
import com.gestionemployee.gestionemployee.repository.EmployesRepository;
import com.gestionemployee.gestionemployee.service.EmployesService;
import com.gestionemployee.gestionemployee.validator.EmployesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j //pour utilisation des log d'erreur
public class EmployesServiceImp<optional> implements EmployesService {
    @Autowired
    //injection d'employes repository
    private EmployesRepository employesRepository;

    @Override
    public List<EmployesDto> findAll() {
        return employesRepository.findAll().stream()
                .map(EmployesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public EmployesDto findById(Long idEmployes) {
        if (idEmployes == null) {
            log.error("Employes n'a pas  d'identifiant");
            return null;
        }
        return employesRepository.findById(idEmployes)
                .map(EmployesDto::fromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Aucun employe n'a ete trouver avec l'ID" + idEmployes + ErrorsCode.EMPLOYEES_NOT_FOUND));
    }

    @Override
    public EmployesDto save(EmployesDto empDto) {
        // il faut verifier si la transaction est valide
        List<String> errors = EmployesValidator.validate(empDto);
        if (!errors.isEmpty()) {
            log.error("enregistrement non valide {}", empDto);
            throw new InvalidEntityException("L'enregistrement  n'est pas valide",
                    ErrorsCode.EMPLOYEES_NOT_VALID, errors);
        }
        Employes savedEmployes = EmployesDto.toEntity(empDto);
        System.out.print("l'Employes est:"+savedEmployes);
        return EmployesDto.fromEntity(employesRepository.save(savedEmployes));
    }


    @Override
    public EmployesDto update(@PathVariable("idEmployes") Long idEmployes, @Valid EmployesDto empDto) {
        Employes employes = employesRepository.findById(idEmployes).get();
        if (employes.getEmail()==null) {
            throw new com.gestionemployee.gestionemployee.exception.EntityNotFoundException("id n'est pas present");
        }
        employes.setFirstName(empDto.getFirstName());
        employes.setLastName(empDto.getLastName());
        employes.setAdress(empDto.getAdress());
        employes.setEmail(empDto.getEmail());
        employes.setCni(empDto.getCni());
        employes.setPhoneNumber(empDto.getPhoneNumber());
        employes.setPostOccupe(empDto.getPostOccupe());
        return EmployesDto.fromEntity(employesRepository.save(employes));
    }



    @Override

    public EmployesDto delete(Long idEmployes) {
        if(idEmployes==null) {
            log.error("Employes n'a pas  d'identifian");
            return null;
        }
        employesRepository.deleteById(idEmployes);
        return null;
    }
}
