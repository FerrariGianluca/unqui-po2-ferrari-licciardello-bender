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
	void CuandoUnUsuarioBasicoOpinaEnUnaMuestraBasicaSuOpinionCuenta() {
		Usuario usuario1 = new Usuario() ;
		Ubicacion ubicacion = new Ubicacion("Lanus", 3,5);
		Opinion op = new Opinion(TipoOpinion.ChincheFoliada);
		Muestra muestra = new Muestra(op, "Foto", ubicacion, usuario1);
		usuario.opinar(muestra, op);
		assertEquals(muestra.getResultadoActual(), TipoOpinion.ChincheFoliada);
		assertEquals(muestra.getCantOpiniones().get(TipoOpinion.ChincheFoliada), 2);
		assertEquals(usuario.getOpiniones().size(), 1);
	}
	
	/*@Test
	void CuandoUnUsuarioExpertoOpinaEnUnaMuestraBasicaEstaCambiaDeEstado() {
		Usuario usuario1 = new Usuario();
		Usuario usuario2 = new Usuario();
		Usuario usuario3 = new Usuario();
		usuario3.subirCategoria();
		Ubicacion ubicacion = new Ubicacion("Lanus", 3,5);
		Opinion op1 = new Opinion(TipoOpinion.ChincheFoliada);
		Opinion op2 = new Opinion(TipoOpinion.PhtiaChinche);
		Muestra muestra = new Muestra(op1, "Foto", ubicacion, usuario);
		EstadoMuestra estadoEsperado = new EstadoMuestraExperto(muestra);
		usuario1.opinar(muestra, op1);
		usuario2.opinar(muestra, op1);
		usuario3.opinar(muestra, op2);
		assertEquals(muestra.getResultadoActual(), TipoOpinion.PhtiaChinche);
		assertEquals(muestra.getEstado().getClass(), estadoEsperado);
	}*/
	
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
