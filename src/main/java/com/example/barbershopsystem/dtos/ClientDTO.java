package com.example.barbershopsystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ClientDTO {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String shortName;

}
