package tpfinal;

public interface Observador {
	public void updateNuevaMuestra(ZonaDeCobertura z, Muestra m);
	public void updateMuestraValidada(ZonaDeCobertura z, Muestra m);
}
