package estudos;

public class AutoBoxing {

	public static void main(String[] args) {

		
		// Ate o JAVA 4:
		Integer x = new Integer(555); //empacotado
		int a = x.intValue(); //desempacotar
		a++; //incrementa
		x = new Integer(a); //reempacotando
		System.out.println(x.intValue());
				
		
		//A partir do JAVA 5:
		Integer x2 = 555;
		x2++; //desempacotando, imcrementando, reempacotando;
		System.out.println(x2);

	}

}
