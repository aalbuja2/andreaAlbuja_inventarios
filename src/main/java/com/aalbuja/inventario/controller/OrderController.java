package com.aalbuja.inventario.controller;


import com.aalbuja.inventario.bean.ReportAmoutByStore;
import com.aalbuja.inventario.bean.ReportNumberTransaccion;
import com.aalbuja.inventario.model.Transaction;
import com.aalbuja.inventario.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    TransactionService transactionService;

    @RequestMapping(value="/order", method= RequestMethod.POST)
    public List<Transaction> createOrder(@RequestBody List<Transaction> transactions) throws Exception {

        return transactionService.save(transactions);
    }

    @RequestMapping(value="/order/numberTransaction", method= RequestMethod.GET)
    public List<ReportNumberTransaccion> reportNumberTransaccion() {
        return transactionService.reportNumberTransaccion();
    }

    @RequestMapping(value="/order/amoutByStore", method= RequestMethod.GET)
    public List<ReportAmoutByStore> reportAmountByStore() {
        return transactionService.reportAmounByStore();
    }

    @RequestMapping(value="/order/{cliId}/{startDate}/{endDate}", method=RequestMethod.GET)
    public List<Transaction> transacctionByClient(@PathVariable(value = "cliId") Integer id,
                                     @PathVariable(value = "startDate") String startDate,
                                     @PathVariable(value = "endDate") String endDate) throws IOException {

        return transactionService.transactionByClient(id,startDate,endDate);
    }

}
