package com.aalbuja.inventario.controller;


import com.aalbuja.inventario.Bean.Order;
import com.aalbuja.inventario.Bean.ReportAmoutByStore;
import com.aalbuja.inventario.Bean.ReportNumberTransaccion;
import com.aalbuja.inventario.model.Transaction;
import com.aalbuja.inventario.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    TransactionService transactionService;

    @RequestMapping(value="/order", method= RequestMethod.POST)
    public List<Transaction> createOrder(@RequestBody Order order) {
        return transactionService.save(order.getTransactionList());
    }

    @RequestMapping(value="/order/numberTransaction", method= RequestMethod.GET)
    public List<ReportNumberTransaccion> reportNumberTransaccion() {
        return transactionService.reportNumberTransaccion();
    }

    @RequestMapping(value="/order/amoutByStore", method= RequestMethod.GET)
    public List<ReportAmoutByStore> reportAmountByStore() {
        return transactionService.reportAmounByStore();
    }
}
