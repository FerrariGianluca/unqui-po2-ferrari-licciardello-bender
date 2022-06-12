package tpfinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProposicionSimple extends Filtro{
	private List<Muestra> muestras;
	private Condicion condicion;
	
	public ProposicionSimple(Condicion condicion, AppVinchuca app) {
		super(condicion, app);
		this.muestras = new ArrayList<>();
	    this.condicion = condicion;
	     
	}
	
	public void add(Filtro f) {
	}
	public void remove(Filtro f) {
		
	}
	public List<Muestra> muestrasQueCumplen(){
		return muestras.stream().filter(m -> condicion.cumpleCon(m)).collect(Collectors.toList());
	}

	public Condicion getCondicion() {
		return condicion;
	}

	public void setCondicion(Condicion condicion) {
		this.condicion = condicion;
	}
	
	
	
}
