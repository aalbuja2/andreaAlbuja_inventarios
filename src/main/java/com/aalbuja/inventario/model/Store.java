package com.aalbuja.inventario.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="tienda")
public class Store implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nombre")
    private String nombre;

    @OneToMany(mappedBy = "product")
    private Set<StoreProduct> storeProducts;

    @OneToMany(mappedBy = "store")
    private Set<Transaction> transactionSet;

    public Store() {

    }

    public Store(String nombre) {
        this.nombre = nombre;
    }

    public Store(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
