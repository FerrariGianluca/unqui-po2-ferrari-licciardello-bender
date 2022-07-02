package tpfinal;

import java.time.LocalDate;

public class Opinion{
	
	private LocalDate fechaDeOpinion;
	private TipoOpinion opinion;
	
	public Opinion(TipoOpinion opinion){
		this.fechaDeOpinion = LocalDate.now();
		this.opinion = opinion;
	}
	
	public Opinion(TipoOpinion opinion, LocalDate fecha) {
		this.fechaDeOpinion = fecha;
		this.opinion = opinion;
	}
	
	public LocalDate getFechaDeOpinion() {
		return fechaDeOpinion;
	}
	
	public TipoOpinion getTipoOpinion() {
		return opinion;
	}
	
}
