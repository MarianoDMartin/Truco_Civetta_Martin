package Truco;

import java.util.ArrayList;
import java.util.Random;

public class Jugador {
	
	private Integer id;
	private ArrayList<Naipe> mano;

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

}
