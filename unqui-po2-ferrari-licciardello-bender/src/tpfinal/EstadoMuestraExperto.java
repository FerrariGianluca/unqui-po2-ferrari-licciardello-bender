package tpfinal;

public class EstadoMuestraExperto extends EstadoMuestra{
	
	public void manejarOpinion(Opinion opinion) {
		if (getMuestra().isOpinoExperto()) {
			if (getMuestra().getOpinionExperto() != opinion) {
				getMuestra().setResultadoActual(null);
			} else {
				getMuestra().setEstado(getMuestra().getCerrado());
			}
		} else {
			getMuestra().setOpinoExperto(true);
			getMuestra().setOpinionExperto(opinion);
		}
		getMuestra().agregarOpinion(opinion);
	}
}
