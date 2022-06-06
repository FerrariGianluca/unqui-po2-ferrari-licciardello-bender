package tpfinal;

public class EstadoUsuarioBasico extends EstadoUsuario{

	public void manejarOpinion(Muestra muestra, Opinion opinion) {
		muestra.agregarOpinion(opinion);
		muestra.opinionBasico(opinion);
	}
}
