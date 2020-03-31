package estudos;

import java.util.ArrayList;

public class Foreach {

	public static void main(String[] args) {
		
		
		// Primeiro exemplo:
		int[] pares = {2,4,6,8,10};
		//Leitura: percorra cada elemento par do tipo Int existente dentro de pares;
		for(int par : pares) {
			System.out.println(par);
		}

		System.out.println("\n \n");
		
		
		
		//Outro exemplo:
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++){ //esse For vai contar de 0 ate 9:
			list.add(i);
		}
		
		//Esse Foreach vai percorrer os elementos numero do tipo Int, existente dentro de list.
		for(Integer numero : list){
			System.out.println(numero);
		}
		
	}

}
