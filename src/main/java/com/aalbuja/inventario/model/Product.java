package com.aalbuja.inventario.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "producto")

public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="codigo")
    private String cod;

    @Column(name="nombre")
    private String name;

    @Column(name="precio")
    private Double price;

    @Column(name="stock")
    private Integer stock;

    @OneToMany(mappedBy = "store")
    private Set<StoreProduct> storeProducts;


    @OneToMany(mappedBy = "product")
    private Set<Transaction> transactionSet;


    public Product() {

    }

    public Product(String cod, String name, Double price, Integer stock) {
        this.cod = cod;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }



    public Product(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }


    public Set<StoreProduct> getStoreProducts() {
        return storeProducts;
    }

    public void setStoreProducts(Set<StoreProduct> storeProducts) {
        this.storeProducts = storeProducts;
    }

    public Set<Transaction> getTransactionSet() {
        return transactionSet;
    }

    public void setTransactionSet(Set<Transaction> transactionSet) {
        this.transactionSet = transactionSet;
    }
}
