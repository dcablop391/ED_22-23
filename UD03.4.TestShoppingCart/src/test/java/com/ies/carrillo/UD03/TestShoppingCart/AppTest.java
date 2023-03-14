package com.ies.carrillo.UD03.TestShoppingCart;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	ShoppingCart c1;
	ShoppingCart c2;
    
	Product p1 = new Product("Yogurt", 1.25);
	Product p2 = new Product("Platano", 2.33);
	Product p3 = new Product("Patatas fritas", 0.85);
	
	@Test
    public void testComprobarVacioAlCrear()
    {
		c1 = new ShoppingCart();
        assertEquals(0, c1.getItemCount());
    }
	
	@Test
	public void testInsertarProducto() {
		c1 = new ShoppingCart();
		int countInitial = c1.getItemCount();
		c1.addItem(p1);
        assertTrue(c1.getItemCount()>countInitial);
	}
	
	@Test
	public void testEliminarProducto() throws ProductNotFoundException {
		c1 = new ShoppingCart();
		c1.addItem(p1);
		int countInitial = c1.getItemCount();
		c1.removeItem(p1);
        assertTrue(c1.getItemCount()<countInitial);
	}
	
	@Test
	public void testEliminarProductoNoLista() {
		c1 = new ShoppingCart();
		c1.addItem(p1);
		assertThrows(ProductNotFoundException.class, () -> {c1.removeItem(p2);});
	}
	
	@Test
	public void testBalance() {
		c1 = new ShoppingCart();
		double bI = c1.getBalance();
		c1.addItem(p1);
		assertEquals(c1.getBalance(), bI+p1.getPrice());
	}

	@Test
	public void testBalanceMenos() throws ProductNotFoundException {
		c1 = new ShoppingCart();
		c1.addItem(p1);
		double bI = c1.getBalance();
		c1.removeItem(p1);
		assertEquals(c1.getBalance(), bI-p1.getPrice());
	}
	
	
	//Cuando se intenta eliminar un producto que no está en el carro, se debe lanzar una excepción ProductNotFoundException. 
	//Pista: inserta la llamada en un bloque try y pon un método fail() después de la llamada a removeItem().
	@Test
	public void testEliminarConTry() {
		c1 = new ShoppingCart();
		c1.addItem(p1);
		try {
			c1.removeItem(p2);
		} 
		catch (ProductNotFoundException expcetion) {
			System.out.println("Entra en la expcecion");
			fail(expcetion);
		}
	}
	
}
