package com.aalbuja.inventario.controller;


import com.aalbuja.inventario.model.Product;
import com.aalbuja.inventario.model.StoreProduct;
import com.aalbuja.inventario.service.StoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StoreProductController {

    @Autowired
    StoreProductService storeProductService;

    @RequestMapping(value="/storeProducts", method= RequestMethod.POST)
    public StoreProduct saveAssignment(@RequestBody StoreProduct strPrd) {
        return storeProductService.assignStoreProduct(strPrd);
    }
}
