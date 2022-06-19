package com.aalbuja.inventario;

import com.aalbuja.inventario.handler.ControllerExceptionHandler;
import com.aalbuja.inventario.model.Client;
import com.aalbuja.inventario.model.Product;
import com.aalbuja.inventario.model.Store;
import com.aalbuja.inventario.model.Transaction;
import com.aalbuja.inventario.service.ClientService;
import com.aalbuja.inventario.service.ProductService;
import com.aalbuja.inventario.service.StoreService;
import com.aalbuja.inventario.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InventarioApplicationTests {

	@Autowired
	StoreService storeService;

	@Autowired
	ClientService clientService;

	@Autowired
	TransactionService transactionService;

	@Autowired
	ProductService productoService;

	//Prueba 1: Se valida que al levantar la aplicacion
	// le el archivo data.sql con el ingreso de las 4 tiendas
	@Test
	public void validateNumberStore() {
		assertEquals(4, storeService.getAllStore().size());
	}

	//Prueba 2:Se valida ingreso del cliente
	@Test
	public void validateInsertClient() {
		assertEquals("1715813174", clientService.createClient(new Client("Andrea",
				null,"1715813174",null)).getIdentificacion());
	}

	//Prueba 3:Se valida actualizacion de stock producto
	@Test
	public void validateUpdateStock() {
		Product product = productoService.createProduct(new Product("prod-4",
				"prod-name-4",12.5,25));
		assertEquals(15, productoService.updateStockProduct(product.getId(),15).getStock());
	}

	//Prueba 4:Se valida actualizacion de stock producto faltante >10
	@Test
	public void validateStockMenor10(){
		List<Transaction> list = new ArrayList<>();
		list.add(new Transaction(14,new Store(1),new Client(2),new Product(1)));
		try {
			transactionService.save(list);
		} catch (Exception e) {
			assertEquals("Unidades No disponibles (Mayor a 10)",e.getMessage());
		}
	}

}
