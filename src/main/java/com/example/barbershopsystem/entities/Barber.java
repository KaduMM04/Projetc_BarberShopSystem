package com.example.barbershopsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name="tb_barber")
public class Barber extends User {

    @Enumerated(EnumType.STRING)
    private BarberRole role;

    @OneToMany(mappedBy = "barber", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "barber", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Client>  clients;


}
