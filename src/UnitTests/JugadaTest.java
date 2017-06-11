package UnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Truco.Jugada;
import Truco.Jugador;
import Truco.Mazo;
import Truco.Naipe;

public class JugadaTest {

	Jugada jugada;
	@Test
	public void testJugada() {
		jugada=new Jugada(2);
		assertTrue(jugada.getJugadores().size()==2 && jugada.getRonda1()==-1 && jugada.getRonda2()==-1 && jugada.getRonda3()==-1);
		jugada=new Jugada(4);
		assertTrue(jugada.getJugadores().size()==4 && jugada.getRonda1()==-1 && jugada.getRonda2()==-1 && jugada.getRonda3()==-1);
		jugada=new Jugada(6);
		assertTrue(jugada.getJugadores().size()==6 && jugada.getRonda1()==-1 && jugada.getRonda2()==-1 && jugada.getRonda3()==-1);
	}

	@Test
	public void testGetMazo() {
		jugada=new Jugada(2);
		Mazo mazo=new Mazo();
		jugada.setMazo(mazo);
		assertTrue(jugada.getMazo().equals(mazo));
		jugada=new Jugada(4);
		mazo=new Mazo();
		jugada.setMazo(mazo);
		assertTrue(jugada.getMazo().equals(mazo));
		jugada=new Jugada(6);
		mazo=new Mazo();
		jugada.setMazo(mazo);
		assertTrue(jugada.getMazo().equals(mazo));
	}

	@Test
	public void testGetRonda1() {
		jugada=new Jugada(2);
		assertTrue(jugada.getRonda1()==-1);
		jugada=new Jugada(4);
		assertTrue(jugada.getRonda1()==-1);
		jugada=new Jugada(6);
		assertTrue(jugada.getRonda1()==-1);
	}

	@Test
	public void testSetRonda1() {
		jugada=new Jugada(2);
		jugada.setRonda1(1);
		assertTrue(jugada.getRonda1()==1);
		jugada.setRonda1(2);
		assertTrue(jugada.getRonda1()==2);
		jugada.setRonda1(3);
		assertTrue(jugada.getRonda1()==3);
	}

	@Test
	public void testGetRonda2() {
		jugada=new Jugada(2);
		assertTrue(jugada.getRonda2()==-1);
		jugada=new Jugada(4);
		assertTrue(jugada.getRonda2()==-1);
		jugada=new Jugada(6);
		assertTrue(jugada.getRonda2()==-1);
	}

	@Test
	public void testSetRonda2() {
		jugada=new Jugada(2);
		jugada.setRonda2(1);
		assertTrue(jugada.getRonda2()==1);
		jugada.setRonda2(2);
		assertTrue(jugada.getRonda2()==2);
		jugada.setRonda2(3);
		assertTrue(jugada.getRonda2()==3);
	}

	@Test
	public void testGetRonda3() {
		jugada=new Jugada(2);
		assertTrue(jugada.getRonda3()==-1);
		jugada=new Jugada(4);
		assertTrue(jugada.getRonda3()==-1);
		jugada=new Jugada(6);
		assertTrue(jugada.getRonda3()==-1);
	}

	@Test
	public void testSetRonda3() {
		jugada=new Jugada(2);
		jugada.setRonda3(1);
		assertTrue(jugada.getRonda3()==1);
		jugada.setRonda3(2);
		assertTrue(jugada.getRonda3()==2);
		jugada.setRonda3(3);
		assertTrue(jugada.getRonda3()==3);
	}

	@Test
	public void testSetMazo() {
		jugada=new Jugada(2);
		Mazo mazo=new Mazo();
		jugada.setMazo(mazo);
		assertTrue(jugada.getMazo().equals(mazo));
		jugada=new Jugada(4);
		mazo=new Mazo();
		jugada.setMazo(mazo);
		assertTrue(jugada.getMazo().equals(mazo));
		jugada=new Jugada(6);
		mazo=new Mazo();
		jugada.setMazo(mazo);
		assertTrue(jugada.getMazo().equals(mazo));
	}

	@Test
	public void testGetJugadores() {
		jugada=new Jugada(2);
		ArrayList<Jugador> jugadores=new ArrayList<Jugador>();
		jugada.setJugadores(jugadores);
		assertTrue(jugada.getJugadores().equals(jugadores));
		jugada=new Jugada(4);
		jugadores=new ArrayList<Jugador>();
		jugada.setJugadores(jugadores);
		assertTrue(jugada.getJugadores().equals(jugadores));
		jugada=new Jugada(6);
		jugadores=new ArrayList<Jugador>();
		jugada.setJugadores(jugadores);
		assertTrue(jugada.getJugadores().equals(jugadores));
	}

	@Test
	public void testSetJugadores() {
		jugada=new Jugada(2);
		ArrayList<Jugador> jugadores=new ArrayList<Jugador>();
		jugada.setJugadores(jugadores);
		assertTrue(jugada.getJugadores().equals(jugadores));
		jugada=new Jugada(4);
		jugadores=new ArrayList<Jugador>();
		jugada.setJugadores(jugadores);
		assertTrue(jugada.getJugadores().equals(jugadores));
		jugada=new Jugada(6);
		jugadores=new ArrayList<Jugador>();
		jugada.setJugadores(jugadores);
		assertTrue(jugada.getJugadores().equals(jugadores));
	}

	@Test
	public void testVerificarRonda() {
		jugada=new Jugada(2);
		Integer ronda=0;
		jugada.getJugadores().get(0).getEnMesa().add(new Naipe(Naipe.Palos.Basto,1));
		jugada.getJugadores().get(1).getEnMesa().add(new Naipe(Naipe.Palos.Espada,1));
		jugada.verificarRonda(0);
		assertTrue((jugada.getRonda1()==2) && (jugada.verificarRonda(ronda)==1));
		ronda=1;
		jugada.getJugadores().get(0).getEnMesa().add(new Naipe(Naipe.Palos.Copa,1));
		jugada.getJugadores().get(1).getEnMesa().add(new Naipe(Naipe.Palos.Oro,1));
		jugada.verificarRonda(ronda);
		assertTrue((jugada.getRonda2()==0) && (jugada.verificarRonda(ronda)==-1));
		ronda=2;
		jugada.getJugadores().get(0).getEnMesa().add(new Naipe(Naipe.Palos.Espada,7));
		jugada.getJugadores().get(1).getEnMesa().add(new Naipe(Naipe.Palos.Oro,7));
		jugada.verificarRonda(ronda);
		assertTrue((jugada.getRonda3()==1) && (jugada.verificarRonda(ronda)==0));
	}

	@Test
	public void testJugadaTerminada() {
		jugada=new Jugada(2);
		assertTrue(jugada.JugadaTerminada()==0);
		jugada.setRonda1(1);
		jugada.setRonda2(1);
		assertTrue(jugada.JugadaTerminada()==1);
		jugada.setRonda1(0);
		jugada.setRonda2(1);
		assertTrue(jugada.JugadaTerminada()==1);
		jugada.setRonda1(0);
		jugada.setRonda2(2);
		assertTrue(jugada.JugadaTerminada()==2);
		jugada.setRonda1(0);
		jugada.setRonda2(0);
		assertTrue(jugada.JugadaTerminada()==0);
		jugada.setRonda3(1);
		assertTrue(jugada.JugadaTerminada()==1);
		jugada.setRonda3(0);
		assertTrue(jugada.JugadaTerminada()==3);
		jugada.setRonda1(1);
		jugada.setRonda2(2);
		jugada.setRonda3(1);
		assertTrue(jugada.JugadaTerminada()==1);
		jugada.setRonda1(1);
		jugada.setRonda2(0);
		jugada.setRonda3(-1);
		assertTrue(jugada.JugadaTerminada()==1);
		jugada.setRonda1(1);
		jugada.setRonda2(2);
		jugada.setRonda3(2);
		assertTrue(jugada.JugadaTerminada()==2);
	}

	@Test
	public void testEliminarManoDelMazo() {
		jugada=new Jugada(2);
		jugada.setMazo(new Mazo());
		ArrayList<Naipe> mano=new ArrayList<Naipe>();
		mano.add(new Naipe(Naipe.Palos.Basto,1));
		mano.add(new Naipe(Naipe.Palos.Basto,2));
		mano.add(new Naipe(Naipe.Palos.Basto,3));
		jugada.eliminarManoDelMazo(mano);
		assertTrue(jugada.getMazo().getNaipes().size()==37);
		mano=new ArrayList<Naipe>();
		mano.add(new Naipe(Naipe.Palos.Basto,4));
		mano.add(new Naipe(Naipe.Palos.Basto,5));
		mano.add(new Naipe(Naipe.Palos.Basto,6));
		jugada.eliminarManoDelMazo(mano);
		assertTrue(jugada.getMazo().getNaipes().size()==34);
	}

	@Test
	public void testUltimoTurno() {
		jugada=new Jugada(2);
		assertTrue(jugada.ultimoTurno(0)==1);
		assertTrue(jugada.ultimoTurno(1)==0);
		jugada=new Jugada(6);
		assertTrue(jugada.ultimoTurno(0)==5);
		assertTrue(jugada.ultimoTurno(1)==0);
		assertTrue(jugada.ultimoTurno(4)==3);
		assertTrue(jugada.ultimoTurno(5)==4);
	}

	@Test
	public void testProximoTurno() {
		jugada=new Jugada(2);
		assertTrue(jugada.proximoTurno(0)==1);
		assertTrue(jugada.proximoTurno(1)==0);
		jugada=new Jugada(6);
		assertTrue(jugada.proximoTurno(0)==1);
		assertTrue(jugada.proximoTurno(1)==2);
		assertTrue(jugada.proximoTurno(2)==3);
		assertTrue(jugada.proximoTurno(5)==0);
		assertTrue(jugada.proximoTurno(3)==4);
	}

}
