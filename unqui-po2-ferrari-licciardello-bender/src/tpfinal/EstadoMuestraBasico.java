package tpfinal;

public class EstadoMuestraBasico extends EstadoMuestra{

	public EstadoMuestraBasico(Muestra muestra) {
		super(muestra);
	}
	
	public void manejarOpinion(Opinion opinion) {
		getMuestra().agregarOpinion(opinion);
	}
	
	public TipoOpinion obtenerResultadoActual() {
		TipoOpinion opinionMasVotada = TipoOpinion.NoDefinido;
		int cantVotos = 0;
		for (TipoOpinion t : getMuestra().getCantOpiniones().keySet()) {
			if (getMuestra().getCantOpiniones().get(t) > cantVotos) {
				opinionMasVotada = t;
				cantVotos = getMuestra().getCantOpiniones().get(t);
			} else if (getMuestra().getCantOpiniones().get(t) == cantVotos) {
				opinionMasVotada = TipoOpinion.NoDefinido;
			}
		}
		return opinionMasVotada;
	}
	
	public boolean puedeOpinarUnUsuarioBasico() {
		return true;
	}
}
