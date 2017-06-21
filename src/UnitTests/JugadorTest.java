package UnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Truco.Jugador;
import Truco.Mazo;
import Truco.Naipe;
import Truco.Teclado;

public class JugadorTest {
	
	Jugador jugador;
	@Test
	public void testJugador() {
		Teclado.nuevoTeclado();
		Teclado.agregarRandom(0);
		Teclado.agregarRandom(0);
		Teclado.agregarRandom(0);
		jugador=new Jugador(1,new Mazo(),1);
		assertTrue(jugador.getMano().get(0).equals(new Naipe(Naipe.Palos.Basto,1)));
		assertTrue(jugador.getMano().get(1).equals(new Naipe(Naipe.Palos.Basto,2)));
		assertTrue(jugador.getMano().get(2).equals(new Naipe(Naipe.Palos.Basto,3)));
		assertTrue(jugador.getId()==1 && jugador.getEnMesa().size()==0 && jugador.getMano().size()==3);
		jugador=new Jugador(2,new Mazo(),2);
		assertTrue(jugador.getId()==2 && jugador.getEnMesa().size()==0 && jugador.getMano().size()==3);
		jugador=new Jugador(3,new Mazo(),1);
		assertTrue(jugador.getId()==3 && jugador.getEnMesa().size()==0 && jugador.getMano().size()==3);
	}

	@Test
	public void testGetEnMesa() {
		jugador=new Jugador(1,new Mazo(),1);
		assertTrue(jugador.getEnMesa().size()==0);
		jugador.getEnMesa().add(new Naipe(Naipe.Palos.Basto,1));
		assertTrue(jugador.getEnMesa().size()==1);
		jugador.getEnMesa().add(new Naipe(Naipe.Palos.Basto,2));
		assertTrue(jugador.getEnMesa().size()==2);
	}

	@Test
	public void testSetEnMesa() {
		jugador=new Jugador(1,new Mazo(),1);
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
		jugador=new Jugador(1,new Mazo(),1);
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
		jugador=new Jugador(1,new Mazo(),1);
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
		jugador=new Jugador(1,new Mazo(),1);
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
		jugador=new Jugador(1,new Mazo(),1);
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
		jugador=new Jugador(1,new Mazo(),1);
		ArrayList<Naipe> mano=new ArrayList<Naipe>();
		mano.add(new Naipe(Naipe.Palos.Basto,1));
		mano.add(new Naipe(Naipe.Palos.Basto,2));
		jugador.setEnMesa(mano);
		assertTrue(jugador.toString().equals("Jugador1[1->Basto, 2->Basto]"));
	}

	@Test
	public void testElegirCarta() {
		Teclado.nuevoTeclado();
		jugador=new Jugador(1,new Mazo(),1);
		ArrayList<Naipe> mano=new ArrayList<Naipe>();
		mano.add(new Naipe(Naipe.Palos.Basto,1));
		mano.add(new Naipe(Naipe.Palos.Basto,2));
		mano.add(new Naipe(Naipe.Palos.Basto,3));
		jugador.setMano(mano);
		Teclado.agregarEntrada("2");
		jugador.elegirCarta();
		assertTrue(jugador.getEnMesa().get(0).equals((new Naipe(Naipe.Palos.Basto,2))));
		Teclado.agregarEntrada("1");
		jugador.elegirCarta();
		assertTrue(jugador.getEnMesa().get(1).equals((new Naipe(Naipe.Palos.Basto,1))));
	}
	
	@Test
	public void testPuntosEnvido() {
		jugador=new Jugador(1,new Mazo(),1);
		ArrayList<Naipe> mano=new ArrayList<Naipe>();
		mano.add(new Naipe(Naipe.Palos.Basto,10));
		mano.add(new Naipe(Naipe.Palos.Copa,10));
		mano.add(new Naipe(Naipe.Palos.Oro,10));
		jugador.setMano(mano);
		assertTrue(jugador.puntosEnvido()==0);
		mano=new ArrayList<Naipe>();
		mano.add(new Naipe(Naipe.Palos.Basto,10));
		mano.add(new Naipe(Naipe.Palos.Basto,1));
		mano.add(new Naipe(Naipe.Palos.Oro,10));
		jugador.setMano(mano);
		assertTrue(jugador.puntosEnvido()==21);
		mano=new ArrayList<Naipe>();
		mano.add(new Naipe(Naipe.Palos.Basto,5));
		mano.add(new Naipe(Naipe.Palos.Basto,6));
		mano.add(new Naipe(Naipe.Palos.Basto,10));
		jugador.setMano(mano);
		assertTrue(jugador.puntosEnvido()==31);
		mano=new ArrayList<Naipe>();
		mano.add(new Naipe(Naipe.Palos.Basto,10));
		mano.add(new Naipe(Naipe.Palos.Basto,7));
		mano.add(new Naipe(Naipe.Palos.Basto,6));
		jugador.setMano(mano);
		assertTrue(jugador.puntosEnvido()==33);
		mano=new ArrayList<Naipe>();
		mano.add(new Naipe(Naipe.Palos.Basto,10));
		mano.add(new Naipe(Naipe.Palos.Oro,6));
		mano.add(new Naipe(Naipe.Palos.Copa,7));
		jugador.setMano(mano);
		System.out.println(jugador.puntosEnvido());
		assertTrue(jugador.puntosEnvido()==7);
		mano=new ArrayList<Naipe>();
		mano.add(new Naipe(Naipe.Palos.Basto,10));
		mano.add(new Naipe(Naipe.Palos.Basto,7));
		mano.add(new Naipe(Naipe.Palos.Copa,6));
		jugador.setMano(mano);
		System.out.println(jugador.puntosEnvido());
		assertTrue(jugador.puntosEnvido()==27);
	}

}
