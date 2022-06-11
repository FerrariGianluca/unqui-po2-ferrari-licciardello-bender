package tpfinal;

import java.util.ArrayList;

public class Usuario {

	private int id;
	private EstadoUsuarioBasico estadoBasico;
	private EstadoUsuarioExperto estadoExperto;
	private EstadoUsuario estado;
	private AppVinchuca aplicacion;
	private ArrayList<Opinion> opiniones;
	private ArrayList<Muestra> muestrasEnviadas; 
	
	public Usuario(int id ) {
		this.estado = new EstadoUsuarioBasico(this) ;
		this.id = id;
		this.aplicacion = new AppVinchuca();
		this.opiniones = new ArrayList<Opinion>();
		this.muestrasEnviadas = new ArrayList<Muestra>();
	}
	
	
	public void subirCategoria() {
		setEstado(new EstadoUsuarioExperto(this));
	}
	
	public void bajarCategoria() {
		setEstado(new EstadoUsuarioBasico(this));
	}
	
	public void enviarMuestra(Muestra muestra) {
		getMuestrasEnviadas().add(muestra);
		getAplicacion().agregarMuestra(muestra);
	}
	
	public void opinar(Muestra muestra, Opinion opinion) {
		estado.manejarOpinion(muestra, opinion);
		opiniones.add(opinion);
	}

	public int getId() {
		return id;
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

	

	public ArrayList<Opinion> getOpiniones() {
		return opiniones;
	}

	

	public ArrayList<Muestra> getMuestrasEnviadas() {
		return muestrasEnviadas;
	}

	
	
	
	
}
