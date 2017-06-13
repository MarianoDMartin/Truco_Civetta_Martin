package Truco;

import java.util.Scanner;

public class Teclado {
	
	private static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	public static Integer pedirEntrada(Integer opcionMaxima){
		Boolean valorCorrecto=false;
		Integer opcion=0;
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner (System.in);
		String entrada = null;
		while(!valorCorrecto){
			entrada = teclado.nextLine();
			
			if(isNumeric(entrada)){
				opcion=Integer.parseInt(entrada);
				if((opcion<=opcionMaxima)&&(opcion>=1)){
					return opcion;
				}
				else{
					System.out.println("Su opcion puede ser de 1 a "+opcionMaxima.toString());
				}
			}
			else{
				System.out.println("Debe ingresar un numero valido");
			}
		}
		return opcion;
	}
	
	public static String pedirNombreArchivo(){
		Boolean valorCorrecto=false;
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner (System.in);
		String archivo = null;
		while(!valorCorrecto){
			archivo = teclado.nextLine();
			if(archivo.length()<10){
				return archivo;
			}
			else{
				System.out.println("El nombre de la partida debe tener menos de 10 letras...");
			}
		}
		return archivo;
	}
	
}
