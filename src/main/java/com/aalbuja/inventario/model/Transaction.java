package com.aalbuja.inventario.model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name= "transaccion")
public class Transaction implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="cantidad")
    private Integer amount;

    @Column(name="precio",nullable = true)
    private Double price;


    @Column(name="fecha")
    private LocalDate date;

    @Column(name="hora")
    private LocalDateTime hour;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "tienda_id",nullable = false)
    Store store;


    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id",nullable = false)
    Client client;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id",nullable = false)
    Product product;


    public Transaction() {
        this.hour = LocalDateTime.now();
        this.date = LocalDate.now();
    }

    public Transaction(Integer amount, Store store, Client client, Product product) {
        this.amount = amount;
        this.store = store;
        this.client = client;
        this.product = product;
        this.hour = LocalDateTime.now();
        this.date = LocalDate.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getHour() {
        return hour;
    }

    public void setHour(LocalDateTime hour) {
        this.hour = hour;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
