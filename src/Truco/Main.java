package Truco;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Juego juego;
		System.out.println("Bienvenido a TrucoFacilito!!!");
		System.out.println("1)Nuevo Juego \n2)Abrir juego guardado \n3)Salir \nIngresa tu opcion:");
		Integer opcion=Teclado.pedirEntrada(3);
		while (opcion!=3){
			if(opcion==1){
				System.out.println("Elegí la cantidad de jugadores...");
				System.out.println("1) 2 Jugadores");
				System.out.println("2) 4 Jugadores");
				System.out.println("3) 6 Jugadores");
				System.out.println("Ingresa tu opcion:");
				Integer jugadores= Teclado.pedirEntrada(3);
				if(jugadores==1){
					jugadores=2;
				}
				else{
					if(jugadores==2){
						jugadores=4;
					}
					else{
						jugadores=6;
					}
				}
				System.out.println("Elegí el puntaje maximo");
				System.out.println("1) 15 puntos");
				System.out.println("2) 30 puntos");
				System.out.println("Ingresa tu opcion:");
				Integer puntajeMax=Teclado.pedirEntrada(2);
				if(puntajeMax==1){
					puntajeMax=15;
				}
				else{
					puntajeMax=30;
				}
				juego=new Juego(puntajeMax,jugadores);
				juego.EmpezarJuego();
			}
			else{
				if(opcion==2){
					juego= Archivos.abrirJuegoGuardado();
					if(juego != null){
						System.out.println("Juego cargado!!");
						juego.EmpezarJuego();
					}
					else{
						System.out.println("Error al cargar el juego...");
					}
					
				}
			}
			System.out.println("1)Nuevo Juego \n2)Abrir juego guardado \n3)Salir \nIngresa tu opcion:");
			opcion=Teclado.pedirEntrada(3);
		}
	}

}
