package com.example.barbershopsystem.dtos;

import com.example.barbershopsystem.enums.BarberRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BarberDTO {

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
    private BarberRole role;

}
