package tpfinal;

public class EstadoMuestraCerrado extends EstadoMuestra{
	
	private Opinion opinionFinal;
	
	public EstadoMuestraCerrado(Muestra muestra, Opinion opinion) {
		super(muestra);
		opinionFinal = opinion;
	}
	
	public void manejarOpinion(Opinion opinion) {
		System.out.println("Esta muestra se encuentra cerrada, no se permiten opiniones");
	}
	
	public Opinion obtenerResultadoActual() {
		return opinionFinal;
	}
	
}
