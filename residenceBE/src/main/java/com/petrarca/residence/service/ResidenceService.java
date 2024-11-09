package com.petrarca.residence.service;

import com.petrarca.residence.DTO.PersonDTO;
import com.petrarca.residence.DTO.ResidenceDTO;
import com.petrarca.residence.entity.Person;
import com.petrarca.residence.entity.Residence;
import com.petrarca.residence.repository.PersonRepository;
import com.petrarca.residence.repository.ResidenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResidenceService {
    private Logger logger = LoggerFactory.getLogger(ResidenceService.class);
    @Autowired
    private ResidenceRepository residenceRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ConverterService converterService;

    public void updateResidence(ResidenceDTO residenceDTO){
        logger.info("ResidenceService.updateResidence residenceDTO: {}",residenceDTO);
        residenceRepository.save(converterService.toResidence(residenceDTO));
    }

    public void addResidence(ResidenceDTO residenceDTO){
        logger.info("ResidenceService.addResidence residenceDTO: {}",residenceDTO);
        Optional<Residence> residence = residenceRepository.findByPerson(converterService.toPerson(residenceDTO.getPersonDTO()));
        residence.ifPresent(value -> deleteResidence(value));
        updateResidence(residenceDTO);
    }

    public void deleteResidence(Residence residence){
        logger.info("ResidenceService.deleteResidence residenceID: {}",residence.getId());
        residenceRepository.deleteByPersonId(residence.getId());
        Optional<Residence> residences = residenceRepository.findByPerson(residence.getPerson());
    }

    public List<PersonDTO> personByResidence(ResidenceDTO residenceDTO){
        logger.info("ResidenceService.personByResidence residenceDTO: {}",residenceDTO);
        List<Residence> residences = residenceRepository.
                findByAddressAndZipCodeAndCity(residenceDTO.getAddress(), residenceDTO.getZipCode(), residenceDTO.getCity());
        List<Person> people = new ArrayList<>();
        for(Residence i : residences) {
            personRepository.findById(i.getId()).ifPresent(people::add);
        }
        return converterService.toPersonDTOList(people);
    }

    public ResidenceDTO residenceByPerson(PersonDTO personDTO){
        logger.info("ResidenceService.residenceByPerson person: {}",personDTO);
        Optional<Residence> residence = residenceRepository.findByPerson(converterService.toPerson(personDTO));
        ResidenceDTO dto = null;
        if(residence.isPresent()){
            dto = converterService.toResidenceDTO(residence.get());
        }
        return dto;
    }

}
