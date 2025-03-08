package com.example.barbershopsystem.services;

import com.example.barbershopsystem.dtos.BarberDTO;
import com.example.barbershopsystem.dtos.ClientDTO;
import com.example.barbershopsystem.entities.Barber;
import com.example.barbershopsystem.entities.Client;
import com.example.barbershopsystem.repositories.BarberRepository;
import com.example.barbershopsystem.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BarberRepository barberRepository;

    public ClientDTO saveClient(ClientDTO clientDTO) {
        Barber barber = barberRepository.findById(clientDTO.getBarberId())
                .orElseThrow(() -> new RuntimeException("Barber not found"));

        Client client = new Client(null, clientDTO.getName(), clientDTO.getPhoneNumber(), clientDTO.getEmail(), clientDTO.getShortName(), barber);

        Client savedClient = clientRepository.save(client);

        return convertToDTO(savedClient);
    }


    public List<ClientDTO> getAllClients(){
        return clientRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ClientDTO findClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return convertToDTO(client);
    }

    public ClientDTO findClientByEmail(String email) {
        Client client = clientRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Client with this email not found" + email));
        return convertToDTO(client);
    }

    public void deleteClientById(Long id){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        clientRepository.delete(client);
    }

    public ClientDTO updateClientById(Long id, ClientDTO clientDTO){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());
        client.setPhoneNumber(clientDTO.getPhoneNumber());
        client.setShortName(clientDTO.getShortName());

        Client UpdatedClient = clientRepository.save(client);
        return convertToDTO(UpdatedClient);

    }

    private ClientDTO convertToDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setName(client.getName());
        dto.setEmail(client.getEmail());
        dto.setPhoneNumber(client.getPhoneNumber());
        dto.setShortName(client.getShortName());
        dto.setBarberId(client.getBarber().getId());
        return dto;
    }
}
