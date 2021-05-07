package estudos;
import java.util.Scanner;
public class CalculoCirculo {  //Classe do tipo Publica
public static void main(String[]args){
	System.out.println("O usuario informando o valor do Raio, o Sistema ira calcular o diametro, a circunferencia e a area de um CIRCULO");	
						// CALCULAR O DI�METRO DE UM CIRCULO:
						// DIAMETRO = 2 * RAIO;
	double raio,diametro;
	
	System.out.println("Digite o valor do Raio: ");
	@SuppressWarnings("resource")
	Scanner imprimi = new Scanner(System.in);
	raio = imprimi.nextDouble();
	
	diametro = 2 * raio;
	System.out.println("Diametro: "+diametro);
	
			// CALCULAR A CIRCUNFERENCIA DO C�RCULO: 2 * PI * r  
			// CIRCUNFERENCIA Eh DUAS VEZES O "PI" VEZES O "RAIO"
	double pi = Math.PI;
	double circunferencia = 2 * pi * raio;
	System.out.println("Circunferencia: "+circunferencia);
				
	
		// �REA DO C�RCULO: PI r^2
		// �REA DO C�RCULO � "PI" VEZES "RAIO" AO QUADRADO
	double area = pi *(raio *raio);
	System.out.println("area: "+area);
	}

}
