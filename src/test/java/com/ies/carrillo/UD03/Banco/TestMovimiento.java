package com.ies.carrillo.UD03.Banco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

/**
 * Realiza los tests de las clases Cuenta, Movimiento, Credito y Debito.
 * @author Alumnado
 *
 */
public class TestMovimiento 
{
	Movimiento m = new Movimiento();

	@Test
	public void testMovimientoConcepto()
    {
		String concep = "Prueba";
		m.setConcepto(concep);
		assertEquals(concep, m.getConcepto());
    }
	@Test
	public void testMovimientoFecha()
	{
		Date fecha = new Date();
		m.setFecha(fecha);
		assertEquals(fecha, m.getFecha());
	}
	@Test
	public void testMovimientoImporte()
	{
		double importe = 150.0;
		m.setImporte(importe);
		assertEquals(importe, m.getImporte());
	}

	@Test
	public void testMovimientoFechaFija() throws ParseException
	{
		String sDate1="20-03-2023 10:28:58";  
	    Date fecha=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(sDate1);
		m.setFecha(fecha);
		assertEquals(fecha, m.getFecha());
		
	}
}
