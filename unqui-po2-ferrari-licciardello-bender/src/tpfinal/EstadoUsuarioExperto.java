package tpfinal;

public class EstadoUsuarioExperto extends EstadoUsuario{
	
	public void manejarOpinion(Muestra muestra, Opinion opinion) {
		muestra.agregarOpinion(opinion);
		muestra.opinionExperto(opinion);
	}
}
