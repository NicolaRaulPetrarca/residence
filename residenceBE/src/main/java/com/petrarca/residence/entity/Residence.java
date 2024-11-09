package com.petrarca.residence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Residence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ADDRESS", length=50)
    private String address;

    @Column(name = "ZIP_CODE", length=5)
    private String zipCode;

    @Column(name = "CITY", length=50)
    private String city;

    @OneToOne
    @JoinColumn(name = "id_person", nullable = false)
    private Person person;

}
