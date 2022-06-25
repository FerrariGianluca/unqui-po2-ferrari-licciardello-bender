package tpfinal;

public class EstadoMuestraExperto extends EstadoMuestra{
	
	private int cantOpiniones = 0;
	private Opinion opActual;
	
	public EstadoMuestraExperto(Muestra muestra) {
		super(muestra);
	}
	
	public void manejarOpinion(Opinion opinion) {
		if (cantOpiniones == 1) {
			if (opActual != opinion) {
				getMuestra().setEstado(new EstadoMuestraCerrado(getMuestra(), Opinion.NoDefinido));
			} else {
				getMuestra().setEstado(new EstadoMuestraCerrado(getMuestra(), Opinion.NoDefinido));
			}
		} else {
			cantOpiniones += 1;
			opActual = opinion;
		}
		getMuestra().agregarOpinion(opinion);
	}
	
	public Opinion obtenerResultadoActual() {
		return opActual;
	}
	
}
