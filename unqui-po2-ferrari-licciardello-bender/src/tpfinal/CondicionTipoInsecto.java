package tpfinal;

public class CondicionTipoInsecto implements Filtro{

	private Opinion tipo;
	private Muestra muestra;
	
	public CondicionTipoInsecto(Opinion tipo, Muestra muestra) {
		this.tipo = tipo;
		this.muestra = muestra;
	}
	
	public boolean cumpleCon(Muestra muestra) {
		return this.muestra.getResultadoActual().toString().equals(tipo.toString());
	}
	
}
