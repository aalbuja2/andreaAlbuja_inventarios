package com.aalbuja.inventario;


import com.aalbuja.inventario.model.Client;
import com.aalbuja.inventario.repository.ClientRepository;
import com.aalbuja.inventario.repository.StoreRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = InventarioApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InventarioApplicationIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ClientRepository clientRepository;


    @Autowired
    private StoreRepository storeRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void insertNewClient() throws Exception {
        Client client = new Client("Prueba",null,"1715879875",null);
        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + port + "/clients", client, String.class);
        assertEquals(200, responseEntity.getStatusCodeValue());;
    }


}
