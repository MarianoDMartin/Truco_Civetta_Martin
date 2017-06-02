package Truco;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Naipe n1=new Naipe(Naipe.Palos.Basto,3);
//		Naipe n2=new Naipe(Naipe.Palos.Espada,3);
//		if(n1.mayorA(n2)==1){
//			System.out.println("Mayor");
//		}
//		else{
//			if(n1.mayorA(n2)==2){
//				System.out.println("Parda");
//			}
//			else{
//				System.out.println("Menor");
//			}
//		}
		Jugada j=new Jugada(6);
		System.out.println(j.JugadaTerminada());
		j.setRonda1(0);
		j.setRonda2(1);
		System.out.println(j.JugadaTerminada());
		j.setRonda1(0);
		j.setRonda2(0);
		j.setRonda3(0);
		System.out.println(j.JugadaTerminada());
		j.setRonda1(0);
		j.setRonda2(0);
		j.setRonda3(1);
		System.out.println(j.JugadaTerminada());
		j.setRonda1(1);
		j.setRonda2(2);
		j.setRonda3(1);
		System.out.println(j.JugadaTerminada());
		j.setRonda1(0);
		j.setRonda2(0);
		j.setRonda3(-1);
		System.out.println(j.JugadaTerminada());
		j.setRonda1(2);
		j.setRonda2(2);
		j.setRonda3(-1);
		System.out.println(j.JugadaTerminada());
	}

}
