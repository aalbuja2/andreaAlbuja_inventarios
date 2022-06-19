package com.aalbuja.inventario.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="tienda")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nombre")
    private String Nombre;

    @OneToMany(mappedBy = "product")
    private Set<StoreProduct> storeProducts;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Transaction> transactionSet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
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
