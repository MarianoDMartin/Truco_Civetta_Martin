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
	private Integer puntosTruco;
	private Integer quienCantoTruco;
	private Boolean seCantoTruco;
	private Boolean noSeQuiere;
	private Boolean envido;
	private Integer puntosEnvido;
	private Integer ganadorEnvido;

	//constructores	
	public Jugada(Integer cantidadJugadores){
		this.setMazo(new Mazo());
		this.setJugadores(new ArrayList<Jugador>());
		this.setRonda1(-1);
		this.setRonda2(-1);
		this.setRonda3(-1);
		this.setPuntosTruco(1);
		this.setQuienCantoTruco(0);
		this.setSeCantoTruco(false);
		this.setNoSeQuiere(false);
		this.setEnvido(false);
		this.setPuntosEnvido(0);
		this.setGanadorEnvido(0);
		Integer equipo=1;
		for(Integer i=1;i<=cantidadJugadores;i++){
			this.getJugadores().add(new Jugador(i,this.getMazo(),equipo));
			this.eliminarManoDelMazo(this.getJugadores().get(i-1).getMano());
			equipo=(equipo==1)?2:1;
		}
	}

	//getters y setters	
	
	public Mazo getMazo() {
		return this.mazo;
	}

	public Integer getGanadorEnvido() {
		return ganadorEnvido;
	}

	public void setGanadorEnvido(Integer ganadorEnvido) {
		this.ganadorEnvido = ganadorEnvido;
	}

	public Integer getPuntosEnvido() {
		return puntosEnvido;
	}

	public void setPuntosEnvido(Integer puntosEnvido) {
		this.puntosEnvido = puntosEnvido;
	}

	public Boolean getEnvido() {
		return this.envido;
	}

	public void setEnvido(Boolean envido) {
		this.envido = envido;
	}

	public Boolean getNoSeQuiere() {
		return noSeQuiere;
	}

	public void setNoSeQuiere(Boolean noSeQuiere) {
		this.noSeQuiere = noSeQuiere;
	}

	public Boolean getSeCantoTruco() {
		return this.seCantoTruco;
	}

	public void setSeCantoTruco(Boolean seCantoTruco) {
		this.seCantoTruco = seCantoTruco;
	}

	public Integer getPuntosTruco() {
		return puntosTruco;
	}

	public void setPuntosTruco(Integer puntosTruco) {
		this.puntosTruco = puntosTruco;
	}

	public Integer getQuienCantoTruco() {
		return quienCantoTruco;
	}

	public void setQuienCantoTruco(Integer quienCantoTruco) {
		this.quienCantoTruco = quienCantoTruco;
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
	public Integer envido(Integer primeroDeJugada){
		Boolean terminado=false;
		Integer cantadosEquipo1=0;
		Integer cantadosEquipo2=0;
		Integer ganador=primeroDeJugada;
		Integer turno=primeroDeJugada;
		Integer puntosGanador=this.getJugadores().get(turno).mostarPuntosEnvido(0);
		if(this.getJugadores().get(turno).getEquipo()==1){
			cantadosEquipo1++;
		}
		else{
			cantadosEquipo2++;
		}
		turno=this.proximoTurno(turno);
		while (!terminado){
			if( (this.getJugadores().get(turno).getEquipo() != this.getJugadores().get(ganador).getEquipo()) && (this.getJugadores().get(turno).getCanteEnvido().equals(false)) ){
				if(this.getJugadores().get(turno).mostarPuntosEnvido(puntosGanador)>puntosGanador){
					puntosGanador=this.getJugadores().get(turno).getEnvido();
					ganador=turno;
				}
				if(this.getJugadores().get(turno).getEquipo()==1){
					cantadosEquipo1++;
				}
				else{
					cantadosEquipo2++;
				}
				if(ganador!=turno && (cantadosEquipo1==(this.getJugadores().size()/2))||cantadosEquipo1==(this.getJugadores().size()/2)){
					terminado=true;
				}	
			}
			turno=this.proximoTurno(turno);
		}
		System.out.println("Ganador del envido: equipo"+this.getJugadores().get(ganador).getEquipo());
		return this.getJugadores().get(ganador).getEquipo();
	}
	
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
	
	public static Jugada nuevaJugada(Integer cantidadJugadores){
		return new Jugada(cantidadJugadores);
	}

}
