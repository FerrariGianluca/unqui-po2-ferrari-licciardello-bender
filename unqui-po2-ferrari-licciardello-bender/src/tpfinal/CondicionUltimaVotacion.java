package tpfinal;

import java.time.LocalDate;

public class CondicionUltimaVotacion extends Condicion{
	
	private LocalDate fecha;
	
	public CondicionUltimaVotacion(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public boolean cumpleCon(Muestra muestra) {
		return muestra.getOpiniones().get(muestra.getOpiniones().size()).getFechaDeOpinion().isAfter(fecha);
	}
	
}
