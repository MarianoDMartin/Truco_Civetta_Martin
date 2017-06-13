package Truco;

import java.util.ArrayList;

public class Jugada implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Mazo mazo;
	private ArrayList<Jugador> jugadores;
	private Integer ronda1;
	private Integer ronda2;
	private Integer ronda3;
	
//constructores	
	public Jugada(Integer cantidadJugadores){
		this.setMazo(new Mazo());
		this.setJugadores(new ArrayList<Jugador>());
		this.setRonda1(-1);
		this.setRonda2(-1);
		this.setRonda3(-1);
		for(Integer i=1;i<=cantidadJugadores;i++){
			this.getJugadores().add(new Jugador(i,this.getMazo()));
			this.eliminarManoDelMazo(this.getJugadores().get(i-1).getMano());
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
	public Integer verificarRonda(Integer ronda){
		Naipe naipeMayor=null;
		Integer ganadorRonda=null;
		Integer idGanador = null;
		for(Jugador j:this.getJugadores()){
			if(j.getEnMesa().get(ronda).mayorA(naipeMayor).equals(1)){
				naipeMayor=j.getEnMesa().get(ronda);
				if( (j.getId().equals(1)) || (j.getId().equals(3)) ||(j.getId().equals(5)) ){
					ganadorRonda=1;
				}
				else{
					ganadorRonda=2;
				}
				idGanador=j.getId()-1;
			}
			else{
				if(j.getEnMesa().get(ronda).mayorA(naipeMayor).equals(2)){
					ganadorRonda=0;
					idGanador=-1;
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
		return idGanador;
	}
	
	public Integer JugadaTerminada() { //0->Jugada no terminada 1->Jugada ganada por equipo1 2->Jugada ganada por equipo2 3->Jugada para el equipo mano
		if((this.getRonda1().equals(-1))||(this.getRonda2().equals(-1))){
			return 0;
		}
		else{
			if( this.getRonda1().equals(this.getRonda2()) ){
				if(this.getRonda1().equals(0)){
					if(this.getRonda3().equals(-1)){
						return 0;
					}
					else{
						if(this.getRonda3().equals(0)){
							return 3;
						}
						else{
							return this.getRonda3();
						}
					}
				}
				else{
					return this.getRonda1();
				}
			}
			else{
				if(this.getRonda1().equals(0)){
					return this.getRonda2();
				}
				else{
					if(this.getRonda2().equals(0)){
						return this.getRonda1();
					}
					else{
						if (this.getRonda3().equals(-1)){
							return 0;
						}
						else{
							if(this.getRonda3().equals(0)){
								return this.getRonda1();
							}
							else{
								return this.getRonda3();
							}
						}
					}
				}
			}
		}
	}
	
	public void eliminarManoDelMazo(ArrayList<Naipe> mano){
		for(Integer i=0;i<mano.size();i++){
			this.getMazo().getNaipes().remove(mano.get(i));
		}
	}
	
	public int ultimoTurno(Integer primerJugador){
		if(primerJugador==0){
			return this.getJugadores().size()-1;
		}
		else{
			return primerJugador-1;
		}
	}
	
	public Integer proximoTurno(Integer turnoActual){
		if(turnoActual.equals(this.getJugadores().size()-1)){
			return 0;
		}
		else{
			return turnoActual+1;
		}
	}
	
	public void nuevaJugada(){
		Integer cantidadJugadores=this.getJugadores().size();
		this.setMazo(new Mazo());
		this.setJugadores(new ArrayList<Jugador>());
		this.setRonda1(-1);
		this.setRonda2(-1);
		this.setRonda3(-1);
		for(Integer i=1;i<=cantidadJugadores;i++){
			this.getJugadores().add(new Jugador(i,this.getMazo()));
			this.eliminarManoDelMazo(this.getJugadores().get(i-1).getMano());
		}
	}
	
}
