/*DESAFIO: Fibonacci
 * Comeca-se a serie com 0 (zero) e 1 (um)
 * Obtem-se o proximo numero de Finobacci
 * somando-se os dois anteriores e, assim,
 * sucessiva e infinitamente.
 * 
 * Ex: 1+2[3]	2+3[5]	3+5[8]	5+8[13] . . .
 * 
 * 0, 1, 1, 2, 3, 5, 8, 13, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, . . .
 */

package estudos;

public class Desafio_Fibonacci { //Classe do tipo Publica
public static void main (String[]args){
	
	int anterior = 0;
	int proximo = 1;
		
	System.out.println(anterior);
	
	while (proximo < 100){
	System.out.println(proximo);

proximo = proximo + anterior;  //proximo numero Fibonacci
anterior = proximo - anterior;  //atualizando o numero anterior (soma - anterior)

		}
	}
}