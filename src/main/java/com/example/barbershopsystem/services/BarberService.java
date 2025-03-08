package com.example.barbershopsystem.services;

import com.example.barbershopsystem.dtos.BarberDTO;
import com.example.barbershopsystem.entities.Barber;
import com.example.barbershopsystem.repositories.BarberRepository;
import com.example.barbershopsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BarberService {

    @Autowired
    private BarberRepository barberRepository;
    @Autowired
    private UserRepository userRepository;

    public Barber saveBarber(Barber barber) {
        return barberRepository.save(barber);
    }

    public List<BarberDTO> getAllBarbers() {
        return barberRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BarberDTO findBarberById(Long id) {
        Barber barber = barberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Barber not found"));
        return convertToDTO(barber);
    }

    public BarberDTO findBarberByEmail(String email) {
        Barber barber = barberRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Barber with email not found" + email));
        return convertToDTO(barber);
    }

    public void deleteBarberById(Long id) {
        Barber barber = barberRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Barber not found"));
        barberRepository.delete(barber);
    }

    public BarberDTO updateBarber(Long id, BarberDTO barberDTO) {
        Barber existingBarber = barberRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Barber not found"));

        existingBarber.setName(barberDTO.getName());
        existingBarber.setEmail(barberDTO.getEmail());
        existingBarber.setPhoneNumber(barberDTO.getPhoneNumber());
        existingBarber.setPassword(barberDTO.getPassword());
        existingBarber.setRole(barberDTO.getRole());

        Barber updatedBarber = barberRepository.save(existingBarber);
        return convertToDTO(updatedBarber);
    }

    private BarberDTO convertToDTO(Barber temp) {
        BarberDTO dto = new BarberDTO();
        dto.setId(temp.getId());
        dto.setName(temp.getName());
        dto.setPhoneNumber(temp.getPhoneNumber());
        dto.setEmail(temp.getEmail());
        dto.setRole(temp.getRole());
        return dto;
    }
}


