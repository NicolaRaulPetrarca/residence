package com.petrarca.residence.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidenceDTO {
    private Long id;
    private String address;
    private String zipCode;
    private String city;
    private PersonDTO personDTO;
}
