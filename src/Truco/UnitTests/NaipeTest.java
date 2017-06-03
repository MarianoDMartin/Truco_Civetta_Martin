package Truco.UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Truco.Naipe;

public class NaipeTest {

	@Test
	public void testNaipe() {
		Naipe naipe=new Naipe(Naipe.Palos.Basto,5);
		assertTrue(naipe.getPalo().equals(Naipe.Palos.Basto));
		assertTrue(naipe.getValor().equals(5));
	}

	@Test
	public void testGetPalo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPalo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetValor() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetValor() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testMayorA() {
		fail("Not yet implemented");
	}

}
