package Truco;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jugador {
	
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
			naipe=mano.get(0);
			this.pasarDeManoAEnMesa(naipe);
		}
	}
}
