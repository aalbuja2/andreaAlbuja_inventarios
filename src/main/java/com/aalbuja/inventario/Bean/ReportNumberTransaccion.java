package com.aalbuja.inventario.Bean;

import java.math.BigInteger;
import java.time.LocalDate;

public class ReportNumberTransaccion {

    private String number;
    private String storeName;
    private LocalDate date;

    public ReportNumberTransaccion() {
    }

    public ReportNumberTransaccion(String number, String storeName, LocalDate date) {
        this.number = number;
        this.storeName = storeName;
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
