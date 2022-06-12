package tpfinal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProposicionCompuestaOr extends ProposicionCompuesta{
	public ProposicionCompuestaOr(Condicion c, AppVinchuca app ) {
		super(c,app);
	}
	
	public List<Muestra> muestrasQueCumplen(){
		ArrayList<Muestra> muestras = new ArrayList<>(); 
		return getFiltros().stream().reduce(muestras, (Filtro  :: concatenarSiCumple())); //-> acumulado.muestrasQueCumplen().addAll(concatenarSiCumple(nuevo)));
	}
	
	public ArrayList<Muestra> concatenarSiCumple(Filtro f1){
		ArrayList<Muestra> muestras1 = new ArrayList<Muestra>();
		if(evaluarMuestras(f1, this)) {
			muestras1.addAll(f1.muestrasQueCumplen());
			muestras1.addAll(this.muestrasQueCumplen());
			return muestras1;
		}else {
			return muestras1;
		}
	}
	
	public ArrayList<Muestra> concatenarMuestrasQueCumplen(Filtro f1, Filtro f2){
		ArrayList<Muestra> muestras = new ArrayList<Muestra>();
		if(evaluarMuestras(f1, f2)) {
			muestras.addAll(f1.muestrasQueCumplen());
			muestras.addAll(f2.muestrasQueCumplen());
			return muestras;
		}else {
			return muestras;
		}
	}
	
	public boolean evaluarMuestras(Filtro f1, Filtro f2) {
		return getApp().getMuestras().stream().anyMatch(m -> f1.getCondicion().cumpleCon(m)|| f2.getCondicion().cumpleCon(m));
	}
	
}
