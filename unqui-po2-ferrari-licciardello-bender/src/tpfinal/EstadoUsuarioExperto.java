package tpfinal;

public class EstadoUsuarioExperto implements EstadoUsuario{

	public void manejarOpinion(Muestra muestra, Opinion opinion) {
		EstadoMuestra estadoEsperado = new EstadoMuestraExperto(muestra);
		if (muestra.puedeOpinarUnUsuarioBasico()) {
			muestra.setEstado(estadoEsperado);
			muestra.getEstado().manejarOpinion(opinion);
		} else {
			muestra.getEstado().manejarOpinion(opinion);
		}
	}
	
}
