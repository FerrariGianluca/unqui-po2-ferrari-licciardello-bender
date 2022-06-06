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
    	return ubicaciones.stream().anyMatch(u -> this.distanciaCon(u) >= distancia);
    }
}
























// create and initialize a point with given name and
// (latitude, longitude) specified in degrees
// public Ubicacion(String name, double latitude, double longitude) {
 //   this.name = name;
  //  this.latitude  = latitude;
   // this.longitude = longitude;
// }

// return distance between this location and that location
// measured in statute miles
//public double distanceTo(Ubicacion that) {
 //   double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;
  //  double lat1 = Math.toRadians(this.latitude);
   // double lon1 = Math.toRadians(this.longitude);
  //  double lat2 = Math.toRadians(that.latitude);
  //  double lon2 = Math.toRadians(that.longitude);

    // great circle distance in radians, using law of cosines formula
   // double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)
   //                        + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

    // each degree on a great circle of Earth is 60 nautical miles
  //  double nauticalMiles = 60 * Math.toDegrees(angle);
  //  double statuteMiles = STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;
 //   return statuteMiles;
// }
