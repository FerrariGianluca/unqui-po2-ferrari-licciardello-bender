package tpfinal;

public class CondicionNivelVerificacion extends Condicion{

	
	private EstadoMuestra estado;
	
	public CondicionNivelVerificacion(EstadoMuestra estado) {
		this.estado = estado;
	}
	
	public boolean cumpleCon(Muestra muestra) {
		return muestra.getEstado().getClass() == estado.getClass();
	}
}
