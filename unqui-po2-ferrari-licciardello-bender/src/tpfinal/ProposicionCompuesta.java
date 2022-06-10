package tpfinal;

import java.util.ArrayList;

public class ProposicionCompuesta {

	private ArrayList<Filtro> filtros;
	
	public ProposicionCompuesta() {
		filtros = new ArrayList<Filtro>();
	}
	
	public void add(Filtro filtro) {
		filtros.add(filtro);
	}
	
	public void remove(Filtro filtro) {
		filtros.remove(filtro);
	}

	public ArrayList<Filtro> getFiltros() {
		return filtros;
	}

	public void setFiltros(ArrayList<Filtro> filtros) {
		this.filtros = filtros;
	}
	
}
