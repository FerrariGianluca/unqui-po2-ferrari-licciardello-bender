package tpfinal;

public class ProposicionCompuestaAnd extends ProposicionCompuesta{

	public boolean cumpleCon(Muestra muestra){
		return getFiltros().stream().allMatch(f -> f.cumpleCon(muestra));
	}
}
