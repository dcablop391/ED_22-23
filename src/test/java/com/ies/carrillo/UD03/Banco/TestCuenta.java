package com.ies.carrillo.UD03.Banco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Realiza los tests de las clases Cuenta, Movimiento, Credito y Debito.
 * 
 * @author Alumnado
 *
 */
public class TestCuenta {

	////////////////////////////////////////
	/// PRUEBAS DE INGRESAR
	///////////////////////////////////////
	
	@Test
	public void testCuentaIngresar() {
		Cuenta c1 = new Cuenta("123456789", "David Cabrera");
		try {
			c1.ingresar(100);
			// Tiene un movimiento
			assertEquals(1, c1.mMovimientos.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCuentaIngresarConcepto() {
		Cuenta c1 = new Cuenta("123456789", "David Cabrera");
		try {
			String concepto = "Concepto de ejemplo";
			int importe = 100;

			c1.ingresar(concepto, importe);

			Movimiento m = (Movimiento) c1.mMovimientos.lastElement();

			assertEquals(concepto, m.mConcepto);
			assertTrue(m.mConcepto.equals(concepto) && m.mImporte == importe);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCuentaIngresarSaldo() {
		Cuenta c1 = new Cuenta("123456789", "David Cabrera");
		try {
			String concepto = "Concepto de ejemplo";
			double importe = 100.0;

			c1.ingresar(concepto, importe);
			c1.ingresar(concepto, importe);

			assertEquals(importe * 2, c1.getSaldo());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCuentaIngresarError() {
		Cuenta c1 = new Cuenta("123456789", "David Cabrera");
		try {
			c1.ingresar(0);
			// Tiene un movimiento
			assertEquals(1, c1.mMovimientos.size());

		} catch (Exception e) {
			System.out.println("Error cantidad negativa");
			fail("Error cantidad negativa");
		}
	}

	@Test
	public void testCuentaRetirar() {
		Cuenta c1 = new Cuenta("123456789", "David Cabrera");
		try {
			c1.ingresar(100);
			c1.retirar(3);
			// Tiene un movimiento
			assertEquals(2, c1.mMovimientos.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	////////////////////////////////////////
	/// PRUEBAS DE RETIRAR
	///////////////////////////////////////
	
	@Test
	public void testCuentaRetirarConcepto() {
		Cuenta c1 = new Cuenta("123456789", "David Cabrera");
		try {
			String concepto = "Concepto de ejemplo";
			int importe = 100;

			c1.ingresar(concepto, importe);

			String conceptoR = "Concepto de Retirada";
			int importeR = 80;

			c1.retirar(conceptoR, importeR);

			Movimiento m = (Movimiento) c1.mMovimientos.lastElement();

			assertEquals(conceptoR, m.mConcepto);
			assertTrue(m.mConcepto.equals(conceptoR) && m.mImporte == -importeR);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCuentaRetirarSaldo() {
		Cuenta c1 = new Cuenta("123456789", "David Cabrera");
		try {
			String concepto = "Concepto de ejemplo";
			double importe = 100.0;

			c1.ingresar(concepto, importe);

			String conceptoR = "Concepto de Retirada";
			int importeR = 80;

			c1.retirar(conceptoR, importeR);

			assertEquals(importe - importeR, c1.getSaldo());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCuentaRetirarError() {
		Cuenta c1 = new Cuenta("123456789", "David Cabrera");
		try {
			String concepto = "Concepto de ejemplo";
			double importe = 100.0;

			c1.ingresar(concepto, importe);

			String conceptoR = "Concepto de Retirada";
			int importeR = 110;

			c1.retirar(conceptoR, importeR);

			assertEquals(importe - importeR, c1.getSaldo());

		} catch (Exception e) {
			System.out.println("Error no tiene saldo suficiente");
			fail("Error no tiene saldo suficiente");
		}
	}
	
	@Test
	public void testAddMovimiento() {
		Cuenta c = new Cuenta("123546789", "Pepe");
		
		Movimiento mov = new Movimiento();
		mov.setConcepto("Prueba");
		mov.setImporte(100);
		c.addMovimiento(mov);
	}
}
