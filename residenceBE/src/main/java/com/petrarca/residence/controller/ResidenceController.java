package com.petrarca.residence.controller;

import com.petrarca.residence.DTO.PersonDTO;
import com.petrarca.residence.DTO.ResidenceDTO;
import com.petrarca.residence.service.ConverterService;
import com.petrarca.residence.service.ResidenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/residence")
public class ResidenceController {
    private Logger logger = LoggerFactory.getLogger(ResidenceController.class);

    @Autowired
    private ResidenceService residenceService;

    @Autowired
    private ConverterService converterService;

    @CrossOrigin("*")
    @PostMapping("/addResidence")
    public void addResidence(@RequestBody ResidenceDTO residenceDTO){
        logger.info("ResidenceController.addResidence residenceDTO:{}",residenceDTO);
        residenceService.addResidence(residenceDTO);
    }

    @CrossOrigin("*")
    @PatchMapping("/updateResidence")
    public void updateResidence(@RequestBody ResidenceDTO residenceDTO){
        logger.info("ResidenceController.updateResidence residenceDTO:{}",residenceDTO);
        residenceService.updateResidence(residenceDTO);
    }

    @CrossOrigin("*")
    @PostMapping("/getByPerson")
    public ResidenceDTO getResidenceByPerson(@RequestBody PersonDTO personDTO){
        logger.info("ResidenceController.getResidenceByPerson personId:{}",personDTO.getId());
        return residenceService.residenceByPerson(personDTO);
    }
}
