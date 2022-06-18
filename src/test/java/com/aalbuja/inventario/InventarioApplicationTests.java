package com.aalbuja.inventario;

import com.aalbuja.inventario.service.StoreService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class InventarioApplicationTests {

	@Autowired
	StoreService storeService;
	//Prueba 1: Se valida que al levantar la aplicacion
	// le el archivo data.sql con el ingreso de las 4 tiendas
	@Test
	public void test() {
		assertEquals(4, storeService.getAllStore().size());
	}
}
