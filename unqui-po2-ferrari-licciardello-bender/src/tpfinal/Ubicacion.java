package tpfinal;

import java.util.List;
import java.util.stream.Collectors;

public class Ubicacion {

	private String nombre;
    private double longitud;
    private double latitud;

    public Ubicacion(String nombre, double latitud, double longitud) {
        this.nombre = nombre;
        this.latitud  = latitud;
        this.longitud = longitud;
        
    }
    
   
    public double distanciaCon(Ubicacion ubicacion) {
    	double lat1 = Math.toRadians(this.latitud);
    	double lon1 = Math.toRadians(this.longitud);
    	double lat2 = Math.toRadians(ubicacion.latitud);
    	double lon2 = Math.toRadians(ubicacion.longitud);

    	final double RADIO_TIERRA = 6371.01;    // Kilómetros

    	double distancia = RADIO_TIERRA * Math.acos(Math.sin(lat1) * Math.sin(lat2)
    					   + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

    	return distancia;
    } 
    
    public List<Ubicacion> ubicacionesAMenosDe(List<Ubicacion> ubicaciones, double distancia){
    	return ubicaciones.stream().filter(u1 -> u1.tieneAlgunaUbicacionAMenosDe(ubicaciones, distancia)).collect(Collectors.toList());
    }
    
    public boolean tieneAlgunaUbicacionAMenosDe(List<Ubicacion> ubicaciones, double distancia) {
    	return ubicaciones.stream().anyMatch(u -> this.distanciaCon(u) <= distancia);
    }
}

