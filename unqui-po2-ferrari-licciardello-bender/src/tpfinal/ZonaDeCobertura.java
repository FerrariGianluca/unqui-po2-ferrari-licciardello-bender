package tpfinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.stream.Collectors;

public class ZonaDeCobertura  {
		
		private AppVinchuca app;
	    private Ubicacion epicentro;
		private double radio;
		private String nombre;
		private List<Muestra> muestras;
		private List<Observador> observers;
		
		public ZonaDeCobertura(Ubicacion e, double r, String n) {
			epicentro = e;
			radio = r;
			nombre = n;
			muestras = new ArrayList<Muestra>();
		}

		public Ubicacion getEpicentro() {
			return epicentro;
		}

		public void setEpicentro(Ubicacion epicentro) {
			this.epicentro = epicentro;
		}

		public double getRadio() {
			return radio;
		}

		public void setRadio(double radio) {
			this.radio = radio;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public List<Muestra> getMuestras() {
			return muestras;
		}

		public void setMuestras(List<Muestra> muestras) {
			this.muestras = muestras;
		}
		
		public List<ZonaDeCobertura> zonasQueSolapan(){
			return this.app.getZonas().stream().filter(z -> z.solapaConUnaZona(this)).collect(Collectors.toList());
		}
		
		public boolean solapaConUnaZona(ZonaDeCobertura z) {
			return this.epicentro.distanciaCon(z.getEpicentro()) <= this.radio + z.getRadio();
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
}
