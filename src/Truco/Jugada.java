package Truco;

import java.util.ArrayList;

public class Jugada {
	
	private Mazo mazo;
	private ArrayList<Jugador> jugadores;
	private Integer ronda1;
	private Integer ronda2;
	private Integer ronda3;
	
//constructores	
	public Jugada(Integer cantidadJugadores){
		this.setMazo(new Mazo());
		this.setJugadores(new ArrayList<Jugador>());
		this.setRonda1(3);
		this.setRonda2(3);
		this.setRonda3(3);
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
	
	public Integer getRonda1() {
		return ronda1;
	}

	public void setRonda1(Integer ronda1) {
		this.ronda1 = ronda1;
	}

	public Integer getRonda2() {
		return ronda2;
	}

	public void setRonda2(Integer ronda2) {
		this.ronda2 = ronda2;
	}

	public Integer getRonda3() {
		return ronda3;
	}

	public void setRonda3(Integer ronda3) {
		this.ronda3 = ronda3;
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
	public void verificarRonda(Integer ronda){
		Naipe naipeMayor=null;
		Integer ganadorRonda=null;
		for(Jugador j:this.getJugadores()){
			if(j.getEnMesa().get(ronda).mayorA(naipeMayor).equals(1)){
				naipeMayor=j.getEnMesa().get(ronda);
				if( (j.getId().equals(1)) || (j.getId().equals(3)) ||(j.getId().equals(5)) ){
					ganadorRonda=1;
				}
				else{
					ganadorRonda=2;
				}
			}
			else{
				if(j.getEnMesa().get(ronda).mayorA(naipeMayor).equals(2)){
					ganadorRonda=0;
				}
			}
		}
		if(ronda.equals(0)){
			this.setRonda1(ganadorRonda);
		}
		else{
			if(ronda.equals(1)){
				this.setRonda2(ganadorRonda);
			}
			else{
				this.setRonda3(ganadorRonda);
			}
		}
	}
	
	public Integer JugadaTerminada() {
		if((this.getRonda1().equals(-1))||(this.getRonda2().equals(-1))){
			return 0;
		}
		else{
			if( ( (this.getRonda1().equals(this.getRonda2())) || (this.getRonda1().equals(this.getRonda3())) ) && (this.getRonda1().equals(1)||(this.getRonda1().equals(2)))){
				System.out.println("Ganador equipo " + this.getRonda1().toString() + "!!!");
				return this.getRonda1();
			}
			else{
			
			}
		}
		return 0;
		//aca hay que ver si un equipo ya gano dos rondas o si se gano por parda
		
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
