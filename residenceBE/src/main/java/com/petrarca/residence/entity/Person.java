package com.petrarca.residence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", length=25)
    private String name;

    @Column(name = "LAST_NAME", length=25)
    private String lastName;

    @Column(name = "FISCAL_CODE", length=16)
    private String fiscalCode;

    @Column(name = "BIRTH_DATE", length=10)
    private String birthDate;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Residence residence;

    public Person(Long id, String name, String lastName, String fiscalCode, String birthDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.fiscalCode = fiscalCode;
        this.birthDate = birthDate;
    }
}
