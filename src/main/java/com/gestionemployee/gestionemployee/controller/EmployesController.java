package com.gestionemployee.gestionemployee.controller;
import com.gestionemployee.gestionemployee.dto.EmployesDto;
import com.gestionemployee.gestionemployee.dto.UsersDto;
import com.gestionemployee.gestionemployee.service.EmployesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
public class EmployesController  {
    @Autowired
    private EmployesService employesService;

    @GetMapping(value = "/all")
    List<EmployesDto> findAll(){
        return employesService.findAll();
    };

    @GetMapping(value = "/{idEmploye}")
    EmployesDto findById(@PathVariable Long idUser){
        return employesService.findById(idUser);
    };

    @PostMapping(value = "/save")
    public EmployesDto save(@RequestBody EmployesDto employesDto) {
        return employesService.save(employesDto);
    }

    @PutMapping(path = "/update/{id}")
    EmployesDto update(@PathVariable Long id,@RequestBody EmployesDto employesDto){
        return employesService.update(id,employesDto);
    };

    @DeleteMapping(value = "/{idEmployes}")
    void delete(@PathVariable("idEmployes") Long idEmployes){
        employesService.delete(idEmployes);
    };


}
