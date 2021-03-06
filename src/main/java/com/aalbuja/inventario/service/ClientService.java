package com.aalbuja.inventario.service;

import com.aalbuja.inventario.model.Client;
import com.aalbuja.inventario.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aalbuja.inventario.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository cliRepository;

    public Client createClient(Client cli) {
        return cliRepository.save(cli);
    }

    public List<Client> getAllClient() {
        List<Client> list = cliRepository.findAll();
        list.forEach(x->{
            x.setTransactionSet(null);
        });
        return list;
    }

    public void deleteClient(Integer cliId) {
        cliRepository.deleteById(cliId);
    }

    public Client updateClient(Integer cliId, Client cliDetails) {
        Client client = cliRepository.findById(cliId).get();
        client.setNombres(cliDetails.getNombres());
        client.setApellidos(cliDetails.getApellidos());
        client.setIdentificacion(cliDetails.getIdentificacion());
        client.setFoto(cliDetails.getFoto());
        Client obj =cliRepository.save(client);
        obj.setTransactionSet(null);
        return obj;
    }

}
