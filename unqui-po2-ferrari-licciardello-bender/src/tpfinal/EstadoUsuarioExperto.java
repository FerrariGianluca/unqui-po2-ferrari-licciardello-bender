package tpfinal;

public class EstadoUsuarioExperto extends EstadoUsuario{
	public EstadoUsuarioExperto(Usuario usuario) {
		super(usuario);
	}
	public void manejarOpinion(Muestra muestra, Opinion opinion) {
		muestra.opinionExperto(opinion);
	}
}
