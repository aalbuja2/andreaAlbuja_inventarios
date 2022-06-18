package com.aalbuja.inventario.service;


import com.aalbuja.inventario.Bean.ReportAmoutByStore;
import com.aalbuja.inventario.Bean.ReportNumberTransaccion;
import com.aalbuja.inventario.model.Store;
import com.aalbuja.inventario.model.Transaction;
import com.aalbuja.inventario.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    //Create
    public List<Transaction> save(List<Transaction> transactions) {




        return transactionRepository.saveAll(transactions);
    }


    public List<ReportNumberTransaccion> reportNumberTransaccion() {
        List<Object[]> list = transactionRepository.numberTransacction();
        List<ReportNumberTransaccion> out = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            ReportNumberTransaccion numberTransaccion = null;
            for (Object[] object : list) {
                numberTransaccion = new ReportNumberTransaccion();
                numberTransaccion.setNumber(((BigInteger) object[1]).intValue());
                numberTransaccion.setStoreName(object[1].toString());
                numberTransaccion.setDate(LocalDate.parse(object[2].toString()));
                out.add(numberTransaccion);
            }
        }
        return out;
    }

    public List<ReportAmoutByStore> reportAmounByStore() {
        List<Object[]> list = transactionRepository.amounByStore();
        List<ReportAmoutByStore> out = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            ReportAmoutByStore reportAmoutByStore = null;
            for (Object[] object : list) {
                reportAmoutByStore = new ReportAmoutByStore();
                reportAmoutByStore.setNameStore(object[0].toString());
                reportAmoutByStore.setNameProduct(object[1].toString());
                reportAmoutByStore.setAmount(BigDecimal.valueOf(Double.valueOf(object[2].toString())));
                out.add(reportAmoutByStore);
            }
        }
        return out;
    }
}
