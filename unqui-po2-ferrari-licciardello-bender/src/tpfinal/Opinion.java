package tpfinal;

import java.time.LocalDate;

public enum Opinion{
	
	VinchucaInfestans, VinchucaSordida, VinchucaGuasayana, ChincheFoliada, PhtiaChinche, Ninguna, ImagenPocoClara;
		
	private LocalDate fechaDeOpinion;
	
	public LocalDate getFechaDeOpinion() {
		return fechaDeOpinion;
	}

	public void setFechaDeOpinion(LocalDate fechaDeOpinion) {
		this.fechaDeOpinion = fechaDeOpinion;
	}
	
	
}
