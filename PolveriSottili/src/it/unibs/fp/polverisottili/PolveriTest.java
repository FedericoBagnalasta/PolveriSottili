package it.unibs.fp.polverisottili;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolveriTest {
	
	//private int valori[] = new int[7];    funziona tutto anche togliendo questa riga

	/**
	 * valori tutti ugauli e sotto la soglia media
	 */
	@Test
	public void test1() {
		int valori[] = {40, 40, 40, 40, 40, 40, 40};
		final SettimanaPolveri settimana = new SettimanaPolveri(2022, 1, valori);
		assertFalse(settimana.allarmeMedio());
	}
	
	/**
	 * valori tutti uguali e sopra la soglia massima
	 */
	@Test
	public void test2() {
		int valori[] = {90, 90, 90, 90, 90, 90, 90};
		final SettimanaPolveri settimana = new SettimanaPolveri(2022, 1, valori);
		assertTrue(settimana.allarmeMedio());
		assertTrue(settimana.allarmeMassimo());
	}
	
	/**
	 * un valore sopra la soglia massima e tutti gli altri molto bassi
	 */
	@Test
	public void test3() {
		int valori[] = {10, 5, 7, 20, 100, 10, 21};
		final SettimanaPolveri settimana = new SettimanaPolveri(2022, 1, valori);
		assertTrue(settimana.allarmeMassimo());
	}
	
	/**
	 * valori superiori alla soglia media ma inferiori a quella massima
	 */
	@Test
	public void test4() {
		int valori[] = {51, 57, 76, 78, 69, 65, 77};
		final SettimanaPolveri settimana = new SettimanaPolveri(2022, 1, valori);
		assertTrue(settimana.allarmeMedio());
		assertFalse(settimana.allarmeMassimo());
	}
}