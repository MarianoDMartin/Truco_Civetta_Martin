package Truco;

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
	public static enum Palos{Espada,Basto,Copa,Oro};
	
	public String toString(){
		return this.getValor().toString()+this.getPalo().toString();
	}
	
	public Integer mayorA(Naipe naipe){//2 para iguales, 1 para Verdadero, 0 para Falso
		Integer[] orden={0,0,8,9,1,2,3,4,0,0,5,6,7};
		if(naipe.equals(null))
			return 1;
		if(this.getValor().equals(naipe.getValor())){
			if(this.getValor().equals(1)){
				if( (this.getPalo().equals(Naipe.Palos.Copa) && (naipe.getPalo().equals(Naipe.Palos.Oro))) || ((this.getPalo().equals(Naipe.Palos.Oro) && (naipe.getPalo().equals(Naipe.Palos.Copa))))){
					return 2;
				}
				else{
					if(this.getPalo().equals(Naipe.Palos.Espada)){
						return 1;
					}
					else{
						if(naipe.getPalo().equals(Naipe.Palos.Espada)){
							return 0;
						}
						else{
							if(this.getPalo().equals(Naipe.Palos.Basto)){
								return 1;
							}
							else{
								return 0;
							}
						}
					}
				}
			}
			else{
				if(this.getValor().equals(7)){
					if( (this.getPalo().equals(Naipe.Palos.Basto) && (naipe.getPalo().equals(Naipe.Palos.Copa))) || ((this.getPalo().equals(Naipe.Palos.Copa) && (naipe.getPalo().equals(Naipe.Palos.Basto))))){
						return 2;
					}
					else{
						if(this.getPalo().equals(Naipe.Palos.Espada)){
							return 1;
						}
						else{
							if(naipe.getPalo().equals(Naipe.Palos.Espada)){
								return 0;
							}
							else{
								if(this.getPalo().equals(Naipe.Palos.Oro)){
									return 1;
								}
								else{
									return 0;
								}
							}
						}
					}
				}
				else{
					return 2;
				}
			}
		}
		else{
			if( (this.getValor().equals(1)) || (naipe.getValor().equals(1)) ){
				if(this.getValor().equals(1)){
					if(this.getPalo().equals(Naipe.Palos.Copa) || this.getPalo().equals(Naipe.Palos.Oro)){
						if(orden[naipe.getValor()]<=7){
							return 1;
						}
						else{
							return 0;
						}
					}
					else{
						return 1;
					}
				}
				else{
					if(naipe.getPalo().equals(Naipe.Palos.Copa) || naipe.getPalo().equals(Naipe.Palos.Oro)){
						if(orden[this.getValor()]<=7){
							return 0;
						}
						else{
							return 1;
						}
					}
					else{
						return 0;
					}
				}
			}
			else{
				if( (this.getValor().equals(7)) || (naipe.getValor().equals(7)) ){
					if(this.getValor().equals(7)){
						if(this.getPalo().equals(Naipe.Palos.Copa) || this.getPalo().equals(Naipe.Palos.Basto)){
							if(orden[naipe.getValor()]<=3){
								return 1;
							}
							else{
								return 0;
							}
						}
						else{
							return 1;
						}
					}
					else{
						if(naipe.getPalo().equals(Naipe.Palos.Copa) || naipe.getPalo().equals(Naipe.Palos.Basto)){
							if(orden[this.getValor()]<=3){
								return 0;
							}
							else{
								return 1;
							}
						}
						else{
							return 0;
						}
					}
				}
				else{
					if(orden[this.getValor()] > orden[naipe.getValor()]){
						return 1;
					}
					else{
						return 0;
					}
				}
			}
		}
	}
	
}
