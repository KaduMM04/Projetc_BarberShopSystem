package com.example.barbershopsystem.dtos;

import com.example.barbershopsystem.enums.BarberRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class BarberDTO {

    private Long id;
    private String name;
    private String email;
    private BarberRole role;
}
