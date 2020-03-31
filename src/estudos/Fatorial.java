package estudos;

public class Fatorial {

	public static void main(String[] args) {
		
		
	       int numero;
	       int resposta = 1;
	       
	      System.out.println("Digite um numero inteiro: ");
	       numero = 7; //Numero digitado.
	       
	       int digitado = numero;
	       
	       
	           for ( ; numero >= 1 ; -- numero ){
	           
	           resposta *= numero;    
	           //mesma coisa que Resposta = Resposta * numero;
	           } 
	           
	           System.out.println("O fatorial de " + digitado + " eh: " + resposta);
	}

}
