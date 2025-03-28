package com.example.barbershopsystem.entities;

import com.example.barbershopsystem.enums.BarberRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
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
    private List<Client> clients;

    public Barber(Long id, String name, String phoneNumber, String email, String password, BarberRole role, List<Appointment> appointments, List<Client> clients) {
        super(id, name, phoneNumber, email, password);
        this.role = role;
        this.appointments = appointments;
        this.clients = clients;
    }

    public Barber(Long id, String name, String phoneNumber, String email, String password, BarberRole role) {
        super(id, name, phoneNumber, email, password);
        this.role = role;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public BarberRole getRole() {
        return role;
    }

    public void setRole(BarberRole role) {
        this.role = role;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
