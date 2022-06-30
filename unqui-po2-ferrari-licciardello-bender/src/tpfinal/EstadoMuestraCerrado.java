package tpfinal;

public class EstadoMuestraCerrado extends EstadoMuestra{
	
	private TipoOpinion opinionFinal;
	
	public EstadoMuestraCerrado(Muestra muestra, TipoOpinion opinion) {
		super(muestra);
		opinionFinal = opinion;
	}
	
	public void manejarOpinion(Opinion opinion) {
		System.out.println("Esta muestra se encuentra cerrada, no se permiten opiniones");
	}
	
	public TipoOpinion obtenerResultadoActual() {
		return opinionFinal;
	}
	
}
