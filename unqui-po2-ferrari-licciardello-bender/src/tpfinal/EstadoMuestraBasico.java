package tpfinal;

public class EstadoMuestraBasico extends EstadoMuestra{

	public EstadoMuestraBasico(Muestra muestra) {
		super(muestra);
	}
	
	public void manejarOpinion(Opinion opinion) {
		getMuestra().agregarOpinion(opinion);
	}
}
