package com.example.barbershopsystem.controllers;

import com.example.barbershopsystem.dtos.BarberDTO;
import com.example.barbershopsystem.entities.Barber;
import com.example.barbershopsystem.services.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barber")
public class BarberController {

    @Autowired
    private BarberService barberService;

    @PostMapping
    public ResponseEntity<Barber> saveBarber(@RequestBody Barber barber) {
        barberService.saveBarber(barber);
        return ResponseEntity.status(HttpStatus.CREATED).body(barber);
    }

    @GetMapping
    public ResponseEntity<List<BarberDTO>> getAllBarbers() {
        return ResponseEntity.ok().body(barberService.getAllBarbers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarberDTO> getBarberById(@PathVariable Long id) {
        BarberDTO dto = barberService.findBarberById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<BarberDTO> getBarberByEmail(@PathVariable String email) {
        BarberDTO dto = barberService.findBarberByEmail(email);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BarberDTO> updateBarberById(@RequestBody BarberDTO barber, @PathVariable Long id) {
        return ResponseEntity.ok(barberService.updateBarber(id, barber));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BarberDTO> deleteBarberById(@PathVariable Long id) {
        barberService.deleteBarberById(id);
        return ResponseEntity.noContent().build();
    }
}
