package com.aalbuja.inventario.repository;



import com.aalbuja.inventario.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository< Product, Integer>  {
}
