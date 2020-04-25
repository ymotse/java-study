package padroes.observer.aniversariante2_0;

public class AniversarioSuspresa {
	
	public static void main(String[] args) {
		
		Porteiro porteiro = new Porteiro();
		
		Namorada namorada = new Namorada();
		porteiro.registrarObservador(namorada);
		
		porteiro.registrarObservador(e -> {
			System.out.println("Suspresa via lambda!");
			System.out.println("Ocorreu em: " + e.getMomento());
		});
		porteiro.monitorar();
	}
	
}
