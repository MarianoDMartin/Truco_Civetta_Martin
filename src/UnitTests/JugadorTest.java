package UnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Truco.Jugador;
import Truco.Mazo;
import Truco.Naipe;

public class JugadorTest {
	
	Jugador jugador;
	@Test
	public void testJugador() {
		jugador=new Jugador(1,new Mazo());
		assertTrue(jugador.getId()==1 && jugador.getEnMesa().size()==0 && jugador.getMano().size()==3);
		jugador=new Jugador(2,new Mazo());
		assertTrue(jugador.getId()==2 && jugador.getEnMesa().size()==0 && jugador.getMano().size()==3);
		jugador=new Jugador(3,new Mazo());
		assertTrue(jugador.getId()==3 && jugador.getEnMesa().size()==0 && jugador.getMano().size()==3);
	}

	@Test
	public void testGetEnMesa() {
		jugador=new Jugador(1,new Mazo());
		assertTrue(jugador.getEnMesa().size()==0);
		jugador.getEnMesa().add(new Naipe(Naipe.Palos.Basto,1));
		assertTrue(jugador.getEnMesa().size()==1);
		jugador.getEnMesa().add(new Naipe(Naipe.Palos.Basto,2));
		assertTrue(jugador.getEnMesa().size()==2);
	}

	@Test
	public void testSetEnMesa() {
		jugador=new Jugador(1,new Mazo());
		ArrayList<Naipe> mano=new ArrayList<Naipe>();
		mano.add(new Naipe(Naipe.Palos.Basto,1));
		jugador.setEnMesa(mano);
		assertTrue(jugador.getEnMesa().size()==1);
		mano.add(new Naipe(Naipe.Palos.Basto,2));
		jugador.setEnMesa(mano);
		assertTrue(jugador.getEnMesa().size()==2);
	}

	@Test
	public void testGetMano() {
		jugador=new Jugador(1,new Mazo());
		ArrayList<Naipe> mano=new ArrayList<Naipe>();
		mano.add(new Naipe(Naipe.Palos.Basto,1));
		jugador.setMano(mano);
		assertTrue(jugador.getMano().size()==1);
		mano.add(new Naipe(Naipe.Palos.Basto,2));
		jugador.setMano(mano);
		assertTrue(jugador.getMano().size()==2);
	}

	@Test
	public void testSetMano() {
		jugador=new Jugador(1,new Mazo());
		ArrayList<Naipe> mano=new ArrayList<Naipe>();
		mano.add(new Naipe(Naipe.Palos.Basto,1));
		jugador.setMano(mano);
		assertTrue(jugador.getMano().size()==1);
		mano.add(new Naipe(Naipe.Palos.Basto,2));
		jugador.setMano(mano);
		assertTrue(jugador.getMano().size()==2);
	}

	@Test
	public void testGetId() {
		jugador=new Jugador(1,new Mazo());
		assertTrue(jugador.getId()==1);
		jugador.setId(2);
		assertTrue(jugador.getId()==2);
		jugador.setId(3);
		assertTrue(jugador.getId()==3);
		jugador.setId(4);
		assertTrue(jugador.getId()==4);
	}

	@Test
	public void testSetId() {
		jugador=new Jugador(1,new Mazo());
		jugador.setId(1);
		assertTrue(jugador.getId()==1);
		jugador.setId(2);
		assertTrue(jugador.getId()==2);
		jugador.setId(3);
		assertTrue(jugador.getId()==3);
		jugador.setId(4);
		assertTrue(jugador.getId()==4);
	}

	@Test
	public void testToString() {
		jugador=new Jugador(1,new Mazo());
		ArrayList<Naipe> mano=new ArrayList<Naipe>();
		mano.add(new Naipe(Naipe.Palos.Basto,1));
		mano.add(new Naipe(Naipe.Palos.Basto,2));
		jugador.setEnMesa(mano);
		assertTrue(jugador.toString().equals("Jugador1[1->Basto, 2->Basto]"));
	}

	@Test
	public void testElegirCarta() {
		jugador=new Jugador(1,new Mazo());
		ArrayList<Naipe> mano=new ArrayList<Naipe>();
		mano.add(new Naipe(Naipe.Palos.Basto,1));
		mano.add(new Naipe(Naipe.Palos.Basto,2));
		mano.add(new Naipe(Naipe.Palos.Basto,3));
		jugador.setMano(mano);
		System.out.println("para esta prueba ingresar 1");
		System.out.println(jugador.getMano());
		jugador.elegirCarta();
		assertTrue(jugador.getMano().equals(mano));
	}

}
