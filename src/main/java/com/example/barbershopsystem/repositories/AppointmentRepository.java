package com.example.barbershopsystem.repositories;

import com.example.barbershopsystem.entities.Appointment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByAppointmentDate(LocalDateTime appointmentDate);

    List<Appointment> findByBarberId(Long id);

    List<Appointment> findByClientId(Long id);
}
