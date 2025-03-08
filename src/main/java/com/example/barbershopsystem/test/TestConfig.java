package com.example.barbershopsystem.test;

import com.example.barbershopsystem.entities.Appointment;
import com.example.barbershopsystem.entities.Barber;
import com.example.barbershopsystem.entities.Client;
import com.example.barbershopsystem.enums.BarberRole;
import com.example.barbershopsystem.repositories.AppointmentRepository;
import com.example.barbershopsystem.repositories.BarberRepository;
import com.example.barbershopsystem.repositories.ClientRepository;
import com.example.barbershopsystem.services.BarberService;
import com.example.barbershopsystem.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private BarberRepository barberRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public void run(String... args) throws Exception {

        Barber barber = new Barber (null, "Carlos", "123-456-7890", "carlos@email.com", "123", BarberRole.ADMIN);
        barberRepository.save(barber);


        Client client1 = new Client(null, "João Silva", "987-654-3210", "joao@email.com", "João", barber);
        Client client2 = new Client(null, "Maria Souza", "456-789-1234", "maria@email.com", "Maria", barber);
        clientRepository.saveAll(List.of(client1, client2));


        Appointment appointment1 = new Appointment(null, barber, client1, LocalDateTime.of(2025, 3, 10, 14, 0));
        Appointment appointment2 = new Appointment(null, barber, client2, LocalDateTime.of(2025, 3, 10, 16, 30));
        appointmentRepository.saveAll(List.of(appointment1, appointment2));
    }

}
