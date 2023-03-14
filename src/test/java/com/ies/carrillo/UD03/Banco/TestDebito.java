package com.ies.carrillo.UD03.Banco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

/**
 * Realiza los tests de las clases Cuenta, Movimiento, Credito y Debito.
 * 
 * @author Alumnado
 *
 */
public class TestDebito {
	public Debito tDebito;

	@Test
	public void testConstructor() {
		try {
			String sDate1 = "20-03-2024 10:28:58";
			Date fecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(sDate1);

			String ntarjeta = "123456789";
			String titular = "David";

			tDebito = new Debito(ntarjeta, titular, fecha);

			assertTrue(tDebito.mNumero.equals(ntarjeta) && tDebito.mTitular.equals(titular)
					&& tDebito.mFechaDeCaducidad.equals(fecha));

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testAsociarCuenta() {
		try {
			String ntarjeta = "123456789";
			String titular = "David";
			String sDate1 = "20-03-2024 10:28:58";
			Date fecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(sDate1);
			tDebito = new Debito(ntarjeta, titular, fecha);

			Cuenta cuenta = new Cuenta(ntarjeta, titular);
			tDebito.setCuenta(cuenta);

			assertSame(cuenta, tDebito.mCuentaAsociada);

		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testIngresar() {
		try {
			String ntarjeta = "123456789";
			String titular = "David";
			String sDate1 = "20-03-2024 10:28:58";
			Date fecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(sDate1);
			tDebito = new Debito(ntarjeta, titular, fecha);

			Cuenta cuenta = new Cuenta(ntarjeta, titular);
			tDebito.setCuenta(cuenta);
			
			double valorIngresar = 100.0;
			tDebito.ingresar(valorIngresar);
			
			assertEquals(valorIngresar, tDebito.getSaldo());
		} catch (Exception e) {
			fail(e.getMessage());

		}
	}
	
	@Test
	public void testRetirar() {
		try {
			String ntarjeta = "123456789";
			String titular = "David";
			String sDate1 = "20-03-2024 10:28:58";
			Date fecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(sDate1);
			tDebito = new Debito(ntarjeta, titular, fecha);
			
			Cuenta cuenta = new Cuenta(ntarjeta, titular);
			double valorIngresar = 100.0;
			cuenta.ingresar(valorIngresar);
			tDebito.setCuenta(cuenta);
			
			double valorRetirar = 80.0;

			tDebito.retirar(valorRetirar);
			
			assertEquals(valorIngresar-valorRetirar, tDebito.getSaldo());
		} catch (Exception e) {
			fail(e.getMessage());
			
		}
	}

}
