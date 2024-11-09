package com.petrarca.residence.controller;

import com.petrarca.residence.DTO.PersonDTO;
import com.petrarca.residence.DTO.ResidenceDTO;
import com.petrarca.residence.service.PersonService;
import com.petrarca.residence.service.ResidenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
    private Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;
    @Autowired
    private ResidenceService residenceService;


    @CrossOrigin("*")
    @GetMapping("/getAll")
    public List<PersonDTO> getAllPerson(){
        logger.info("PersonController.getAllPerson");
        return personService.getAllPerson();
    }

    @CrossOrigin("*")
    @PostMapping("/getByResidence")
    public List<PersonDTO> getPersonByResidence(@RequestBody ResidenceDTO residenceDTO){
        logger.info("PersonController.getPersonByResidence residenceDTO: {}",residenceDTO);
        return residenceService.personByResidence(residenceDTO);
    }

    @CrossOrigin("*")
    @DeleteMapping("/delete")
    public void deletePerson(Long id){
        logger.info("PersonController.deletePerson id: {}",id);
        personService.delete(id);
    }




}
