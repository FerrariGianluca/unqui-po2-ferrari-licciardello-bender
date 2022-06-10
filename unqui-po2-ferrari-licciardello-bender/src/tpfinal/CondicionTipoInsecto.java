package tpfinal;

public class CondicionTipoInsecto extends Condicion{

	private Opinion tipo;
	
	public CondicionTipoInsecto(Opinion tipo) {
		this.tipo = tipo;
	}
	
	public boolean cumpleCon(Muestra muestra) {
		return muestra.getResultadoActual().toString().equals(tipo.toString());
	}
	
}
