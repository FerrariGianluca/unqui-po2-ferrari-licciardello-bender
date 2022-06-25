package tpfinal;

public class Organizacion {
	private Ubicacion ubicacion;
	private int trabajadores;
	private FuncionalidadExterna funMuestraValidada;
	private FuncionalidadExterna funMuestraCargada;
	
	public Organizacion(Ubicacion ubi, int cantTrab) {
		ubicacion = ubi;
		trabajadores = cantTrab;
	}
	
	public enum TipoDeOrganizacion{
		Salud, Educativa, Cultural, Asistencia
	}
	
	public void updateNuevaMuestra(ZonaDeCobertura z) {
		funMuestraCargada.nuevoEvento(this);
	}
	
	public void updateMuestraValidada(ZonaDeCobertura z) {
		funMuestraValidada.nuevoEvento(this);
	}
}
