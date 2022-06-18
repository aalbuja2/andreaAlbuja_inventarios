package com.aalbuja.inventario.controller;


import com.aalbuja.inventario.model.Product;
import com.aalbuja.inventario.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService prdService;

    @RequestMapping(value="/products", method= RequestMethod.POST)
    public Product createProduct(@RequestBody Product prd) {
        return prdService.createProduct(prd);
    }

    @RequestMapping(value="/products", method=RequestMethod.GET)
    public List<Product> readProducts()
    {
        return prdService.getAllProduct();
    }

    @RequestMapping(value="/products/{prdId}/{stock}", method=RequestMethod.PATCH)
    public Product updateSotckProduct(@PathVariable(value = "prdId") Integer id, @PathVariable(value = "stock") Integer stock) throws Exception {
            if (stock<=0) {
                throw new Exception("BadRequest: El stock debe ser mayor a 0");
            }
            return prdService.updateStockProduct(id, stock);
    }

}
