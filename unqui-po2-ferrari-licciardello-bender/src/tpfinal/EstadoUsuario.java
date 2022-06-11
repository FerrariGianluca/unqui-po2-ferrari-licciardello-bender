package tpfinal;

public abstract class EstadoUsuario {
	private Usuario usuario;
	public EstadoUsuario (Usuario usuario) {
		this.usuario = usuario;
	}
	public abstract void manejarOpinion(Muestra muestra, Opinion opinion);
}
