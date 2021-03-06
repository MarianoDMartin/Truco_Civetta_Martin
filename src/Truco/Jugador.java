package Truco;

import java.util.ArrayList;

public class Jugador implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer equipo;
	private ArrayList<Naipe> mano;
	private ArrayList<Naipe> enMesa;
	private Integer envido;
	private Boolean canteEnvido;
	
//constructores
	public Jugador(Integer id,Mazo mazo, Integer equipo){
		Integer naipe=0;
		this.setId(id);
		this.setEquipo(equipo);
		this.setMano(new ArrayList<Naipe>());
		this.setEnMesa(new ArrayList<Naipe>());
		for(Integer i=0;i<3;i++){
			naipe=Teclado.obtenerRandom((mazo.getNaipes().size()));
			this.getMano().add((mazo.getNaipes().get(naipe)));
			mazo.getNaipes().remove(mazo.getNaipes().get(naipe));
		}
		this.setEnvido(this.puntosEnvido());
		this.setCanteEnvido(false);
	}
	
//getters y setters	
	
	public ArrayList<Naipe> getEnMesa() {
		return enMesa;
	}

	public Boolean getCanteEnvido() {
		return canteEnvido;
	}

	public void setCanteEnvido(Boolean canteEnvido) {
		this.canteEnvido = canteEnvido;
	}

	public Integer getEnvido() {
		return this.envido;
	}

	public void setEnvido(Integer envido) {
		this.envido = envido;
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
	public Integer puntosEnvido(){
		Integer naipe1;
		Integer naipe2;
		Integer puntos;
		if(this.getMano().get(0).getPalo().equals(this.getMano().get(1).getPalo()) && this.getMano().get(0).getPalo().equals(this.getMano().get(2).getPalo())){
			if(this.getMano().get(0).getValor()>=10){
				naipe1=this.getMano().get(1).getValor();
				naipe2=this.getMano().get(2).getValor();
			}
			else{
				if(this.getMano().get(1).getValor()>=10){
					naipe1=this.getMano().get(0).getValor();
					naipe2=this.getMano().get(2).getValor();
				}
				else{
					if(this.getMano().get(2).getValor()>=10){
						naipe1=this.getMano().get(0).getValor();
						naipe2=this.getMano().get(1).getValor();
					}
					else{
						if(this.getMano().get(0).getValor()<this.getMano().get(1).getValor() && this.getMano().get(0).getValor()<this.getMano().get(2).getValor()){
							naipe1=this.getMano().get(1).getValor();
							naipe2=this.getMano().get(2).getValor();
						}
						else{
							if(this.getMano().get(1).getValor()<this.getMano().get(0).getValor() && this.getMano().get(1).getValor()<this.getMano().get(2).getValor()){
								naipe1=this.getMano().get(0).getValor();
								naipe2=this.getMano().get(2).getValor();
							}
							else{
								naipe1=this.getMano().get(0).getValor();
								naipe2=this.getMano().get(1).getValor();
							}
						}
					}
				}
			}
		}
		else{
			if(this.getMano().get(0).getPalo().equals(this.getMano().get(1).getPalo())){
				naipe1=this.getMano().get(0).getValor();
				naipe2=this.getMano().get(1).getValor();
			}
			else{
				if(this.getMano().get(0).getPalo().equals(this.getMano().get(2).getPalo())){
					naipe1=this.getMano().get(0).getValor();
					naipe2=this.getMano().get(2).getValor();
				}
				else{
					if(this.getMano().get(1).getPalo().equals(this.getMano().get(2).getPalo())){
						naipe1=this.getMano().get(0).getValor();
						naipe2=this.getMano().get(2).getValor();
					}
					else{
						if( (this.getMano().get(0).getValor()>this.getMano().get(1).getValor() || this.getMano().get(1).getValor()>=10) && (this.getMano().get(0).getValor()>this.getMano().get(2).getValor() || this.getMano().get(2).getValor()>=10) && (this.getMano().get(0).getValor()<10)){
							return this.getMano().get(0).getValor();
						}
						else{
							if( (this.getMano().get(1).getValor()>this.getMano().get(0).getValor() || this.getMano().get(0).getValor()>=10) && (this.getMano().get(1).getValor()>this.getMano().get(2).getValor() || this.getMano().get(2).getValor()>=10) && (this.getMano().get(1).getValor()<10)){
								return this.getMano().get(1).getValor();
							}
							else{
								if( (this.getMano().get(2).getValor()>this.getMano().get(0).getValor() || this.getMano().get(0).getValor()>=10) && (this.getMano().get(2).getValor()>this.getMano().get(1).getValor() || this.getMano().get(1).getValor()>=10) && (this.getMano().get(2).getValor()<10)){
									return this.getMano().get(2).getValor();
								}
								else{
									return 0;
								}
							}
						}
					}
				}
			}
		}
		if(naipe1>=10){
			puntos=naipe1-10;
		}
		else{
			puntos=naipe1;
		}
		if(naipe2>=10){
			puntos=puntos+naipe2-10;
		}
		else{
			puntos=puntos+naipe2;
		}
		return puntos+20;
	}
	
	public Integer mostarPuntosEnvido(Integer puntosGanador){
		if(this.getEnvido()>puntosGanador)
			System.out.println("Jugador"+this.getId()+": "+this.getEnvido());
		else
			System.out.println("Jugador"+this.getId()+": Son buenas...");
		this.setCanteEnvido(true);
		return this.getEnvido();
	}
	
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
		Boolean trucoDisponible=false;
		Integer opcion;
		if(jugada.getPuntosTruco()<3){
			trucoDisponible=true;
		}
		if (trucoDisponible){
			opcion=Teclado.obtenerRandom(3);
		}
		else{
			opcion=Teclado.obtenerRandom(2);
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
	
	private Boolean verificarEnvido(Jugada jugada,Integer numeroDeTurno,Integer ronda){
		if(jugada.getEnvido()==false && ronda==0){
			switch(jugada.getJugadores().size()){
				case 2:
					return true;
				case 4:
					if(numeroDeTurno==3 || numeroDeTurno==4)
						return true;
					else
						return false;
				case 6:
					if(numeroDeTurno==5 || numeroDeTurno==6)
						return true;
					else
						return false;
			}
		}
		return false;
	}
	
	private Boolean verificarTruco(Jugada jugada){
		if (jugada.getPuntosTruco()==1){
			return true;
		}
		else{
			if ( (jugada.getPuntosTruco()<4) && ((jugada.getQuienCantoTruco()==this.getEquipo() || (jugada.getQuienCantoTruco()==0))) ){
				return true;
			}
			else{
				return false;
			}
		}
	}
	
	public Boolean responderEnvido(){
		if(this.getEquipo()==1){
			if(Teclado.obtenerRandom(2)==0){
				System.out.println("Equipo2: Quiero!");
				return true;
			}
			else{
				System.out.println("Equipo2: No quiero..");
				return false;
			}
		}
		else{
			System.out.println("1) Quiero!! \n2) No quiero... \nIgrese su opcion:");
			if(Teclado.pedirEntrada(2)==1){
				System.out.println("Equipo1: Quiero!");
				return true;
			}
			else{
				System.out.println("Equipo1: No quiero..");
				return false;
			}
		}
	}
	
	public Jugada jugar(Jugada jugada,Integer numeroDeTurno,Integer ronda,Integer primeroDeJugada){
		Integer opciones=1,opcion=0;
		Boolean envido=false,truco=false;
		if(this.verificarTruco(jugada)){
			opciones++;
			truco=true;
		}
		if(this.verificarEnvido(jugada, numeroDeTurno, ronda)){
			opciones++;
			envido=true;
		}
		if(this.getId()==1){
			mostrarMano(false);
			System.out.println("1) Elegir carta a tirar");
			if (envido){
				System.out.println("2) Cantar Envido");
				if (truco)
					System.out.println("3) Cantar Truco \nIngrese su opcion:");
				else
					System.out.println("Ingrese su opcion:");
			}
			else{
				if(truco)
					System.out.println("2) Cantar Truco");
				System.out.println("Ingrese su opcion:");
			}
			opcion=Teclado.pedirEntrada(opciones);
		}
		else{
			if(this.getEquipo()==2){
				opcion=(Teclado.obtenerRandom(opciones)+1);
			}
			else{
				if(envido){
					System.out.println("-Jugador"+this.getId()+": Canto el tanto? \n1)Cantalo... \n2)No lo cantes \nIngrese su opcion:");
					if(Teclado.pedirEntrada(2)==1){
						System.out.println("-Jugador"+this.getId()+": ENVIDO!");
						jugada.setEnvido(true);
						if(this.responderEnvido()){
							jugada.setPuntosEnvido(2);
							jugada.setGanadorEnvido(jugada.envido(primeroDeJugada));
							this.elegirCarta();
						}
						else{
							jugada.setPuntosEnvido(1);
							jugada.setGanadorEnvido(this.getEquipo());
							this.elegirCarta();
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
		if(this.getEquipo()==2 || this.getId()==1){
			if(opcion==1)
				this.elegirCarta();
			else{
				if(opcion==2){
					if(envido){
						System.out.println("-Jugador"+this.getId()+": ENVIDO!");
						jugada.setEnvido(true);
						if(this.responderEnvido()){
							jugada.setPuntosEnvido(2);
							jugada.setGanadorEnvido(jugada.envido(primeroDeJugada));
							this.elegirCarta();
						}
						else{
							jugada.setPuntosEnvido(1);
							jugada.setGanadorEnvido(this.getEquipo());
							this.elegirCarta();
						}
					}
					else{
						this.cantarTruco(jugada,this.getEquipo());
						jugada.setQuienCantoTruco(this.getEquipo());
						jugada.setSeCantoTruco(true);
						if(this.getEquipo()==1)	
							jugada=this.responderTrucoPc(jugada);
						else
							jugada=this.responderTrucoUser(jugada);
						if(!jugada.getNoSeQuiere()){
							jugada.setEnvido(true);
							this.elegirCarta();
						}
						else{
							return jugada;
						}
					}
				}
				else{
					this.cantarTruco(jugada,this.getEquipo());
					jugada.setQuienCantoTruco(this.getEquipo());
					jugada.setSeCantoTruco(true);
					if(this.getEquipo()==1)	
						jugada=this.responderTrucoPc(jugada);
					else
						jugada=this.responderTrucoUser(jugada);
					if(!jugada.getNoSeQuiere()){
						jugada.setEnvido(true);
						this.elegirCarta();
					}
					else
						return jugada;
				}
			}
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
