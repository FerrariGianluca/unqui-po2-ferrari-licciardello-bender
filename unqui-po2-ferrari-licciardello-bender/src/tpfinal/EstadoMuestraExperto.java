package tpfinal;

import java.util.ArrayList;
import java.util.EnumMap;

public class EstadoMuestraExperto extends EstadoMuestra{
	
	private int cantOpiniones = 0;
	private EnumMap<TipoOpinion, Integer> cantOpExperto;
	private ArrayList<Opinion> opinionesExperto;
	
	private EnumMap<TipoOpinion, Integer> cantidadDeOpiniones(){
		cantOpExperto = new EnumMap<>(TipoOpinion.class);
		cantOpExperto.put(TipoOpinion.VinchucaGuasayana, 0);
		cantOpExperto.put(TipoOpinion.VinchucaInfestans, 0);
		cantOpExperto.put(TipoOpinion.VinchucaSordida, 0);
		cantOpExperto.put(TipoOpinion.PhtiaChinche, 0);
		cantOpExperto.put(TipoOpinion.ChincheFoliada, 0);
		cantOpExperto.put(TipoOpinion.ImagenPocoClara, 0);
		cantOpExperto.put(TipoOpinion.Ninguna, 0);
		for (Opinion o : opinionesExperto) {
			cantOpExperto.put(o.getTipoOpinion(), cantOpExperto.get(o.getTipoOpinion()) + 1);
		}
		return cantOpExperto;
	}
	
	public EstadoMuestraExperto(Muestra muestra) {
		super(muestra);
		this.opinionesExperto = new ArrayList<>();
		this.cantOpExperto = cantidadDeOpiniones();
	}
	
	public void manejarOpinion(Opinion opinion) {
		if (cantOpExperto.get(opinion.getTipoOpinion()) > 0) {
			getMuestra().setEstado(new EstadoMuestraCerrado(getMuestra(), opinion.getTipoOpinion()));
		} else {
			cantOpExperto.put(opinion.getTipoOpinion(), cantOpExperto.get(opinion.getTipoOpinion()) + 1);
			cantOpiniones += 1;
		}
		opinionesExperto.add(opinion);
		getMuestra().agregarOpinion(opinion);
	}
	
	public TipoOpinion obtenerResultadoActual() {
		if (cantOpiniones == 1) {
			return opinionesExperto.get(cantOpiniones - 1).getTipoOpinion();
		} else {
			return TipoOpinion.NoDefinido;
		}
	}
}
