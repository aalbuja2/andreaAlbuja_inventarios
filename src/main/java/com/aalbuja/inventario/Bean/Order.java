package com.aalbuja.inventario.Bean;

import com.aalbuja.inventario.model.Client;
import com.aalbuja.inventario.model.Transaction;

import java.util.List;

public class Order {

    private Client client;
    private List<Transaction> transactionList;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
