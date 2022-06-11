package tpfinal;

public class EstadoUsuarioBasico extends EstadoUsuario{
	public EstadoUsuarioBasico(Usuario usuario) {
		super(usuario);
	}
	public void manejarOpinion(Muestra muestra, Opinion opinion) {
		muestra.opinionBasico(opinion);
	}
}
