package tpfinal;

import java.util.HashMap;
import java.util.Map;

public class EstadoMuestraExperto extends EstadoMuestra{
	
	private int cantOpiniones = 0;
	private TipoOpinion opActual;
	private Map<TipoOpinion, Integer> opinionesExperto;
	
	public EstadoMuestraExperto(Muestra muestra) {
		super(muestra);
		this.opinionesExperto = new HashMap<TipoOpinion, Integer>();
		opinionesExperto.put(TipoOpinion.VinchucaGuasayana, 0);
		opinionesExperto.put(TipoOpinion.VinchucaInfestans, 0);
		opinionesExperto.put(TipoOpinion.VinchucaSordida, 0);
		opinionesExperto.put(TipoOpinion.PhtiaChinche, 0);
		opinionesExperto.put(TipoOpinion.ChincheFoliada, 0);
		opinionesExperto.put(TipoOpinion.ImagenPocoClara, 0);
		opinionesExperto.put(TipoOpinion.Ninguna, 0);
	}
	
	public void manejarOpinion(Opinion opinion) {
		if (opinionesExperto.get(opinion.getTipoOpinion()) == 1) {
			getMuestra().setEstado(new EstadoMuestraCerrado(getMuestra(), opinion.getTipoOpinion()));
		} else {
			opinionesExperto.putIfAbsent(opActual, opinionesExperto.get(opinion.getTipoOpinion()) + 1);
			cantOpiniones += 1;
			opActual = opinion.getTipoOpinion();
		}
		getMuestra().agregarOpinion(opinion);
	}
	
	public TipoOpinion obtenerResultadoActual() {
		if (cantOpiniones == 0) {
			return opActual;
		} else {
			return TipoOpinion.NoDefinido;
		}
	}
}
