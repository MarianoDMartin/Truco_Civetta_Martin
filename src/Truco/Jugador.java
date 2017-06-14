package Truco;

import java.util.ArrayList;
import java.util.Random;

public class Jugador implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private ArrayList<Naipe> mano;
	private ArrayList<Naipe> enMesa;
	
//constructores
	public Jugador(Integer id,Mazo mazo){
		Integer naipe=0;
		this.setId(id);
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
	
	private void mostrarMano(){
		System.out.println("Sus naipes disponibles son:");
		for(int i=0;i<this.getMano().size();i++){
			System.out.println(i+1 + ")" + this.getMano().get(i));
		}
	}
	
	public  void pausa(){ 
		try { 
			Thread.sleep(3000); 
		} catch (Exception ignored) {} 
	} 
	
	public Jugada cantarTruco(Jugada jugada){
			System.out.println("QUIERO!!");
			jugada.setPuntosTruco(2);
			jugada.setQuienCantoTruco(2);
		return jugada;
	}
	
	public Jugada jugar(Jugada jugada,Integer numeroDeTurno,Integer ronda){
		Boolean trucoDisponible =false;
		if(jugada.getPuntosTruco()==1){
			trucoDisponible=true;
		}
		else{
			if(jugada.getPuntosTruco()<4){
				if( ((jugada.getQuienCantoTruco()==1) && ( (this.getId()==1)||(this.getId()==3)||(this.getId()==5)) || ((jugada.getQuienCantoTruco()==2) && ( (this.getId()==2)||(this.getId()==4)||(this.getId()==6)))) ){
					trucoDisponible=true;
				}
			}
		}
		if(this.getId()==1){
			if (trucoDisponible){
				System.out.println("1)Elegir carta a tirar \n2)Cantar Truco \nIngrese su opcion:");
				if(Teclado.pedirEntrada(2)==1){
					this.elegirCarta();
				}
				else{
					jugada.setQuienCantoTruco(1);
					jugada=this.cantarTruco(jugada);
					if(jugada.getQuienCantoTruco()==2){
						this.elegirCarta();
					}
					else{
						return jugada;
					}
				}
				
			}
			else{
				this.elegirCarta();
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
			mostrarMano();
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
