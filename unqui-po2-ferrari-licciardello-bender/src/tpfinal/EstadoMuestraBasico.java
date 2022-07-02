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
	
	//public TipoOpinion obtenerResultadoActual() {
	//	TipoOpinion opinion = getMuestra().getCantOpiniones().entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
    //    return opinion;
	//}
}
