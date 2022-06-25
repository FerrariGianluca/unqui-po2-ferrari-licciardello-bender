package tpfinal;

public class EstadoUsuarioBasico implements EstadoUsuario{

	public void manejarOpinion(Muestra muestra, Opinion opinion) {
		muestra.opinionBasico(opinion);
	}
}
