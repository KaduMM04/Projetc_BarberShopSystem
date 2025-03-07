package com.example.barbershopsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Entity
@Table(name="tb_client")
public class Client extends User {

    private String shotName;

    public Client(Long id, String name, String phoneNumber, String email, String shotName) {
        super(id, name, phoneNumber, email);
        this.shotName = shotName;
    }
}
