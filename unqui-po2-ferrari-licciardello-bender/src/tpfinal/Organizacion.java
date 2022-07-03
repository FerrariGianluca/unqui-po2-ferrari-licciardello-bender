package tpfinal;

public class Organizacion implements Observador{
	private Ubicacion ubicacion;
	private int trabajadores;
	private TipoDeOrganizacion tipo;
	private FuncionalidadExterna funMuestraValidada;
	private FuncionalidadExterna funMuestraCargada;
	
	public Organizacion(Ubicacion ubi, int cantTrab, TipoDeOrganizacion tipo){
		ubicacion = ubi;
		trabajadores = cantTrab;
		this.tipo = tipo;
	}
	
	public enum TipoDeOrganizacion{
		Salud, Educativa, Cultural, Asistencia
	}
	
	public void updateNuevaMuestra(ZonaDeCobertura z, Muestra m) {
		funMuestraCargada.nuevoEvento(this, z, m);
	}
	
	public void updateMuestraValidada(ZonaDeCobertura z, Muestra m) {
		funMuestraValidada.nuevoEvento(this, z, m);
	}
	
	public void setFunMuestraValidada(FuncionalidadExterna f){
		funMuestraValidada = f;
	}
	
	public void setFunNuevaMuestra(FuncionalidadExterna f){
		funMuestraCargada = f;
	}
}
