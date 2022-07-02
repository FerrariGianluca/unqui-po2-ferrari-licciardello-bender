package tpfinal;

import java.util.ArrayList;

public abstract class ProposicionCompuesta implements Filtro{

	private ArrayList<Filtro> filtros;
	
	public ProposicionCompuesta() {
		filtros = new ArrayList<Filtro>();
	}
	
	public abstract boolean cumpleCon(Muestra muestra);
	
	public void add(Filtro filtro) {
		this.filtros.add(filtro);
	}
	
	public void remove(Filtro filtro) {
		this.filtros.remove(filtro);
	}

	public ArrayList<Filtro> getFiltros() {
		return filtros;
	}
	
}
