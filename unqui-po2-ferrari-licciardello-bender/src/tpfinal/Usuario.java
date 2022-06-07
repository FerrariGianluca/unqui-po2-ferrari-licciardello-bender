package tpfinal;

import java.util.ArrayList;

public class Usuario {

	private int id;
	private EstadoUsuario estado;
	private AppVinchuca aplicacion;
	private ArrayList<Opinion> opiniones;
	private ArrayList<Muestra> muestrasEnviadas; 
	
	public Usuario(int id) {
		this.id = id;
	}
	
	public void subirCategoria() {
		setEstado(new EstadoUsuarioExperto());
	}
	
	public void bajarCategoria() {
		setEstado(new EstadoUsuarioBasico());
	}
	
	public void enviarMuestra(Muestra muestra) {
		getAplicacion().agregarMuestra(muestra);
	}
	
	public void opinar(Muestra muestra, Opinion opinion) {
		estado.manejarOpinion(muestra, opinion);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EstadoUsuario getEstado() {
		return estado;
	}

	public void setEstado(EstadoUsuario estado) {
		this.estado = estado;
	}

	public AppVinchuca getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(AppVinchuca aplicacion) {
		this.aplicacion = aplicacion;
	}

	public ArrayList<Opinion> getOpiniones() {
		return opiniones;
	}

	public void setOpiniones(ArrayList<Opinion> opiniones) {
		this.opiniones = opiniones;
	}

	public ArrayList<Muestra> getMuestrasEnviadas() {
		return muestrasEnviadas;
	}

	public void setMuestrasEnviadas(ArrayList<Muestra> muestrasEnviadas) {
		this.muestrasEnviadas = muestrasEnviadas;
	}
	
	
	
}
