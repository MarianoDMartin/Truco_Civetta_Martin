package Truco;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Naipe n1=new Naipe(Naipe.Palos.Espada,1);
		Naipe n2=new Naipe(Naipe.Palos.Oro,1);
		if(n1.mayorA(n2)==1){
			System.out.println("Mayor");
		}
		else{
			if(n1.mayorA(n2)==2){
				System.out.println("Parda");
			}
			else{
				System.out.println("Menor");
			}
		}
	}

}
