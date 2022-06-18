package com.aalbuja.inventario.Bean;

import java.time.LocalDate;

public class ReportNumberTransaccion {

    private Integer number;
    private String storeName;
    private LocalDate date;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
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
