package tpfinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumMap;
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
	private EnumMap<TipoOpinion, Integer> cantOpiniones;
	//private Map<TipoOpinion, Integer> cantOpiniones;
	private ArrayList<Opinion> opiniones;
	
	private EnumMap<TipoOpinion, Integer> cantidadDeOpiniones(){
		cantOpiniones = new EnumMap<>(TipoOpinion.class);
		cantOpiniones.put(TipoOpinion.VinchucaGuasayana, 0);
		cantOpiniones.put(TipoOpinion.VinchucaInfestans, 0);
		cantOpiniones.put(TipoOpinion.VinchucaSordida, 0);
		cantOpiniones.put(TipoOpinion.PhtiaChinche, 0);
		cantOpiniones.put(TipoOpinion.ChincheFoliada, 0);
		cantOpiniones.put(TipoOpinion.ImagenPocoClara, 0);
		cantOpiniones.put(TipoOpinion.Ninguna, 0);
		for (Opinion o : opiniones) {
			cantOpiniones.put(o.getTipoOpinion(), cantOpiniones.get(o.getTipoOpinion()) + 1);
		}
		return cantOpiniones;
	}
	
	//resultadoActual se inicializa con la opinion del usuario que sube la muestra
	public Muestra(Opinion opinionInicial, String fotoVinchuca, Ubicacion ubicacion, Usuario usuario) {
		this.fotoVinchuca = fotoVinchuca;
		this.ubicacion = ubicacion;
		this.usuario = usuario;
		this.estado = new EstadoMuestraBasico(this);
		this.cantOpiniones = cantidadDeOpiniones();
		this.fechaDeEnvio = LocalDate.now();
		this.opiniones = new ArrayList<>();
		agregarOpinion(opinionInicial);
	}
	
	public EnumMap<TipoOpinion, Integer> getCantOpiniones() {
		return cantOpiniones;
	}

	public void agregarOpinion(Opinion opinion) {
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

	public TipoOpinion getResultadoActual() {
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
