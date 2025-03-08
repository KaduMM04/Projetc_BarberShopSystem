package com.example.barbershopsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name="tb_client")
public class Client extends User {

    private String shortName;

    public Client(Long id, String name, String phoneNumber, String email, String shortName) {
        super(id, name, phoneNumber, email);
        this.shortName = shortName;
    }

}
