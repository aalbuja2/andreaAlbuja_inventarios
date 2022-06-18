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
@Table(name="tienda")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nombre")
    private String Nombre;

    @OneToMany(mappedBy = "product")
    Set<StoreProduct> storeProducts;

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
}
