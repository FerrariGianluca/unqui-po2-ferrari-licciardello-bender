package tpfinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Muestra {
	private String fotoVinchuca;
	private Ubicacion ubicacion;
	private Usuario usuario;
	private EstadoMuestra estado;
	private LocalDate fechaDeEnvio;
	private Map<Opinion, Integer> cantOpiniones;
	private ArrayList<Opinion> opiniones;
	
	//resultadoActual se inicializa con la opinion del usuario que sube la muestra
	public Muestra(Opinion opinionInicial, String fotoVinchuca, Ubicacion ubicacion, Usuario usuario) {
		this.fotoVinchuca = fotoVinchuca;
		this.ubicacion = ubicacion;
		this.usuario = usuario;
		this.estado = new EstadoMuestraBasico(this);
		this.cantOpiniones = new HashMap<Opinion, Integer>();
		cantOpiniones.put(Opinion.VinchucaGuasayana, 0);
		cantOpiniones.put(Opinion.VinchucaInfestans, 0);
		cantOpiniones.put(Opinion.VinchucaSordida, 0);
		cantOpiniones.put(Opinion.PhtiaChinche, 0);
		cantOpiniones.put(Opinion.ChincheFoliada, 0);
		cantOpiniones.put(Opinion.ImagenPocoClara, 0);
		cantOpiniones.put(Opinion.Ninguna, 0);
		this.fechaDeEnvio = LocalDate.now();
		this.opiniones = new ArrayList<>();
		agregarOpinion(opinionInicial);
	}
	
	public Map<Opinion, Integer> getCantOpiniones() {
		return cantOpiniones;
	}

	public void agregarOpinion(Opinion opinion) {
		cantOpiniones.put(opinion, cantOpiniones.get(opinion) + 1);
		opiniones.add(opinion);
	}

	public void opinionExperto(Opinion opinion){
		EstadoMuestra estado = new EstadoMuestraExperto(this);
		if (estado.getClass().toString().equals(estado.toString())) {
			estado.manejarOpinion(opinion);
		} else {
			setEstado(estado);
			estado.manejarOpinion(opinion);
		}
	}
	
	public void opinionBasico(Opinion opinion) {
		EstadoMuestra estado = new EstadoMuestraBasico(this);
		if (estado.getClass().toString().equals(estado.toString())) {
			estado.manejarOpinion(opinion);
		}
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
		return estado.obtenerResultadoActual();
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

	
}
