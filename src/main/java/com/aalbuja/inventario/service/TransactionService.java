package com.aalbuja.inventario.service;


import com.aalbuja.inventario.Bean.ReportAmoutByStore;
import com.aalbuja.inventario.Bean.ReportNumberTransaccion;
import com.aalbuja.inventario.model.Product;
import com.aalbuja.inventario.model.Transaction;
import com.aalbuja.inventario.repository.ProductRepository;
import com.aalbuja.inventario.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;



@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    ProductService prdService;

    @Autowired
    ProductRepository productRepository;

    public List<Transaction> save( List<Transaction> transactions) throws Exception {

        List<Transaction> listProcess = new ArrayList<>();
        transactions.forEach(x->{
            if(productRepository.existsById(x.getProduct().getId())) {
                Product product = productRepository.findById(x.getProduct().getId()).get();
                x.setPrice(product.getPrice());
                Integer faltante = (product.getStock() - x.getAmount()) * -1;
                if (faltante > 10) {
                    try {
                        throw new Exception("Unidades No disponibles (Mayor a 10)");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (faltante > 5) {
                    transactionRepository.save(x);
                    prdService.updateStockProduct(product.getId(), ((product.getStock() + 10) - x.getAmount()));
                    listProcess.add(x);
                } else if (faltante >= 0) {
                    transactionRepository.save(x);
                    prdService.updateStockProduct(product.getId(), ((product.getStock() + 5) - x.getAmount()));
                    listProcess.add(x);
                } else {
                    transactionRepository.save(x);
                    prdService.updateStockProduct(product.getId(), ((product.getStock()) - x.getAmount()));
                    listProcess.add(x);
                }
            }
        });
        return  listProcess;
    }


    public List<ReportNumberTransaccion> reportNumberTransaccion() {
        List<Object[]> list = transactionRepository.numberTransacction();
        if (list != null && !list.isEmpty()) {
            List<ReportNumberTransaccion> result = list.stream().map(object -> {
                ReportNumberTransaccion obj = new ReportNumberTransaccion();
                obj.setNumber(object[0].toString());
                obj.setStoreName(object[1].toString());
                obj.setDate(LocalDate.parse(object[2].toString()));
                return obj;
            }).collect(Collectors.toList());
            return result;
        }
        return new ArrayList<ReportNumberTransaccion>();
    }

    public List<ReportAmoutByStore> reportAmounByStore() {
        List<Object[]> list = transactionRepository.amounByStore();
        List<ReportAmoutByStore> out = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            List<ReportAmoutByStore> result = list.stream().map(object->{
                ReportAmoutByStore obj = new ReportAmoutByStore();
                obj.setNameStore(object[0].toString());
                obj.setNameProduct(object[1].toString());
                obj.setAmount(BigDecimal.valueOf(Double.valueOf(object[2].toString())));
                return obj;
            }).collect(Collectors.toList());
            return result;
        }
        return new ArrayList<ReportAmoutByStore>();
    }

    public List<Transaction> transactionByClient(Integer id, String starDate, String endDate){
        List<Transaction> list =transactionRepository.transactionByClient(id,starDate,endDate);
        list.forEach(x->{
            x.getStore().setTransactionSet(null);
            x.getStore().setStoreProducts(null);
            x.getClient().setTransactionSet(null);
            x.getProduct().setTransactionSet(null);
            x.getProduct().setStoreProducts(null);
        });
        return list;
    }


}
