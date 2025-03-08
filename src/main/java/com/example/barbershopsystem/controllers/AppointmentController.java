package com.example.barbershopsystem.controllers;


import com.example.barbershopsystem.dtos.AppointmentDTO;
import com.example.barbershopsystem.entities.Appointment;
import com.example.barbershopsystem.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment) {
        appointmentService.saveAppointment(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(appointment);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> findAll() {
        List<AppointmentDTO> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok().body(appointments);
    }

    @GetMapping("/barber/{barberId}")
    public ResponseEntity<List<AppointmentDTO>> getBarberAppointment(@PathVariable Long barberId) {
        List<AppointmentDTO> barberAppointments = appointmentService.getBarberAppointments(barberId);
        if(barberAppointments .isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(barberAppointments);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<AppointmentDTO>> getClientAppointment(@PathVariable Long clientId) {
        List<AppointmentDTO> clientAppointments = appointmentService.getClientAppointments(clientId);
        if(clientAppointments.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(clientAppointments);
    }

    @GetMapping("/{date}")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentByDate(@PathVariable LocalDateTime date) {
        List<AppointmentDTO> appointments = appointmentService.getAppointmentsByDate(date);
        if(appointments.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(appointments);
    }

}
