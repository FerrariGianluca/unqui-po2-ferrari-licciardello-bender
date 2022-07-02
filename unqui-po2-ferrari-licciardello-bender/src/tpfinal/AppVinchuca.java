package tpfinal;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppVinchuca{

	private List<Muestra> muestras;
	private List<Usuario> usuarios;
	private List<ZonaDeCobertura> zonas;
	
	public AppVinchuca() {
		muestras = new ArrayList<Muestra>();
		usuarios = new ArrayList<Usuario>();
		zonas = new ArrayList<ZonaDeCobertura>();
	}
	
	public void agregarMuestra(Muestra muestra) {
		muestras.add(muestra);
		zonas.forEach(o -> o.update(muestra));
	}
	
	public void agregarZona(ZonaDeCobertura zona) {
		zonas.add(zona);
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
	
	public void actualizarCategoria(Usuario usuario) {
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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public List<ZonaDeCobertura> getZonas() {
		return this.zonas;
	}
	
	public ArrayList<Muestra> busquedaPorFiltro(Filtro filtro){
		ArrayList<Muestra> muestrasFiltradas = new ArrayList<>();
		for (Muestra m : muestras){
			if (filtro.cumpleCon(m)){
				muestrasFiltradas.add(m);
			}
		}
		return muestrasFiltradas;
	}
	
}