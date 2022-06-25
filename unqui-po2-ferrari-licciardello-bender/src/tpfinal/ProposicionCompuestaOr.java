package tpfinal;

public class ProposicionCompuestaOr extends ProposicionCompuesta{
	
	public boolean cumpleCon(Muestra muestra){
		return getFiltros().stream().anyMatch(f -> f.cumpleCon(muestra));
	}
}
