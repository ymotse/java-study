		// CALCULO DE MASSA CORPORAL COM "OPERADORES ESPECIAIS" E "SCANNER" (IMC)

package estudos;
import java.util.Scanner;
public class CalculoIMC {  //Classe do tipo Publica
public static void main (String[]args){
	
	double peso,altura,imc;
	
	System.out.println("Digite quantos kilos voce tem: ");
	@SuppressWarnings("resource")
	Scanner imprimi = new Scanner(System.in);
	peso = imprimi.nextDouble();
	
	System.out.println("Digite quanto de altura voce tem (em metros): ");
	altura = imprimi.nextDouble();
	
	imc = peso / (altura * altura);
	
	String msg = 
			(imc >= 20 && imc <= 25) ? "Voce esta no peso ideal" : "Voce esta fora do peso ideal";
	
	System.out.println("Seu IMC eh de "+imc);
	System.out.println(msg);
	}
}
