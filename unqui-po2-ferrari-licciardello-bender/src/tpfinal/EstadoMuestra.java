package tpfinal;

public abstract class EstadoMuestra {
	
	private Muestra muestra;
	
	public abstract void manejarOpinion(Opinion opinion);

	public EstadoMuestra(Muestra muestra) {
		this.muestra = muestra;
	}
	
	public Muestra getMuestra() {
		return muestra;
	}

//	public void setMuestra(Muestra muestra) {
//		this.muestra = muestra;
//	}	
	
}
