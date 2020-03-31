package estudos;
/* BASEANDO NA EQUACAO DE PELL'S, ESTE Eh UM METODO PARA OBTER A RAIZ QUADRADA SIMPLESMENTE
   SUBTRAINDO N�MEROS IMPARES.
   
   EX.: PARA OBTER RAIZ DE 27, COME�AMOS COM A SEGUINTE SEQUENCIA:
   
   1. 27-1=26
   2. 26-3=23
   3. 23-5=18
   4. 18-7=11
   5. 11-9=2
   
   5 PASSOS FORAM TOMADOS E ISSO NOS LEVA QUE A PARTE INTEIRA DA RAIZ QUADRADA DE 27 eh 5.		*/
public class RaizQuadrada {

		int raiz(int numero){
			int raiz = 0, impar = 1;
			while (numero >=impar) {
				numero -= impar;
				impar += 2; //proximo numero impar
				++raiz;
			}
			
			return raiz;
		}
	public static void main(String[] args) {
		RaizQuadrada Obj = new RaizQuadrada();
		int raiz = Obj.raiz(27);
		System.out.println(raiz);
		
	}

}
