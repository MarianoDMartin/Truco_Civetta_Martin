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
	
	public  void pausa(){ 
		try { 
			Thread.sleep(3000); 
		} catch (Exception ignored) {} 
	} 
	
	public Jugada responderTrucoPc(Jugada jugada){
		Random rand = new Random();
		if (rand.nextInt(3)==0){
			System.out.println("-Equipo2: QUIERO!!");
			jugada.setPuntosTruco(jugada.getPuntosTruco()+1);
			jugada.setQuienCantoTruco(2);
		}
		else{
			System.out.println("No quiero...");
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
		if(jugada.getPuntosTruco()<4){
			System.out.println("1) QUIERO \n2) No quiero... 3) Cantar siguiente \nIngrese su opcion:");
			Integer opcion=Teclado.pedirEntrada(3);
			if(opcion==1){
				System.out.println("Equipo1: QUIERO!!");
				jugada.setPuntosTruco(jugada.getPuntosTruco()+1);
				jugada.setQuienCantoTruco(1);
			}
			else{
				if(opcion==2){
					System.out.println("Equipo1: No quiero...");
					return jugada;
				}
				else{
					this.cantarTruco(jugada,1);
					jugada.setPuntosTruco(jugada.getPuntosTruco()+1);
					jugada.setQuienCantoTruco(1);
					jugada=responderTrucoPc(jugada);
				}
			}
		}
		return jugada;
	}
	
	public Jugada jugar(Jugada jugada,Integer numeroDeTurno,Integer ronda){
		Random rand = new Random();
		Boolean trucoDisponible =false;
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
		if (trucoDisponible){
			if(this.getId()==1){
				this.mostrarMano(false);
				System.out.println("1)Elegir carta a tirar \n2)Cantar Truco \nIngrese su opcion:");
				if(Teclado.pedirEntrada(2)==1){
					this.elegirCarta();
				}
				else{
					cantarTruco(jugada,1);
					jugada.setQuienCantoTruco(this.getEquipo());
					jugada.setSeCantoTruco(true);
					jugada=this.responderTrucoPc(jugada);
					if(jugada.getQuienCantoTruco()==2){
						this.elegirCarta();
					}
					else{
						return jugada;
					}
				}
				
			}
			else{
				if (rand.nextInt(10)==0){
					jugada.setQuienCantoTruco(this.getEquipo());
					jugada.setSeCantoTruco(true);
					this.cantarTruco(jugada,2);
					jugada=this.responderTrucoUser(jugada);
					if(jugada.getQuienCantoTruco()==1){
						this.elegirCarta();
					}
					else{
						return jugada;
					}
				}
				elegirCarta();
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
			pausa();
			naipe=mano.get(0);
			this.pasarDeManoAEnMesa(naipe);
		}
		System.out.println("Elijo el naipe "+naipe);
	}
}
