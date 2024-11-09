package com.petrarca.residence.repository;

import com.petrarca.residence.entity.Person;
import com.petrarca.residence.entity.Residence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface ResidenceRepository extends JpaRepository<Residence, Long> {

    List<Residence> findByAddressAndZipCodeAndCity(String address, String zipCode, String city);

    Optional<Residence> findByPerson(Person person);

    @Modifying
    @Transactional
    @Query("DELETE FROM Residence r WHERE r.person.id = :personId")
    void deleteByPersonId(@Param("personId") Long personId);
}
