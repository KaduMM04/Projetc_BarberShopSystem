package com.example.barbershopsystem.dtos;

import com.example.barbershopsystem.entities.Barber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ClientDTO {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String shortName;
    private Long barberId;

}
