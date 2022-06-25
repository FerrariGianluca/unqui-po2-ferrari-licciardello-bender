package tpfinal;

public class EstadoMuestraBasico extends EstadoMuestra{

	public EstadoMuestraBasico(Muestra muestra) {
		super(muestra);
	}
	
	public void manejarOpinion(Opinion opinion) {
		getMuestra().agregarOpinion(opinion);
	}
	
	public Opinion obtenerResultadoActual() {
		Opinion opinion = getMuestra().getCantOpiniones().entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        return opinion;
	}
}
