package tpfinal;

import java.time.LocalDate;

public class CondicionFechaCreacion extends Condicion{

	private LocalDate fecha;
	
	public CondicionFechaCreacion(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public boolean cumpleCon(Muestra muestra) {
		return muestra.getFechaDeEnvio().isAfter(fecha);
	}
}
