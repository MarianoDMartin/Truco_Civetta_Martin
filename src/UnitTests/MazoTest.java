package UnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Truco.Mazo;
import Truco.Naipe;

public class MazoTest {

	Mazo mazo;
	@Test
	public void testMazo() {
		mazo=new Mazo();
		assertTrue(mazo.getNaipes().size()==40);
	}

	@Test
	public void testGetNaipes() {
		mazo=new Mazo();
		ArrayList<Naipe> naipes= new ArrayList<Naipe>();
		naipes.add(new Naipe(Naipe.Palos.Basto,1));
		naipes.add(new Naipe(Naipe.Palos.Espada,1));
		mazo.setNaipes(naipes);
		assertTrue(mazo.getNaipes().equals(naipes));
		naipes.add(new Naipe(Naipe.Palos.Copa,4));
		mazo.setNaipes(naipes);
		assertTrue(mazo.getNaipes().equals(naipes));
	}

	@Test
	public void testSetNaipes() {
		mazo=new Mazo();
		ArrayList<Naipe> naipes= new ArrayList<Naipe>();
		naipes.add(new Naipe(Naipe.Palos.Basto,1));
		naipes.add(new Naipe(Naipe.Palos.Espada,1));
		mazo.setNaipes(naipes);
		assertTrue(mazo.getNaipes().equals(naipes));
		naipes.add(new Naipe(Naipe.Palos.Copa,4));
		mazo.setNaipes(naipes);
		assertTrue(mazo.getNaipes().equals(naipes));
	}

}
