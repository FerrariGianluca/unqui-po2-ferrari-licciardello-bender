package tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
	
	private EstadoUsuario estado;
	private AppVinchuca aplicacion;
	private ArrayList<Opinion> opiniones;
	private ArrayList<Muestra> muestrasEnviadas; 
	private Usuario usuario;
	
	@BeforeEach
	public void setUp() {
		 usuario = new Usuario();
	}
	
	@Test
	void InicializacionTest() {
		assertEquals(usuario.getEstado().getClass(), EstadoUsuarioBasico.class);
	}
	
	@Test
	void CategoriaTest() {
		usuario.subirCategoria();
		assertEquals(usuario.getEstado().getClass(), EstadoUsuarioExperto.class);
		usuario.bajarCategoria();
		assertEquals(usuario.getEstado().getClass(), EstadoUsuarioBasico.class);

	}
	@Test
	void OpinarTest() {
		Usuario usuario1 = new Usuario() ;
		Ubicacion ubicacion = new Ubicacion("Lanus", 3,5);
		Opinion op = new Opinion(TipoOpinion.ChincheFoliada);
		Muestra muestra = new Muestra(op, "Foto", ubicacion, usuario1);
		usuario.opinar(muestra, op);
		assertEquals(muestra.getResultadoActual(), TipoOpinion.ChincheFoliada);
		assertEquals(muestra.getCantOpiniones().get(TipoOpinion.ChincheFoliada), 2);
		assertEquals(usuario.getOpiniones().size(), 1);
	}
	
	@Test
	void EnviarMuestraTest() {
		AppVinchuca app = new AppVinchuca();
		Usuario usuario1 = new Usuario();
		Ubicacion ubicacion = new Ubicacion("Lanus", 3,5);
		Opinion op = new Opinion(TipoOpinion.ChincheFoliada);
		Muestra muestra = new Muestra(op, "Foto", ubicacion,usuario1);
		app.agregarUsuario(usuario1);
		usuario1.enviarMuestra(muestra);
		assertEquals(app.cantMuestrasEnviadasEnLosUltimos30Dias(usuario1), 1);
	}
	
	
	
}
