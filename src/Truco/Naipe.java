package Truco;

public class Naipe {
	
	private Palos palo;
	private Integer valor;
	
	public Naipe(Palos palo, Integer valor){
		this.setPalo(palo);
		this.setValor(valor);
	}

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

	public static enum Palos{Espada,Basto,Copa,Oro};
	
	public String toString(){
		return this.getValor().toString()+this.getPalo().toString();
	}
	
}
