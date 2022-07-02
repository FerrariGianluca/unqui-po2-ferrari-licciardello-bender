package tpfinal;

public class EstadoUsuarioBasico implements EstadoUsuario{

	public void manejarOpinion(Muestra muestra, Opinion opinion) {
		EstadoMuestra estadoEsperado = new EstadoMuestraBasico(muestra);
		if (muestra.puedeOpinarUnUsuarioBasico()) {
			estadoEsperado.manejarOpinion(opinion);
		} else {
			System.out.println("No podes opinar sobre una muestra en la que ya opinó un experto");
		}
	}
}
