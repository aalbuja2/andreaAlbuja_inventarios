package com.aalbuja.inventario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Table(name = "producto")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="codigo")
    private String Cod;

    @Column(name="nombre")
    private String Name;

    @Column(name="precio")
    private Double Price;

    @Column(name="stock")
    private Integer Stock;


    @OneToMany(mappedBy = "store")
    Set<StoreProduct> storeProducts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCod() {
        return Cod;
    }

    public void setCod(String cod) {
        Cod = cod;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public Integer getStock() {
        return Stock;
    }

    public void setStock(Integer stock) {
        Stock = stock;
    }


    public Set<StoreProduct> getStoreProducts() {
        return storeProducts;
    }

    public void setStoreProducts(Set<StoreProduct> storeProducts) {
        this.storeProducts = storeProducts;
    }
}
