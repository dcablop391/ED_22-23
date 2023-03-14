package com.ies.carrillo.UD03.Banco;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class TestCredito {

	@Test
	public void testLiquidar() throws Exception {
		Cuenta c = new Cuenta("123456789", "Pepe");
		Credito tCredito = new Credito("123456", "Pepe", new Date(), 5000);
		tCredito.setCuenta(c);
		tCredito.ingresar(100);
		
		tCredito.liquidar(3, 2023);
		
	}
}
