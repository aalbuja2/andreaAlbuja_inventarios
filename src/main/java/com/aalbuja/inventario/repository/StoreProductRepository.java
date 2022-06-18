package com.aalbuja.inventario.repository;

import com.aalbuja.inventario.model.StoreProduct;
import com.aalbuja.inventario.model.StoreProductKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreProductRepository extends JpaRepository <StoreProduct,StoreProductKey> {
}
