package com.aalbuja.inventario.service;


import com.aalbuja.inventario.model.Client;
import com.aalbuja.inventario.model.Product;
import com.aalbuja.inventario.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    // CREATE
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // READ
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    // UPDATE
    public Product updateStockProduct(Integer prdId, Integer stock) {
        Product product = productRepository.findById(prdId).get();
        product.setStock(stock);
        return productRepository.save(product);
    }
}