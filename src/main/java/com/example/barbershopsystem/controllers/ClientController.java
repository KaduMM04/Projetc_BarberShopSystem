package com.example.barbershopsystem.controllers;

import com.example.barbershopsystem.dtos.BarberDTO;
import com.example.barbershopsystem.dtos.ClientDTO;
import com.example.barbershopsystem.entities.Client;
import com.example.barbershopsystem.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> saveClient(@RequestBody Client client) {
        clientService.saveClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok().body(clientService.getAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        ClientDTO dto = clientService.findClientById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ClientDTO> getClientByEmail(@PathVariable String email) {
        ClientDTO dto = clientService.findClientByEmail(email);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient(@RequestBody ClientDTO client, @PathVariable Long id) {
        return ResponseEntity.ok(clientService.updateClientById(id, client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClientDTO> deleteClient(@PathVariable Long id) {
        clientService.deleteClientById(id);
        return ResponseEntity.noContent().build();
    }
}
