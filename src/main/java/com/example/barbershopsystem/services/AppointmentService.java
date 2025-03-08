package com.example.barbershopsystem.services;

import com.example.barbershopsystem.dtos.AppointmentDTO;
import com.example.barbershopsystem.entities.Appointment;
import com.example.barbershopsystem.entities.Barber;
import com.example.barbershopsystem.entities.Client;
import com.example.barbershopsystem.repositories.AppointmentRepository;
import com.example.barbershopsystem.repositories.BarberRepository;
import com.example.barbershopsystem.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private BarberRepository barberRepository;

    @Autowired
    private ClientRepository clientRepository;


    public AppointmentDTO saveAppointment(AppointmentDTO appointmentDTO) {

        Barber barber = barberRepository.findById(appointmentDTO.getBarberId())
                .orElseThrow(() -> new RuntimeException("Barber not found"));

        Client client = clientRepository.findById(appointmentDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Appointment appointment = new Appointment(null, barber, client, appointmentDTO.getAppointmentDate());
        Appointment savedAppointment = appointmentRepository.save(appointment);

        return convertToDTO(savedAppointment);
    }

    public List<AppointmentDTO> getAllAppointments() {
        return appointmentRepository.findAll()
                .stream().
                map(this::convertToDTO).
                collect(Collectors.toList());
    }

    public List<AppointmentDTO> getAppointmentsByDate(LocalDateTime appoimentDate) {
        List<Appointment> appointments = appointmentRepository.findByAppointmentDate(appoimentDate);
        return appointments
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<AppointmentDTO> getBarberAppointments(Long barberId) {
        List<Appointment> appointments = appointmentRepository.findByBarberId(barberId);
        return appointments
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<AppointmentDTO> getClientAppointments(Long clientId) {
        List<Appointment> appointments = appointmentRepository.findByClientId(clientId);
        return appointments
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private AppointmentDTO convertToDTO(Appointment appointment) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(appointment.getId());
        dto.setBarberId(appointment.getBarber().getId());
        dto.setClientId(appointment.getClient().getId());
        dto.setAppointmentDate(appointment.getAppointmentDate());
        return dto;
    }
}
