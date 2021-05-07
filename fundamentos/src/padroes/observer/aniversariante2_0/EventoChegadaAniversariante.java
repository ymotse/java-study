package padroes.observer.aniversariante2_0;

import java.util.Date;

public class EventoChegadaAniversariante {
	
	private final Date momento;

	public EventoChegadaAniversariante(Date momento) {
		this.momento = momento;
	}
	
	public Date getMomento() {
		return momento;
	}
	
}
