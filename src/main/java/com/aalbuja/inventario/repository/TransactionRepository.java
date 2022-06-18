package com.aalbuja.inventario.repository;

import com.aalbuja.inventario.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface  TransactionRepository extends JpaRepository<Transaction,Integer> {

    @Query (value = "select count(*), t.nombre,fecha  from transaccion,tienda t where tienda_id = t.id group by tienda_id,fecha",nativeQuery = true)
    List<Object[]> numberTransacction();


    @Query (value = "select t.nombre as Tienda ,p.nombre as Producto, tr.cantidad*tr.precio as MontoVendido " +
            "from transaccion tr,tienda t, producto p "
            +"where tr.producto_id = p.id "
            +"and tr.tienda_id =t.id "
            +"group by tr.tienda_id,tr.producto_id",nativeQuery = true)
    List<Object[]> amounByStore();
}
