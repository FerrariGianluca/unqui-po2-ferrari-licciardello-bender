package tpfinal;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ProposicionSimple implements Filtro{

	private List<Muestra> muestras;
	
	public List<Muestra> operation(LocalDate fecha){
		return muestras.stream().filter(m -> m.getFechaDeEnvio().isAfter(fecha)).collect(Collectors.toList());
	}
	
	public List<Muestra> operationOR(){
		for (Filtro f: filtros) {
			f.operationOR();
		}
	}
	
	public List<Muestra> operationAND();
	
}
