package estudos;


public class ExcecoesComuns {

	static int[] arrayNull;
	
	static int[] array =  new int[0];
	
	public static void main(String[] args) {
		
		//NullPointerException:
		System.out.println(arrayNull.length);
		
		//ArithmeticException:
		@SuppressWarnings("unused")
		int x = 5 / 0;
		
		//ArrayIndexOutBoundsException:
		System.out.println(array[90]);
		
		//NumberFormatException:
		@SuppressWarnings("unused")
		int i = Integer.parseInt("x");
		
	}

}
