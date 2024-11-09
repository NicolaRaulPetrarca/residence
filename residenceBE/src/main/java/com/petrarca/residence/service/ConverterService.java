package com.petrarca.residence.service;

import com.petrarca.residence.DTO.PersonDTO;
import com.petrarca.residence.DTO.ResidenceDTO;
import com.petrarca.residence.entity.Person;
import com.petrarca.residence.entity.Residence;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConverterService {

    public Person toPerson(PersonDTO dto) {
        return new Person(dto.getId(),dto.getName(), dto.getLastName(), dto.getFiscalCode(), dto.getBirthDate());
    }

    public PersonDTO toPersonDTO(Person object){
        return new PersonDTO(object.getId(), object.getName(), object.getLastName(), object.getFiscalCode(), object.getBirthDate());
    }

    public Residence toResidence(ResidenceDTO dto){
        return new Residence(dto.getId(), dto.getAddress(), dto.getZipCode(),dto.getCity(),toPerson(dto.getPersonDTO()));
    }

    public ResidenceDTO toResidenceDTO(Residence object){
        return new ResidenceDTO(object.getId(), object.getAddress(), object.getZipCode(), object.getCity(), toPersonDTO(object.getPerson()));
    }

    public List<PersonDTO> toPersonDTOList(List<Person> people){
        List<PersonDTO> dto = new ArrayList<>();
        for(Person object : people){
            dto.add(toPersonDTO(object));
        }
        return dto;
    }

}
