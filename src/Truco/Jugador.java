package Truco;

import java.util.ArrayList;
import java.util.Random;

public class Jugador implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer equipo;
	private ArrayList<Naipe> mano;
	private ArrayList<Naipe> enMesa;
	
//constructores
	public Jugador(Integer id,Mazo mazo, Integer equipo){
		Integer naipe=0;
		this.setId(id);
		this.setEquipo(equipo);
		this.setMano(new ArrayList<Naipe>());
		this.setEnMesa(new ArrayList<Naipe>());
		Random rand = new Random();
		for(Integer i=0;i<3;i++){
			naipe=rand.nextInt(mazo.getNaipes().size());
			this.getMano().add((mazo.getNaipes().get(naipe)));
			mazo.getNaipes().remove(mazo.getNaipes().get(naipe));
		}
	}
	
//getters y setters	
	
	public ArrayList<Naipe> getEnMesa() {
		return enMesa;
	}

	public Integer getEquipo() {
		return equipo;
	}

	public void setEquipo(Integer equipo) {
		this.equipo = equipo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setEnMesa(ArrayList<Naipe> enMesa) {
		this.enMesa = enMesa;
	}

	public ArrayList<Naipe> getMano() {
		return mano;
	}

	public void setMano(ArrayList<Naipe> mano) {
		this.mano = mano;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
//Metodos de la clase
	public String toString(){
		return "Jugador" + this.getId().toString() + this.getEnMesa().toString();
	}
	
	private void pasarDeManoAEnMesa(Naipe naipe){
		this.getMano().remove(naipe);
		this.getEnMesa().add(naipe);
	}
	
	private void mostrarMano(Boolean mostrarIndice){
		System.out.println("Sus naipes disponibles son:");
		for(int i=0;i<this.getMano().size();i++){
			if (mostrarIndice)	
				System.out.println(i+1 + ")" + this.getMano().get(i));
			else
				System.out.println(this.getMano().get(i));
		}
	}
	
	public  void pausa(Integer segundos){ 
		try { 
			Thread.sleep(segundos*1000); 
		} catch (Exception ignored) {} 
	} 
	
	public Jugada responderTrucoPc(Jugada jugada){
		Random rand = new Random();
		Boolean trucoDisponible=false;
		Integer opcion;
		if(jugada.getPuntosTruco()<3){
			trucoDisponible=true;
		}
		if (trucoDisponible){
			opcion=rand.nextInt(3);
		}
		else{
			opcion=rand.nextInt(2);
		}
		if(opcion==0){
			System.out.println("Equipo2: QUIERO!!");
			jugada.setPuntosTruco(jugada.getPuntosTruco()+1);
			jugada.setQuienCantoTruco(2);
		}
		else{
			if(opcion==1){
				System.out.println("Equipo2: No quiero...");
				jugada.setNoSeQuiere(true);
				return jugada;
			}
			else{
				jugada.setPuntosTruco(jugada.getPuntosTruco()+1);
				this.cantarTruco(jugada,2);
				jugada.setQuienCantoTruco(2);
				jugada=responderTrucoUser(jugada);
				if(jugada.getNoSeQuiere()){
					return jugada;
				}
			}
		}
		return jugada;
	}
	
	public void cantarTruco(Jugada jugada,Integer equipo){
		switch(jugada.getPuntosTruco()){
			case 1:
				System.out.println("-Equipo"+equipo+": TRUCO!!");
				break;
			case 2:
				System.out.println("-Equipo"+equipo+": QUIERO RE TRUCO!!");
				break;
			case 3:
				System.out.println("-Equipo"+equipo+": QUIERO VALE 4!!");
		}
	}
	
	public Jugada responderTrucoUser(Jugada jugada){
		if((jugada.getPuntosTruco())<3){
			System.out.println("1) QUIERO \n2) No quiero... \n3) Cantar siguiente \nIngrese su opcion:");
			Integer opcion=Teclado.pedirEntrada(3);
			if(opcion==1){
				System.out.println("Equipo1: QUIERO!!");
				jugada.setPuntosTruco(jugada.getPuntosTruco()+1);
				jugada.setQuienCantoTruco(1);
			}
			else{
				if(opcion==2){
					System.out.println("Equipo1: No quiero...");
					jugada.setNoSeQuiere(true);
					return jugada;
				}
				else{
					jugada.setPuntosTruco(jugada.getPuntosTruco()+1);
					this.cantarTruco(jugada,1);
					jugada.setQuienCantoTruco(1);
					jugada=responderTrucoPc(jugada);
					if(jugada.getNoSeQuiere()){
						return jugada;
					}
				}
			}
		}
		else{
			System.out.println("1) QUIERO \n2) No quiero... \nIngrese su opcion:");
			Integer opcion=Teclado.pedirEntrada(2);
			if(opcion==1){
				System.out.println("Equipo1: QUIERO!!");
				jugada.setPuntosTruco(jugada.getPuntosTruco()+1);
				jugada.setQuienCantoTruco(1);
			}
			else{
				return jugada;
			}
		}
		return jugada;
	}
	
	public Jugada jugar(Jugada jugada,Integer numeroDeTurno,Integer ronda){
		Random rand = new Random();
		Boolean trucoDisponible =false;
		//verificamos si se puede cantar truco
		if(jugada.getPuntosTruco()==1){
			trucoDisponible=true;
		}
		else{
			if(jugada.getPuntosTruco()<4){
				if( (jugada.getQuienCantoTruco() == this.getEquipo()) || (jugada.getQuienCantoTruco()==0) ){
					trucoDisponible=true;
				}
			}
		}
		//si el truco se puede cantar le damos la opcion al usuario o pc dependiendo del turno
		if (trucoDisponible){
			if(this.getId()==1){ //del equipo 1 solo canta el user
				this.mostrarMano(false);
				System.out.println("1)Elegir carta a tirar \n2)Cantar Truco \nIngrese su opcion:");
				if(Teclado.pedirEntrada(2)==1){
					this.elegirCarta();
				}
				else{
					this.cantarTruco(jugada,1);
					jugada.setQuienCantoTruco(1);
					jugada.setSeCantoTruco(true);
					jugada=this.responderTrucoPc(jugada);
					if(!jugada.getNoSeQuiere()){
						this.elegirCarta();
					}
					else{
						return jugada;
					}
				}
				
			}
			else{
				if (this.getEquipo()==2){
					if (rand.nextInt(2)==0){
						this.cantarTruco(jugada,2);
						jugada.setQuienCantoTruco(2);
						jugada.setSeCantoTruco(true);
						jugada=this.responderTrucoUser(jugada);
						if(!jugada.getNoSeQuiere()){
							this.elegirCarta();
						}
						else{
							return jugada;
						}
					}
					else{
						this.elegirCarta();
					}
				}
				else{
					this.elegirCarta();
				}
			}
		}
		else{
			this.elegirCarta();
		}
		return jugada;
	}
	
	public void elegirCarta(){
		Integer naipeElegido=0;
		Naipe naipe;
		if (this.getId().equals(1)){
			this.mostrarMano(true);
			System.out.println("Ingrese el naipe que desea tirar:");
			naipeElegido = Teclado.pedirEntrada(this.getMano().size());
			naipeElegido--;
			naipe=mano.get(naipeElegido);
			this.pasarDeManoAEnMesa(naipe);
		}
		else{
			pausa(3);
			naipe=mano.get(0);
			this.pasarDeManoAEnMesa(naipe);
		}
		System.out.println("Jugador"+this.getId()+": Elijo el naipe "+naipe);
	}
}
