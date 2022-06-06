package tpfinal;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppVinchuca {

	private List<Muestra> muestras;
	private List<Usuario> usuarios;
	
	public void agregarMuestra(Muestra muestra) {
		muestras.add(muestra);
	}
	
	public void agregarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public long cantOpinionesEnLosUltimos30Dias(Usuario usuario){
		LocalDate fechaDeHoy = LocalDate.now(); 
		return usuario.getOpiniones().stream().filter(o -> ChronoUnit.DAYS.between(o.getFechaDeOpinion(), fechaDeHoy) <= 30).count();
	}
	
	public long cantMuestrasEnviadasEnLosUltimos30Dias(Usuario usuario){
		LocalDate fechaDeHoy = LocalDate.now(); 
		return usuario.getMuestrasEnviadas().stream().filter(o -> ChronoUnit.DAYS.between(o.getFechaDeEnvio(), fechaDeHoy) <= 30).count();
	}
	
	public void verificarCategoria(Usuario usuario) {
		if (cantOpinionesEnLosUltimos30Dias(usuario) >= 10 &&
			cantMuestrasEnviadasEnLosUltimos30Dias(usuario) >= 20) {
			usuario.subirCategoria();
		} else {
			usuario.bajarCategoria();
		}
	}
	
	public List<Muestra> muestrasAMenosDe(Muestra muestra, double distancia){
		return getMuestras().stream().filter(m -> m.tieneAlgunaMuestraAMenosDe(getMuestras(), distancia)).collect(Collectors.toList());
	}

	public List<Muestra> getMuestras() {
		return muestras;
	}

	public void setMuestras(List<Muestra> muestras) {
		this.muestras = muestras;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}