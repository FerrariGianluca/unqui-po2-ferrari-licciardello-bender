package tpfinal;

public class EstadoUsuarioExperto implements EstadoUsuario{

	public void manejarOpinion(Muestra muestra, Opinion opinion) {
		muestra.opinionExperto(opinion);
	}
}
