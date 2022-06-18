package com.aalbuja.inventario.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.JoinColumn;
import javax.persistence.EmbeddedId;
import java.time.LocalDateTime;

@Entity
@Table(name = "tienda_producto")
public class StoreProduct {

    @EmbeddedId
    StoreProductKey id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "producto_id")
    Product product;

    @ManyToOne
    @MapsId("storeId")
    @JoinColumn(name = "tienda_id")
    Store store;

    @Column(name="fecha")
    private LocalDateTime date;

    public StoreProduct() {
        this.date = LocalDateTime.now();
    }

    public StoreProductKey getId() {
        return id;
    }

    public void setId(StoreProductKey id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}




