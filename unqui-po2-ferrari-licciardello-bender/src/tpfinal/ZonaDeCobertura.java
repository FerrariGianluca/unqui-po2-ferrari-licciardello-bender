package tpfinal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ZonaDeCobertura {
		
	    private Ubicacion epicentro;
		private double radio;
		private String nombre;
		private List<Muestra> muestras;
		private ArrayList<Observador> observers;
		
		public ZonaDeCobertura(Ubicacion e, double r, String n) {
			epicentro = e;
			radio = r;
			nombre = n;
			muestras = new ArrayList<Muestra>();
			observers = new ArrayList<Observador>();
		}

		public Ubicacion getEpicentro() {
			return epicentro;
		}

		public double getRadio() {
			return radio;
		}

		public String getNombre() {
			return nombre;
		}

		public List<Muestra> getMuestras() {
			return muestras;
		}

		public List<ZonaDeCobertura> zonasQueSolapan(ArrayList<ZonaDeCobertura> zonas){
			return zonas.stream().filter(z -> z.solapaConUnaZona(this)).collect(Collectors.toList());
		}
		
		public boolean solapaConUnaZona(ZonaDeCobertura z) {
			return this.epicentro.distanciaCon(z.getEpicentro()) <= this.radio + z.getRadio();
		}
		
		public ArrayList<Observador> getObservers(){
			return observers;
		}
		
		public void agregarObserver(Observador observer) {
			observers.add(observer);
		}
		
		public void sacarObserver(Observador observer) {
			observers.remove(observer);
		}
		
		public void notifyNuevaMuestra() {
			this.observers.forEach(o -> o.updateNuevaMuestra(this));
		}
		
		public void notifyMuestraValidada() {
			this.observers.forEach(o -> o.updateMuestraValidada(this));
		}
		
		public void update(Muestra muestra){
			if (muestra.getUbicacion().distanciaCon(epicentro) <= radio) {
				muestras.add(muestra);
			}
		}
}