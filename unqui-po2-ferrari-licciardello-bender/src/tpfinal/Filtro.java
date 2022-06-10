package tpfinal;

import java.util.List;

public interface Filtro{
	
	public List<Muestra> operationOR();
	public List<Muestra> operationAND();
	public void add(Filtro filtro);
	public void remove(Filtro filtro);
	public List<Muestra> muestrasQueCumplen();
}
