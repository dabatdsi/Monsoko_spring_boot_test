package com.gestionemployee.gestionemployee.controller;
import com.gestionemployee.gestionemployee.dto.EmployesDto;
import com.gestionemployee.gestionemployee.dto.UsersDto;
import com.gestionemployee.gestionemployee.service.EmployesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/employes")
public class EmployesController  {
    @Autowired
    private EmployesService employesService;

    @GetMapping(value = "/all")
    List<EmployesDto> findAll(){
        return employesService.findAll();
    };

    @GetMapping(path = "/{id}")
    EmployesDto findById(@PathVariable Long id){
        return employesService.findById(id);
//                orElseThrow(() -> new ResourceNotFoundException("l'employes not exit whit id:"+ idEmployes));
        // return emplpyesRepository.ok(employes);

    }

    @PostMapping(value = "/save")
    public EmployesDto save(@RequestBody EmployesDto employesDto) {
        return employesService.save(employesDto);
    }

    @PutMapping(path = "/update/{id}")
    EmployesDto update(@PathVariable Long id,@RequestBody EmployesDto employesDto){
        return employesService.update(id,employesDto);
    };

    @DeleteMapping(path = "/{idEmployes}")
    void delete(@PathVariable("idEmployes") Long idEmployes){
        employesService.delete(idEmployes);
    };



}
