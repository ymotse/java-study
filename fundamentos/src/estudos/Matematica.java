/* 				M�TODOS COM RETORNO			 */
package estudos;
public class Matematica {
/**
 * @param um
 * @param dois
 * @return o maior dos dois numeros
 */
	// Pegar dois valores e mostrar o valor maior
		int maior(int um, int dois){
			if (um > dois){
				return um;	  }
			else{
				return dois;
		    }
	}
		
	// Fazer soma de dois valores
	double soma (double a, double b) {
		double resultSoma = a + b;
		return resultSoma;
	}
	
	

	public static void main(String[] args) {

		Matematica m = new Matematica(); //criando uma instancia de um objeto
			int ma = m.maior(10,20);
			System.out.println("O maior numero eh o "+ ma);
	
			double so = m.soma(3,4);
			System.out.println("O resultado da soma eh "+so);
	
			int impar = m.maior(3, 5);
			int par = m.maior(2,4);
			double resultParImpar = m.soma(impar, par);
			System.out.println("A soma entra o maior impar e maior par eh "+resultParImpar);
}
	}
