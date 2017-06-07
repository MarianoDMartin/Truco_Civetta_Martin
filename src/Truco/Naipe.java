package Truco;

import java.util.ArrayList;

public class Naipe {
	
	private Palos palo;
	private Integer valor;
	
//constructores	
	public Naipe(Palos palo, Integer valor){
		this.setPalo(palo);
		this.setValor(valor);
	}
	
//getters y setters	
	public Palos getPalo() {
		return this.palo;
	}

	public void setPalo(Palos palo) {
		this.palo = palo;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

//Metodos de la clase
	public static enum Palos{Espada,Basto,Copa,Oro,Null};
	
	public String toString(){
		return this.getValor().toString()+this.getPalo().toString();
	}
	
	public boolean equals(Object paramObject){
		Naipe n=(Naipe) paramObject;
		return ( this.getPalo().equals(n.getPalo()) && this.getValor().equals(n.getValor()) );
	}
	
	private Integer posicion(Naipe naipe,Naipe[] ordenDeCartas){
		for(int i=0;i<ordenDeCartas.length;i++){
			if(ordenDeCartas[i].equals(naipe)){
				return i;
			}
		}
		System.out.println("FATAL ERROR: NO SE ENCONTRO POS DE CARTA EN posicion(naipe,orden)");
		return -1;
	}
	
	public Integer mayorA(Naipe naipe){//2 para iguales, 1 para Verdadero, 0 para Falso
		Naipe[] ordenDeCartas={(new Naipe(Naipe.Palos.Null,4)),(new Naipe(Naipe.Palos.Null,5)),(new Naipe(Naipe.Palos.Null,6)),(new Naipe(Naipe.Palos.Null,7)),(new Naipe(Naipe.Palos.Null,10)),(new Naipe(Naipe.Palos.Null,11)),(new Naipe(Naipe.Palos.Null,12)),(new Naipe(Naipe.Palos.Null,1)),(new Naipe(Naipe.Palos.Null,2)),(new Naipe(Naipe.Palos.Null,3)),(new Naipe(Naipe.Palos.Oro,7)),(new Naipe(Naipe.Palos.Espada,7)),(new Naipe(Naipe.Palos.Basto,1)),(new Naipe(Naipe.Palos.Espada,1))};
		Naipe thisNaipe=null;
		Naipe paramNaipe=null;
		if(naipe==null)
			return 1;
		
		if( this.getValor()==1 && (this.getPalo().equals(Naipe.Palos.Espada) || this.getPalo().equals(Naipe.Palos.Basto)) ){
			thisNaipe=this;
		}
		else{
			if( this.getValor()==7 && (this.getPalo().equals(Naipe.Palos.Oro) || this.getPalo().equals(Naipe.Palos.Espada)) ){
				thisNaipe=this;
			}
			else{
				thisNaipe=new Naipe(Naipe.Palos.Null,this.getValor());
			}
		}
		
		if( naipe.getValor()==1 && (naipe.getPalo().equals(Naipe.Palos.Espada) || naipe.getPalo().equals(Naipe.Palos.Basto)) ){
			paramNaipe=naipe;
		}
		else{
			if( naipe.getValor()==7 && (naipe.getPalo().equals(Naipe.Palos.Oro) || naipe.getPalo().equals(Naipe.Palos.Espada)) ){
				paramNaipe=naipe;
			}
			else{
				paramNaipe=new Naipe(Naipe.Palos.Null,naipe.getValor());
			}
		}
		
		Integer posThis=null;
		Integer posParam=null;
		posThis=this.posicion(thisNaipe, ordenDeCartas);
		posParam=this.posicion(paramNaipe, ordenDeCartas);
		
		if(posThis>posParam){
			return 1;
		}
		else{
			if(posThis<posParam){
				return 0;
			}
			else{
				return 2;
			}
		}
	}
	
}
