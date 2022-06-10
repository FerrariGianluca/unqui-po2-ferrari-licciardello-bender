package tpfinal;

import java.time.LocalDate;

public enum Opinion{
	
	VinchucaInfestans, VinchucaSordida, VinchucaGuasayana, ChincheFoliada, PhtiaChinche, Ninguna, ImagenPocoClara, NoDefinido;
		
	private LocalDate fechaDeOpinion;
	
	public LocalDate getFechaDeOpinion() {
		return fechaDeOpinion;
	}

	public void setFechaDeOpinion(LocalDate fechaDeOpinion) {
		this.fechaDeOpinion = fechaDeOpinion;
	}
	
	
}
