package tpfinal;

import java.time.LocalDate;

public class CondicionUltimaVotacion implements Filtro{
	
	private LocalDate fecha;
	private Muestra muestra;
	
	public CondicionUltimaVotacion(LocalDate fecha, Muestra muestra) {
		this.fecha = fecha;
		this.muestra = muestra;
	}
	
	public boolean cumpleCon(Muestra muestra) {
		return this.muestra.getOpiniones().get(muestra.getOpiniones().size()).getFechaDeOpinion().isAfter(fecha);
	}
	
}
