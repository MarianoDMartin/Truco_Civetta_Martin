package Truco;

import java.util.ArrayList;

public class Jugada {
	
	private Mazo mazo;
	private ArrayList<Jugador> jugadores;
	
	public Jugada(Integer cantidadJugadores){
		this.setMazo(new Mazo());
		this.setJugadores(new ArrayList<Jugador>());
		for(Integer i=1;i<=cantidadJugadores;i++){
			this.getJugadores().add(new Jugador(i,this.getMazo()));
			this.eliminarManoDelMazo(this.getJugadores().get(i-1).getMano());
			System.out.println(this.getJugadores().get(i-1));
			System.out.println(this.getMazo().toString());
		}
	}
	
	public Mazo getMazo() {
		return this.mazo;
	}
	
	public void setMazo(Mazo mazo) {
		this.mazo = mazo;
	}
	
	public ArrayList<Jugador> getJugadores() {
		return this.jugadores;
	}
	
	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	public void eliminarManoDelMazo(ArrayList<Naipe> mano){
		for(Integer i=0;i<mano.size();i++){
			this.getMazo().getNaipes().remove(mano.get(i));
		}
	}
	
}
