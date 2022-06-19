package com.aalbuja.inventario.service;


import com.aalbuja.inventario.model.Product;
import com.aalbuja.inventario.model.Store;
import com.aalbuja.inventario.repository.ClientRepository;
import com.aalbuja.inventario.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class StoreService {
    @Autowired
    StoreRepository storeRepository;


    // READ
    public List<Store> getAllStore() {
        return storeRepository.findAll();
    }

}
