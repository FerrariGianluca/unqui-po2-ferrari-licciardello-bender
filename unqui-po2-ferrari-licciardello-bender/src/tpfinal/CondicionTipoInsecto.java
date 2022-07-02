package tpfinal;

public class CondicionTipoInsecto implements Filtro{

	private TipoOpinion tipo;
	private Muestra muestra;
	
	public CondicionTipoInsecto(TipoOpinion tipo, Muestra muestra) {
		this.tipo = tipo;
		this.muestra = muestra;
	}
	
	public boolean cumpleCon(Muestra muestra) {
		return this.muestra.getResultadoActual().toString().equals(tipo.toString());
	}
	
}
