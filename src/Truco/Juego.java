package Truco;

import java.util.Random;

public class Juego {
	
	private Integer puntaje1;
	private Integer puntaje2;
	private Jugada jugada;
	private Integer puntajeMaximo;
	private Integer turno;

//constructores
	public Juego(Integer puntajeMaximo, Integer cantidadJugadores){
		this.setPuntaje1(new Integer(0));
		this.setPuntaje2(new Integer(0));
		this.setPuntajeMaximo(puntajeMaximo);
		this.setJugada(new Jugada(cantidadJugadores));
		Random rand = new Random();
		this.setTurno(rand.nextInt(cantidadJugadores));
	}

//getters y setters	
	public Integer getTurno() {
		return turno;
	}

	public void setTurno(Integer turno) {
		this.turno = turno;
	}

	public Integer getPuntajeMaximo() {
		return puntajeMaximo;
	}

	public void setPuntajeMaximo(Integer puntajeMaximo) {
		this.puntajeMaximo = puntajeMaximo;
	}

	public Integer getPuntaje1() {
		return puntaje1;
	}
	
	public void setPuntaje1(Integer puntaje1) {
		this.puntaje1 = puntaje1;
	}
	
	public Integer getPuntaje2() {
		return puntaje2;
	}
	
	public void setPuntaje2(Integer puntaje2) {
		this.puntaje2 = puntaje2;
	}
	
	public Jugada getJugada() {
		return jugada;
	}
	
	public void setJugada(Jugada jugada) {
		this.jugada = jugada;
	}
	
//Metodos de la clase	
	public void EmpezarJuego(){
		Integer ronda=0;
		Jugador primerJugador=this.getJugada().getJugadores().get(this.getTurno()-1);
		while ((puntaje1 < puntajeMaximo) && (puntaje2 < puntajeMaximo)){
			while(!this.getJugada().JugadaTerminada()){
				while(this.getJugada().obtenerUltimoJugador(primerJugador).getEnMesa().get(ronda).equals(null)){
					this.getJugada().getJugadores().get(this.getTurno()-1).elegirCarta();
					this.setTurno(this.getJugada().proximoTurno(this.getTurno()));
				}
				this.getJugada().verificarRonda(ronda);
				ronda++;
			}
		}
	}
}
