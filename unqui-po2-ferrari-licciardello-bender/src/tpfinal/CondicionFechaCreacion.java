package tpfinal;

import java.time.LocalDate;

public class CondicionFechaCreacion implements Filtro{

	private LocalDate fecha;
	private Muestra muestra;
	
	public CondicionFechaCreacion(LocalDate fecha, Muestra muestra) {
		this.fecha = fecha;
		this.muestra = muestra;
	}
	
	public boolean cumpleCon(Muestra muestra) {
		return this.muestra.getFechaDeEnvio().isAfter(fecha);
	}
}
