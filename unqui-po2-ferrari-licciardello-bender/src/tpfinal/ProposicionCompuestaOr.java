package tpfinal;

import java.util.List;
import java.util.stream.Collectors;

public class ProposicionCompuestaOr extends ProposicionCompuesta{
	
	public List<Muestra> muestrasQueCumplen(){
		return getFiltros().stream().filter(f -> f.muestrasQueCumplen()).collect(Collectors.toList());
	}
	
}
