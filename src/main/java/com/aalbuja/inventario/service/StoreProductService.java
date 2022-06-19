package com.aalbuja.inventario.service;


import com.aalbuja.inventario.model.Client;
import com.aalbuja.inventario.model.Product;
import com.aalbuja.inventario.model.StoreProduct;
import com.aalbuja.inventario.repository.StoreProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreProductService {
    @Autowired
    StoreProductRepository storeProductRepository;

    public StoreProduct assignStoreProduct(StoreProduct storeProduct) {
        StoreProduct obj= storeProductRepository.save(storeProduct);
        obj.getProduct().setStoreProducts(null);
        obj.getProduct().setTransactionSet(null);
        obj.getStore().setStoreProducts(null);
        obj.getStore().setTransactionSet(null);
        return obj;
    }
}
