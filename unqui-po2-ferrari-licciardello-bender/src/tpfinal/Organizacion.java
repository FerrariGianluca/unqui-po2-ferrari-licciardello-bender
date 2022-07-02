package tpfinal;

public class Organizacion {
	private Ubicacion ubicacion;
	private int trabajadores;
	private TipoDeOrganizacion tipo;
	private FuncionalidadExterna funMuestraValidada;
	private FuncionalidadExterna funMuestraCargada;
	
	public Organizacion(Ubicacion ubi, int cantTrab, TipoDeOrganizacion tipo) {
		ubicacion = ubi;
		trabajadores = cantTrab;
		this.tipo = tipo;
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
