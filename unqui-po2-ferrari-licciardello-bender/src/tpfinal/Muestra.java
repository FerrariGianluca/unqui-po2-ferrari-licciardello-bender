package tpfinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Muestra {

	private String especie;
	private Opinion resultadoActual;
	private String fotoVinchuca;
	private Ubicacion ubicacion;
	private Usuario usuario;
	private EstadoMuestra estado;
	private EstadoMuestra inicial;
	private EstadoMuestra experto;
	private EstadoMuestra cerrado;
	private ArrayList<Opinion> opiniones;
	private Opinion opinionExperto;
	private boolean opinoExperto;
	private LocalDate fechaDeEnvio;
	
	//resultadoActual se inicializa con la opinion del usuario que sube la muestra
	public Muestra(Opinion resultadoActual, String fotoVinchuca, Ubicacion ubicacion, Usuario usuario) {
		this.resultadoActual = resultadoActual;
		this.fotoVinchuca = fotoVinchuca;
		this.ubicacion = ubicacion;
		this.usuario = usuario;
		this.estado = new EstadoMuestraBasico(this);
		this.experto = new EstadoMuestraExperto(this);
		this.cerrado = new EstadoMuestraExperto(this);
		this.inicial = new EstadoMuestraBasico(this);
		this.opiniones = new ArrayList<Opinion>();
	}
	
	public void agregarOpinion(Opinion opinion) {
		getOpiniones().add(opinion);
	}
	
	public EstadoMuestra getInicial() {
		return inicial;
	}

	public void setInicial(EstadoMuestra inicial) {
		this.inicial = inicial;
	}

	public EstadoMuestra getExperto() {
		return experto;
	}

	public void setExperto(EstadoMuestra experto) {
		this.experto = experto;
	}

	public EstadoMuestra getCerrado() {
		return cerrado;
	}

	public Opinion getOpinionExperto() {
		return opinionExperto;
	}

	public void setOpinionExperto(Opinion opinionExperto) {
		this.opinionExperto = opinionExperto;
	}

	public boolean isOpinoExperto() {
		return opinoExperto;
	}

	public void setOpinoExperto(boolean opinoExperto) {
		this.opinoExperto = opinoExperto;
	}

	public void setCerrado(EstadoMuestra cerrado) {
		this.cerrado = cerrado;
	}

	public ArrayList<Opinion> getOpiniones() {
		return opiniones;
	}

	public void setOpiniones(ArrayList<Opinion> opiniones) {
		this.opiniones = opiniones;
	}

	public void opinionExperto(Opinion opinion){
		setEstado(experto);
		estado.manejarOpinion(opinion);
	}
	
	public void opinionBasico(Opinion opinion) {
		setEstado(inicial);
		estado.manejarOpinion(opinion);
	}
	
	public boolean tieneAlgunaMuestraAMenosDe(List<Muestra> muestras, double distancia) {
		return muestras.stream().anyMatch(m -> this.getUbicacion().distanciaCon(m.getUbicacion()) >= distancia);
	}
	
	public EstadoMuestra getEstado() {
		return estado;
	}

	public void setEstado(EstadoMuestra estado) {
		this.estado = estado;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Opinion getResultadoActual() {
		return resultadoActual;
	}

	public void setResultadoActual(Opinion resultadoActual) {
		this.resultadoActual = resultadoActual;
	}

	public String getFotoVinchuca() {
		return fotoVinchuca;
	}

	public void setFotoVinchuca(String fotoVinchuca) {
		this.fotoVinchuca = fotoVinchuca;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDate getFechaDeEnvio() {
		return fechaDeEnvio;
	}

	public void setFechaDeEnvio(LocalDate fechaDeEnvio) {
		this.fechaDeEnvio = fechaDeEnvio;
	}
	
	
}
