package Truco;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jugador {
	
	private Integer id;
	private ArrayList<Naipe> mano;
	private ArrayList<Naipe> enMesa;

	public Jugador(Integer id,Mazo mazo){
		Integer naipe=0;
		this.setId(id);
		this.setMano(new ArrayList<Naipe>());
		Random rand = new Random();
		for(Integer i=0;i<3;i++){
			naipe=rand.nextInt(mazo.getNaipes().size());
			this.getMano().add((mazo.getNaipes().get(naipe)));
			mazo.getNaipes().remove(mazo.getNaipes().get(naipe));
		}
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
	
	public String toString(){
		return "Jugador" + this.getId().toString() + this.getMano().toString();
	}

	public Naipe elegirCarta(){
		Integer naipeElegido=0;
		if (this.getId().equals(1)){
			Scanner teclado = new Scanner (System.in);
			System.out.println("Ingrese el naipe que desea tirar:");
			System.out.println(mano.toString());
			naipeElegido = teclado.nextInt();
			teclado.close();
			naipeElegido--;
			return mano.get(naipeElegido);
		}
		else{
			return mano.get(0);
		}
	}
}
