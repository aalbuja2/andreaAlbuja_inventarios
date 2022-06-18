package com.aalbuja.inventario.controller;
import java.util.List;

import com.aalbuja.inventario.model.Client;
import com.aalbuja.inventario.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService cliService;

    @RequestMapping(value="/clients", method=RequestMethod.POST)
    public Client createClient(@RequestBody Client cli) {

        return cliService.createClient(cli);
    }

    @RequestMapping(value="/clients", method=RequestMethod.GET)
    public List<Client> readClients() {
        return cliService.getAllClient();
    }

    @RequestMapping(value="/clients/{cliId}", method=RequestMethod.PUT)
    public Client updateClient(@PathVariable(value = "cliId") Integer id, @RequestBody Client cliDetails) {
        return cliService.updateClient(id, cliDetails);
    }

    @RequestMapping(value="/clients/{cliId}", method=RequestMethod.DELETE)
    public void deleteClient(@PathVariable(value = "cliId") Integer id) {
        cliService.deleteClient(id);
    }
}
