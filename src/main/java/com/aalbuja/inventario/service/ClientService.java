package com.aalbuja.inventario.service;

import com.aalbuja.inventario.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aalbuja.inventario.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository cliRepository;

    // CREATE
    public Client createClient(Client cli) {
        return cliRepository.save(cli);
    }

    // READ
    public List<Client> getAllClient() {
        return cliRepository.findAll();
    }

    // DELETE
    public void deleteClient(Integer cliId) {
        cliRepository.deleteById(cliId);
    }

    // UPDATE
    public Client updateClient(Integer cliId, Client cliDetails) {
        Client client = cliRepository.findById(cliId).get();
        client.setNombres(cliDetails.getNombres());
        client.setApellidos(cliDetails.getApellidos());
        client.setIdentificacion(cliDetails.getIdentificacion());
        client.setFoto(cliDetails.getFoto());
        return cliRepository.save(client);
    }

}
