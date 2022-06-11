package tpfinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Muestra {
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
	private Map<Opinion, Integer> cantOpiniones;
	
	//resultadoActual se inicializa con la opinion del usuario que sube la muestra
	public Muestra(Opinion opinionInicial, String fotoVinchuca, Ubicacion ubicacion, Usuario usuario) {
		this.fotoVinchuca = fotoVinchuca;
		this.ubicacion = ubicacion;
		this.usuario = usuario;
		this.estado = new EstadoMuestraBasico(this);
		this.experto = new EstadoMuestraExperto(this);
		this.cerrado = new EstadoMuestraExperto(this);
		this.inicial = new EstadoMuestraBasico(this);
		this.opiniones = new ArrayList<Opinion>();
		this.cantOpiniones = new HashMap<Opinion, Integer>();
		cantOpiniones.put(Opinion.VinchucaGuasayana, 0);
		cantOpiniones.put(Opinion.VinchucaInfestans, 0);
		cantOpiniones.put(Opinion.VinchucaSordida, 0);
		cantOpiniones.put(Opinion.PhtiaChinche, 0);
		cantOpiniones.put(Opinion.ChincheFoliada, 0);
		cantOpiniones.put(Opinion.ImagenPocoClara, 0);
		cantOpiniones.put(Opinion.Ninguna, 0);
		this.fechaDeEnvio = LocalDate.now();
		agregarOpinion(opinionInicial);
	}
	
	public Map<Opinion, Integer> getCantOpiniones() {
		return cantOpiniones;
	}

	public void agregarOpinion(Opinion opinion) {
		opiniones.add(opinion);
		cantOpiniones.put(opinion, cantOpiniones.get(opinion) + 1);
	}
	
	public void setResultadoActual(Opinion resultadoActual) {
		this.resultadoActual = resultadoActual;
	}

	public EstadoMuestra getInicial() {
		return inicial;
	}

	

	public EstadoMuestra getExperto() {
		return experto;
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



	public ArrayList<Opinion> getOpiniones() {
		return opiniones;
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
		return muestras.stream().anyMatch(m -> this.getUbicacion().distanciaCon(m.getUbicacion()) <= distancia);
	}
	
	public EstadoMuestra getEstado() {
		return estado;
	}

	public void setEstado(EstadoMuestra estado) {
		this.estado = estado;
	}

	public Opinion getResultadoActual() {		
		Opinion opinion = cantOpiniones.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
		return opinion;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public LocalDate getFechaDeEnvio() {
		return fechaDeEnvio;
	}	
	
	public String getFotoVinchuca() {
		return fotoVinchuca;
	}
	//
	
}
