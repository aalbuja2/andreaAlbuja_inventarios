package com.aalbuja.inventario.service;


import com.aalbuja.inventario.model.Client;
import com.aalbuja.inventario.model.StoreProduct;
import com.aalbuja.inventario.repository.StoreProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreProductService {
    @Autowired
    StoreProductRepository storeProductRepository;

    //Create
    public StoreProduct assignStoreProduct(StoreProduct storeProduct) {
        return storeProductRepository.save(storeProduct);
    }
}
