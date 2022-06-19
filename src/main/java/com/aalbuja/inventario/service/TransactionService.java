package com.aalbuja.inventario.service;


import com.aalbuja.inventario.Bean.ReportAmoutByStore;
import com.aalbuja.inventario.Bean.ReportNumberTransaccion;
import com.aalbuja.inventario.model.Product;
import com.aalbuja.inventario.model.Transaction;
import com.aalbuja.inventario.repository.ClientRepository;
import com.aalbuja.inventario.repository.ProductRepository;
import com.aalbuja.inventario.repository.StoreRepository;
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

    @Autowired
    ProductService prdService;

    @Autowired
    ProductRepository productRepository;

    public List<Transaction> save( List<Transaction> transactions) throws Exception {

        List<Transaction> listProcess = new ArrayList<>();
        transactions.forEach(x->{
            Product product = productRepository.findById(x.getProduct().getId()).get();
            x.setPrice(product.getPrice());
            Integer faltante = (product.getStock() - x.getAmount())*-1;
            if (faltante >10){
                try {
                    throw new Exception("Unidades No disponibles (Mayor a 10)");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (faltante >5){
                transactionRepository.save(x);
                prdService.updateStockProduct(product.getId(),((product.getStock()+10)-x.getAmount()));
                listProcess.add(x);
            }else if(faltante >=0){
                transactionRepository.save(x);
                prdService.updateStockProduct(product.getId(),((product.getStock()+5)-x.getAmount()));
                listProcess.add(x);
            }else{
                transactionRepository.save(x);
                prdService.updateStockProduct(product.getId(),((product.getStock())-x.getAmount()));
                listProcess.add(x);
            }
        });
        return  listProcess;
    }


    public List<ReportNumberTransaccion> reportNumberTransaccion() {
        List<Object[]> list = transactionRepository.numberTransacction();
        List<ReportNumberTransaccion> out = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            ReportNumberTransaccion numberTransaccion = null;
            for (Object[] object : list) {
                numberTransaccion = new ReportNumberTransaccion();
                numberTransaccion.setNumber(object[0].toString());
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
