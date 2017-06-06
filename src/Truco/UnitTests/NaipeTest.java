package Truco.UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Truco.Naipe;

public class NaipeTest {
	Naipe naipe;
	@Test
	public void testNaipe() {
		naipe=new Naipe(Naipe.Palos.Basto,5);
		assertTrue(naipe.getPalo().equals(Naipe.Palos.Basto)&&naipe.getValor()==5);
		naipe=new Naipe(Naipe.Palos.Basto,2);
		assertTrue(naipe.getPalo().equals(Naipe.Palos.Basto)&&naipe.getValor()==2);
		naipe=new Naipe(Naipe.Palos.Oro,3);
		assertTrue(naipe.getPalo().equals(Naipe.Palos.Oro)&&naipe.getValor()==3);
		naipe=new Naipe(Naipe.Palos.Espada,1);
		assertTrue(naipe.getPalo().equals(Naipe.Palos.Espada)&&naipe.getValor()==1);
		naipe=new Naipe(Naipe.Palos.Copa,5);
		assertTrue(naipe.getPalo().equals(Naipe.Palos.Copa)&&naipe.getValor()==5);
	}

	@Test
	public void testGetPalo() {
		naipe=new Naipe(Naipe.Palos.Basto,5);
		assertTrue(naipe.getPalo().equals(Naipe.Palos.Basto));
		naipe.setPalo(Naipe.Palos.Copa);
		assertTrue(naipe.getPalo().equals(Naipe.Palos.Copa));
		naipe.setPalo(Naipe.Palos.Oro);
		assertTrue(naipe.getPalo().equals(Naipe.Palos.Oro));
		naipe.setPalo(Naipe.Palos.Espada);
		assertTrue(naipe.getPalo().equals(Naipe.Palos.Espada));
	}

	@Test
	public void testSetPalo() {
		naipe=new Naipe(Naipe.Palos.Basto,5);
		assertTrue(naipe.getPalo().equals(Naipe.Palos.Basto));
		naipe.setPalo(Naipe.Palos.Copa);
		assertTrue(naipe.getPalo().equals(Naipe.Palos.Copa));
		naipe.setPalo(Naipe.Palos.Oro);
		assertTrue(naipe.getPalo().equals(Naipe.Palos.Oro));
		naipe.setPalo(Naipe.Palos.Espada);
		assertTrue(naipe.getPalo().equals(Naipe.Palos.Espada));
	}

	@Test
	public void testGetValor() {
		naipe=new Naipe(Naipe.Palos.Basto,5);
		assertTrue(naipe.getValor()==5);
		naipe.setValor(7);
		assertTrue(naipe.getValor()==7);
		naipe.setValor(1);
		assertTrue(naipe.getValor()==1);
		naipe.setValor(3);
		assertTrue(naipe.getValor()==3);
		naipe.setValor(6);
		assertTrue(naipe.getValor()==6);
	}

	@Test
	public void testSetValor() {
		naipe=new Naipe(Naipe.Palos.Basto,5);
		assertTrue(naipe.getValor()==5);
		naipe.setValor(7);
		assertTrue(naipe.getValor()==7);
		naipe.setValor(1);
		assertTrue(naipe.getValor()==1);
		naipe.setValor(3);
		assertTrue(naipe.getValor()==3);
		naipe.setValor(6);
		assertTrue(naipe.getValor()==6);
	}

	@Test
	public void testToString() {
		naipe=new Naipe(Naipe.Palos.Basto,5);
		assertTrue(naipe.toString().equals("5Basto"));
		naipe=new Naipe(Naipe.Palos.Oro,6);
		assertTrue(naipe.toString().equals("6Oro"));
		naipe=new Naipe(Naipe.Palos.Copa,5);
		assertTrue(naipe.toString().equals("5Copa"));
	}

	@Test
	public void testMayorA() {
		naipe=new Naipe(Naipe.Palos.Espada,1);
		Naipe naipe2=new Naipe(Naipe.Palos.Basto,1);
		assertTrue(naipe.mayorA(naipe2)==1);
		
		naipe=new Naipe(Naipe.Palos.Espada,1);
		naipe2=new Naipe(Naipe.Palos.Oro,1);
		assertTrue(naipe.mayorA(naipe2)==1);
		
		naipe=new Naipe(Naipe.Palos.Espada,1);
		naipe2=new Naipe(Naipe.Palos.Copa,1);
		assertTrue(naipe.mayorA(naipe2)==1);
		
		naipe=new Naipe(Naipe.Palos.Basto,1);
		naipe2=new Naipe(Naipe.Palos.Espada,1);
		assertTrue(naipe.mayorA(naipe2)==0);
		
		naipe=new Naipe(Naipe.Palos.Oro,1);
		naipe2=new Naipe(Naipe.Palos.Basto,1);
		assertTrue(naipe.mayorA(naipe2)==0);
		
		naipe=new Naipe(Naipe.Palos.Oro,1);
		naipe2=new Naipe(Naipe.Palos.Copa,1);
		assertTrue(naipe.mayorA(naipe2)==2);
		
		naipe=new Naipe(Naipe.Palos.Espada,7);
		naipe2=new Naipe(Naipe.Palos.Oro,7);
		assertTrue(naipe.mayorA(naipe2)==1);
		
		naipe=new Naipe(Naipe.Palos.Espada,7);
		naipe2=new Naipe(Naipe.Palos.Copa,7);
		assertTrue(naipe.mayorA(naipe2)==1);
		
		naipe=new Naipe(Naipe.Palos.Copa,7);
		naipe2=new Naipe(Naipe.Palos.Basto,7);
		assertTrue(naipe.mayorA(naipe2)==2);
		
		naipe=new Naipe(Naipe.Palos.Espada,3);
		naipe2=new Naipe(Naipe.Palos.Basto,3);
		assertTrue(naipe.mayorA(naipe2)==2);
		
		naipe=new Naipe(Naipe.Palos.Espada,4);
		naipe2=new Naipe(Naipe.Palos.Basto,4);
		assertTrue(naipe.mayorA(naipe2)==2);
		
		naipe=new Naipe(Naipe.Palos.Espada,5);
		naipe2=new Naipe(Naipe.Palos.Basto,4);
		assertTrue(naipe.mayorA(naipe2)==1);
		
		naipe=new Naipe(Naipe.Palos.Espada,12);
		naipe2=new Naipe(Naipe.Palos.Basto,7);
		assertTrue(naipe.mayorA(naipe2)==1);
		
		naipe=new Naipe(Naipe.Palos.Espada,7);
		naipe2=new Naipe(Naipe.Palos.Basto,1);
		assertTrue(naipe.mayorA(naipe2)==0);
	}

}
