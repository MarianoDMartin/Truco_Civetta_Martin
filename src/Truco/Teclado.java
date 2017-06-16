package Truco;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Teclado {
	
	private static ArrayList<Integer> randoms=new ArrayList<Integer>();
	private static Integer randomActual=0;
	private static ArrayList<String> entradasTest=new ArrayList<String>();
	private static Integer entradaActual=0;
	
	private static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	public static void agregarEntrada(String valor){
		entradasTest.add(valor);
	}
	
	public static void agregarRandom(Integer valor){
		randoms.add(valor);
	}
	
	public static Integer obtenerRandom(Integer rango){
		Integer valor;
		if(randomActual<randoms.size()){
			valor=randoms.get(randomActual);
			randomActual++;
		}
		else{
			Random rand= new Random();
			return rand.nextInt(rango);
		}
		return valor;
	}
	
	public static Integer pedirEntrada(Integer opcionMaxima){
		Boolean valorCorrecto=false;
		Integer opcion=0;
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner (System.in);
		String entrada = null;
		while(!valorCorrecto){
			if(entradaActual<entradasTest.size()){
				entrada=entradasTest.get(entradaActual);
				entradaActual++;
			}
			else{
				entrada = teclado.nextLine();
			}
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
	
	public static void nuevoTeclado(){
		entradasTest=new ArrayList<String>();
		entradaActual=0;
		randomActual=0;
		randoms=new ArrayList<Integer>();
	}
	
}
