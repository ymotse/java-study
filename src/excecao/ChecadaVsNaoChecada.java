package excecao;

public class ChecadaVsNaoChecada {
	
	public static void main(String[] args) {
		
//		gerarErro1();

		try {
			gerarErro1();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			gerarErro2();
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Fim.");
	}
	
	//Excecao Nao checada ou nao verificada.
	static void gerarErro1() {
		throw new RuntimeException("Ocorreu um erro bem legal #01.");
	}
	
	//Excecao chegcada ou verificada.
	static void gerarErro2() throws Exception {
		throw new Exception("Ocorreu um erro bem legal #02.");
	}
	
}
