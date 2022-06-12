package tpfinal;

import java.util.List;

public abstract class Filtro{
	private Condicion condicion; 
	private AppVinchuca app;
	
	public AppVinchuca getApp() {
		return app;
	}
	
	public Filtro(Condicion condicion, AppVinchuca app) {
		this.condicion = condicion;
		this.app = app;
	}

	public void setApp(AppVinchuca app) {
		this.app = app;
	}
	public Filtro(Condicion condicion) {
		this.condicion = condicion;
	}
	public abstract void add(Filtro filtro);
	public abstract void remove(Filtro filtro);
	public abstract List<Muestra> muestrasQueCumplen();
	public Condicion getCondicion() {
		return condicion;
	}
	public void setCondicion(Condicion condicion) {
		this.condicion = condicion;
	}
	
}
