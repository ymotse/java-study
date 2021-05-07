package estudos;
import java.util.Scanner;

/*		PROGRAMA CALCULAR� A M�DIA DAS NOTAS BIMESTRAIS DE UM ALUNO, E INFORMAR�:
  		SE M�DIA FOR IGUAL A 5 IR� PARA EXAME, 
  		SE M�DIA FOR MENOR QUE 5 ESTAR� REPROVADO,
		SE M�DIA FOR MAIOR QUE 5 ESTAR� APROVADO.
*/		

public class IfComScanner {
	public static void main(String[] args) {

		float n1, n2, n3, n4, media;
		
		
		System.out.println("Digite a nota do primeiro bimestre: ");
		@SuppressWarnings("resource")
		Scanner exibir = new Scanner(System.in);
		n1 = exibir.nextFloat();

		System.out.println("Digite a nota do segundo bimestre: ");
		n2 = exibir.nextFloat();
		
		System.out.println("Digite a nota do terceiro bimestre: ");
		n3 = exibir.nextFloat();
		
		System.out.println("Digite a nota do quarto bimestre: ");
		n4 = exibir.nextFloat();
		
	media = (n1 + n2 + n3 + n4) / 4;
	System.out.println("");
	System.out.println("Sua media eh "+media);
	
		if (media == 5){
			System.out.println("Voce esta de Exame!");
		}
		if (media > 5){
			System.out.println("Voce esta Aprovado!");
		}
		if(media < 5){
			System.out.println("Voce esta Reprovado!");
		}

	}

}
