package Truco;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Archivos {

	public static Juego abrirJuegoGuardado() {
		File carpeta = new File("data");
		if (carpeta.exists() && carpeta.isDirectory()) {
			System.out.println("Ingrese el nombre de la partida:");
			
			File archivo = new File("data//"+Teclado.pedirNombreArchivo());
			if(archivo.isFile() && archivo.exists()){
				System.out.println("Cargando partida....");
				try{
					ObjectInputStream entrada=new ObjectInputStream(new FileInputStream(archivo));
					Juego juego=(Juego) entrada.readObject();
					return juego;
				}catch(Exception e){
					return null;
				}
			}
			else{
				System.out.println("Partida inexistente");
			}
		}
		else{
			carpeta.mkdir();
			System.out.println("No tiene partidas guardadas");
		}
		return null;
	}
	
	public static void guardarJuego(Juego juego) {
		File carpeta = new File("data");
		ObjectOutputStream salida;
		if (!carpeta.exists() || !carpeta.isDirectory()) {
			carpeta.mkdir();
		}
		System.out.println("Ingrese el nombre con el que desea guardar su partida:");
		try{
			salida=new ObjectOutputStream(new FileOutputStream("data//"+Teclado.pedirNombreArchivo()));
			salida.writeObject(juego);
			salida.close();
			System.out.println("Partida Guardada!");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}