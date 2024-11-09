package com.petrarca.residence.service;

import com.petrarca.residence.DTO.PersonDTO;
import com.petrarca.residence.entity.Person;
import com.petrarca.residence.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private Logger logger = LoggerFactory.getLogger(PersonService.class);
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ConverterService converterService;

    public List<PersonDTO> getAllPerson(){
        logger.info("PersonService.getAllPerson");
        List<Person> personList = personRepository.findAll();
        List<PersonDTO> personDTOList = new ArrayList<>();
        for(Person p : personList){
            personDTOList.add(converterService.toPersonDTO(p));
        }
        return personDTOList;
    }

    public void delete(Long id){
        logger.info("PersonService.delete id: {}",id);
        personRepository.deleteById(id);
    }
}
