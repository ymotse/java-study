package estudos;

public class IfElse {
	public static void main(String[]args){
		boolean casado = true;
		int idade = 50;
		
		if(casado == true & idade < 30){
			System.out.println("Eh casado e idade menor que 30 anos.");
		} else if(casado == true & idade == 30){
			System.out.println("Eh casado e idade igual a 30 anos.");
		} else if(casado == true & idade > 30){
			System.out.println("Eh casado e idade maior que 30 anos.");
		}
		
		  else if(casado == false & idade < 30){
			System.out.println("Nao eh casado e idade menor que 30 anos.");
		} else if(casado == false & idade == 30){
			System.out.println("Nao eh casado e idade igual a 30 anos.");
		} else {
			System.out.println("Nao eh casado e idade maior que 30 anos.");
		}
	}
}
