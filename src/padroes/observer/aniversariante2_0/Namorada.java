package padroes.observer.aniversariante2_0;

public class Namorada implements ObservadorChegadaAniversariante {

	public void chegou(EventoChegadaAniversariante evento) {
		System.out.println("Avisar os convidados...");
		System.out.println("Apagar as luzes...");
		System.out.println("Esperar um pouco...");
		System.out.println("Suspresa!!!");
	}

}
