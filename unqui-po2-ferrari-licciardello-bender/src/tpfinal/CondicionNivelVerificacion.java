package tpfinal;

public class CondicionNivelVerificacion implements Filtro{

	
	private EstadoMuestra estado;
	private Muestra muestra;
	
	public CondicionNivelVerificacion(EstadoMuestra estado, Muestra muestra) {
		this.estado = estado;
		this.muestra = muestra;
	}
	
	public boolean cumpleCon(Muestra muestra) {
		return this.muestra.getEstado().getClass() == estado.getClass();
	}
}
