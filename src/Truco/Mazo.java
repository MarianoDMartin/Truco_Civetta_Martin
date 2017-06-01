package Truco;

import java.util.ArrayList;

public class Mazo {
	private ArrayList<Naipe> naipes;

//constructores
	public Mazo(){
		this.setNaipes(new ArrayList<Naipe>());
		for(int i=1;i<=12;i++){
			if(i!=8 && i!=9){
				this.getNaipes().add(new Naipe(Naipe.Palos.Basto,i));
			}
		}
		for(int i=1;i<=12;i++){
			if(i!=8 && i!=9){
				this.getNaipes().add(new Naipe(Naipe.Palos.Copa,i));
			}
		}
		for(int i=1;i<=12;i++){
			if(i!=8 && i!=9){
				this.getNaipes().add(new Naipe(Naipe.Palos.Espada,i));
			}
		}
		for(int i=1;i<=12;i++){
			if(i!=8 && i!=9){
				this.getNaipes().add(new Naipe(Naipe.Palos.Oro,i));
			}
		}
	}
	
//getters y setters		
	public ArrayList<Naipe> getNaipes() {
		return this.naipes;
	}

	public void setNaipes(ArrayList<Naipe> naipes) {
		this.naipes = naipes;
	}

//Metodos de la clase
	public String toString(){
		String retorno = "";
		Integer i=0;
		for(Naipe naipe:this.getNaipes()){
			retorno=retorno+"||[" + i.toString() + "] " + naipe.getValor().toString() + naipe.getPalo().toString(); 
			i++;
		}
		return retorno;
	}
	
	
		
}
