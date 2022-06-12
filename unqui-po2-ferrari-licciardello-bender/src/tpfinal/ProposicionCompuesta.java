package tpfinal;

import java.util.ArrayList;
import java.util.List;

public class ProposicionCompuesta extends Filtro{

	private ArrayList<Filtro> filtros;
	
	public ProposicionCompuesta(Condicion condicion, AppVinchuca app) {
		super(condicion, app);
		filtros = new ArrayList<Filtro>();
	
	}
	
	public List<Muestra> muestrasQueCumplen(){
		
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
