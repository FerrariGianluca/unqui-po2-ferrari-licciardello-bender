package tpfinal;

public class EstadoMuestraBasico extends EstadoMuestra{

	public void manejarOpinion(Opinion opinion) {
		getMuestra().agregarOpinion(opinion);
	}
}
