package Truco;

import java.util.Random;

public class Juego implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		Integer ganadorJugada=0;
		Integer ronda=0;
		Integer auxTurno;
		Integer primerJugadorDeMano=this.getTurno();
		Integer primeroDeJugada=primerJugadorDeMano;
		while ((puntaje1 < puntajeMaximo) && (puntaje2 < puntajeMaximo)){
			System.out.println("Puntos equipo 1: "+ this.getPuntaje1());
			System.out.println("Puntos equipo 2: "+ this.getPuntaje2());
			System.out.println("Comienza el jugador"+(this.getTurno()+1));
			while(ganadorJugada==0){
				Integer numeroDeTurno=0;
				while( this.getJugada().getJugadores().get(this.getJugada().ultimoTurno(primerJugadorDeMano)).getEnMesa().size()==ronda){
					numeroDeTurno++;
					System.out.println("Turno jugador"+(this.getTurno()+1));
					
					this.setJugada(this.getJugada().getJugadores().get(this.getTurno()).jugar(this.getJugada(),numeroDeTurno,ronda));
					if(this.getJugada().getQuienCantoTruco()==1){
						ganadorJugada=1;
					}
					this.setTurno(this.getJugada().proximoTurno(this.getTurno()));
				}
				auxTurno=this.getJugada().verificarRonda(ronda);
				if (auxTurno!=-1){
					primerJugadorDeMano=auxTurno;
					this.setTurno(auxTurno);
					System.out.println("Ganador de la ronda: Jugador"+(auxTurno+1));
				}
				else{
					System.out.println("Parda!");
				}
				ronda++;
				ganadorJugada=this.getJugada().JugadaTerminada();
			}
			if(ganadorJugada==3){
				if((primeroDeJugada==0)||(primeroDeJugada==2)||(primeroDeJugada==4)){
					ganadorJugada=1;
				}
				else{
					ganadorJugada=2;
				}
			}
			System.out.println("Ganador de mano equipo "+ganadorJugada+"!!!");
			if(ganadorJugada==1){
				this.setPuntaje1(this.getPuntaje1()+2);
			}
			else{
				this.setPuntaje2(this.getPuntaje2()+2);
			}
			
			this.setTurno(jugada.proximoTurno(primeroDeJugada));
			primerJugadorDeMano=this.getTurno();
			ganadorJugada=0;
			ronda=0;
			this.getJugada().nuevaJugada();
			System.out.println("1)Seguir Jugando \n2)Guardar y salir \nIngresa tu opcion:");
			if(Teclado.pedirEntrada(2)==2){
				Archivos.guardarJuego(this);
				puntaje1=puntajeMaximo;
			}
			
		}
	}
}
