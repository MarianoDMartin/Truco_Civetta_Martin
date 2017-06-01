package Truco;

import java.util.ArrayList;

public class Jugada {
	
	private Mazo mazo;
	private ArrayList<Jugador> jugadores;

//constructores	
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

//getters y setters	
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
	
//Metodos de la clase	
	public Boolean verificarJugadaTerminada() {
		return false;
	}
	
	public void eliminarManoDelMazo(ArrayList<Naipe> mano){
		for(Integer i=0;i<mano.size();i++){
			this.getMazo().getNaipes().remove(mano.get(i));
		}
	}
	
	public Jugador obtenerUltimoJugador(Jugador primerJugador){
		if(primerJugador.getId().equals(1)){
			return this.getJugadores().get(this.getJugadores().size());
		}
		else{
			return this.getJugadores().get(primerJugador.getId()-1);
		}
	}
	
	public Integer proximoTurno(Integer turnoActual){
		if(turnoActual.equals(this.getJugadores().size())){
			return 1;
		}
		else{
			return turnoActual+1;
		}
	}
	
}
