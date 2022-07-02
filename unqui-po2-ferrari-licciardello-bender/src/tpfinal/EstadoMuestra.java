package tpfinal;

public abstract class EstadoMuestra {
	
	private Muestra muestra;	

	public EstadoMuestra(Muestra muestra) {
		this.muestra = muestra;
	}
	
	public Muestra getMuestra() {
		return muestra;
	}
	
	public abstract void manejarOpinion(Opinion opinion);
	
	public abstract TipoOpinion obtenerResultadoActual();
	
}
