package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Truco.Juego;
import Truco.Jugada;

public class JuegoTest {
	Juego juego;
	@Test
	public void testJuego() {
		juego=new Juego(15,2);
		assertTrue(juego.getPuntajeMaximo() == 15 && juego.getJugada().getJugadores().size()==2);
		juego=new Juego(15,4);
		assertTrue(juego.getPuntajeMaximo() == 15 && juego.getJugada().getJugadores().size()==4);
		juego=new Juego(15,6);
		assertTrue(juego.getPuntajeMaximo() == 15 && juego.getJugada().getJugadores().size()==6);
		juego=new Juego(30,2);
		assertTrue(juego.getPuntajeMaximo() == 30 && juego.getJugada().getJugadores().size()==2);
		juego=new Juego(30,4);
		assertTrue(juego.getPuntajeMaximo() == 30 && juego.getJugada().getJugadores().size()==4);
		juego=new Juego(30,6);
		assertTrue(juego.getPuntajeMaximo() == 30 && juego.getJugada().getJugadores().size()==6);
	}

	@Test
	public void testGetTurno() {
		juego=new Juego(15,2);
		assertTrue(juego.getTurno()>=0 && juego.getTurno()<juego.getJugada().getJugadores().size());
		juego=new Juego(15,4);
		assertTrue(juego.getTurno()>=0 && juego.getTurno()<juego.getJugada().getJugadores().size());
		juego=new Juego(15,6);
		assertTrue(juego.getTurno()>=0 && juego.getTurno()<juego.getJugada().getJugadores().size());
		juego=new Juego(30,2);
		assertTrue(juego.getTurno()>=0 && juego.getTurno()<juego.getJugada().getJugadores().size());
		juego=new Juego(30,4);
		assertTrue(juego.getTurno()>=0 && juego.getTurno()<juego.getJugada().getJugadores().size());
		juego=new Juego(30,6);
		assertTrue(juego.getTurno()>=0 && juego.getTurno()<juego.getJugada().getJugadores().size());
	}

	@Test
	public void testSetTurno() {
		juego=new Juego(30,6);
		juego.setTurno(1);
		assertTrue(juego.getTurno() == 1);
		juego.setTurno(2);
		assertTrue(juego.getTurno() == 2);
		juego.setTurno(3);
		assertTrue(juego.getTurno() == 3);
		juego.setTurno(4);
		assertTrue(juego.getTurno() == 4);
		juego.setTurno(5);
		assertTrue(juego.getTurno() == 5);
		juego.setTurno(6);
		assertTrue(juego.getTurno() == 6);
	}

	@Test
	public void testGetPuntajeMaximo() {
		juego=new Juego(15,2);
		assertTrue(juego.getPuntajeMaximo() == 15);
		juego=new Juego(30,2);
		assertTrue(juego.getPuntajeMaximo() == 30);
	}

	@Test
	public void testSetPuntajeMaximo() {
		juego=new Juego(30,2);
		juego.setPuntajeMaximo(15);
		assertTrue(juego.getPuntajeMaximo() == 15);
		juego.setPuntajeMaximo(30);
		assertTrue(juego.getPuntajeMaximo() == 30);
	}

	@Test
	public void testGetPuntaje1() {
		juego=new Juego(30,2);
		juego.setPuntaje1(10);
		assertTrue(juego.getPuntaje1()==10);
		juego.setPuntaje1(12);
		assertTrue(juego.getPuntaje1()==12);
		juego.setPuntaje1(5);
		assertTrue(juego.getPuntaje1()==5);
		juego.setPuntaje1(7);
		assertTrue(juego.getPuntaje1()==7);
		juego.setPuntaje1(30);
		assertTrue(juego.getPuntaje1()==30);
	}

	@Test
	public void testSetPuntaje1() {
		juego=new Juego(30,2);
		juego.setPuntaje1(10);
		assertTrue(juego.getPuntaje1()==10);
		juego.setPuntaje1(12);
		assertTrue(juego.getPuntaje1()==12);
		juego.setPuntaje1(5);
		assertTrue(juego.getPuntaje1()==5);
		juego.setPuntaje1(7);
		assertTrue(juego.getPuntaje1()==7);
		juego.setPuntaje1(30);
		assertTrue(juego.getPuntaje1()==30);
	}

	@Test
	public void testGetPuntaje2() {
		juego=new Juego(30,2);
		juego.setPuntaje2(10);
		assertTrue(juego.getPuntaje2()==10);
		juego.setPuntaje2(12);
		assertTrue(juego.getPuntaje2()==12);
		juego.setPuntaje2(5);
		assertTrue(juego.getPuntaje2()==5);
		juego.setPuntaje2(7);
		assertTrue(juego.getPuntaje2()==7);
		juego.setPuntaje2(30);
		assertTrue(juego.getPuntaje2()==30);
	}

	@Test
	public void testSetPuntaje2() {
		juego=new Juego(30,2);
		juego.setPuntaje2(10);
		assertTrue(juego.getPuntaje2()==10);
		juego.setPuntaje2(12);
		assertTrue(juego.getPuntaje2()==12);
		juego.setPuntaje2(5);
		assertTrue(juego.getPuntaje2()==5);
		juego.setPuntaje2(7);
		assertTrue(juego.getPuntaje2()==7);
		juego.setPuntaje2(30);
		assertTrue(juego.getPuntaje2()==30);
	}

	@Test
	public void testGetJugada() {
		juego=new Juego(30,6);
		Jugada jugada=new Jugada(6);
		juego.setJugada(jugada);
		assertTrue(juego.getJugada().equals(jugada));
		juego=new Juego(30,4);
		jugada=new Jugada(4);
		juego.setJugada(jugada);
		assertTrue(juego.getJugada().equals(jugada));
		juego=new Juego(30,2);
		jugada=new Jugada(2);
		juego.setJugada(jugada);
		assertTrue(juego.getJugada().equals(jugada));
	}

	@Test
	public void testSetJugada() {
		juego=new Juego(30,6);
		Jugada jugada=new Jugada(6);
		juego.setJugada(jugada);
		assertTrue(juego.getJugada().equals(jugada));
		juego=new Juego(30,4);
		jugada=new Jugada(4);
		juego.setJugada(jugada);
		assertTrue(juego.getJugada().equals(jugada));
		juego=new Juego(30,2);
		jugada=new Jugada(2);
		juego.setJugada(jugada);
		assertTrue(juego.getJugada().equals(jugada));
	}

}
