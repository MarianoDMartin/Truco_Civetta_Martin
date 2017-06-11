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
	
}
