package tpfinal;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ProposicionSimple implements Filtro{

	private List<Muestra> muestras;
	private Condicion condicion;
	
	public ProposicionSimple(Condicion condicion) {
		this.condicion = condicion;
	}
	
	public List<Muestra> muestrasQueCumplen(){
		return muestras.stream().filter(m -> condicion.cumpleCon(m)).collect(Collectors.toList());
	}
	
}
