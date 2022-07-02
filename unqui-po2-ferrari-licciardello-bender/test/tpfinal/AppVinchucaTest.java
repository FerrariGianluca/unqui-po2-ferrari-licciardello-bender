package tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppVinchucaTest {
	
	private AppVinchuca app;
	private Usuario usuario;
	private Usuario usuario2;
	private Muestra muestra;
	private Muestra muestra2;
	private Opinion opinion;
	private Ubicacion ubicacion;
	private Opinion opinion2;
	private Muestra muestra3;
	
	@BeforeEach
	public void setUp(){
		app = new AppVinchuca();
		usuario = new Usuario();
		usuario2 = new Usuario();
		ubicacion = new Ubicacion("ubicacion", 10, 5);
		opinion = new Opinion(TipoOpinion.ChincheFoliada);
		muestra = new Muestra(opinion, "foto", ubicacion, usuario2);
		muestra2 = new Muestra(opinion, "foto", ubicacion, usuario);
		opinion2 = new Opinion(TipoOpinion.PhtiaChinche, LocalDate.of(2022, 5, 7));
		muestra3 = new Muestra(opinion, "foto", ubicacion, usuario, LocalDate.of(2022, 5, 7));
	}
	
	
	@Test
	public void appInicializada(){
		assertTrue(app.getMuestras().isEmpty());
		assertTrue(app.getUsuarios().isEmpty());
		assertTrue(app.getZonas().isEmpty());
	}
	
	@Test
	public void agregarUsuario() {
		app.agregarUsuario(usuario);
		assertEquals(app.getUsuarios().size(), 1);
	}
	
	@Test
	public void actualizacionFallidaDeCategoria1Test() {
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.enviarMuestra(muestra3);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		app.actualizarCategoria(usuario);
		assertEquals(app.cantOpinionesEnLosUltimos30Dias(usuario), 10);
		assertEquals(app.cantMuestrasEnviadasEnLosUltimos30Dias(usuario), 19);
		EstadoUsuario estadoEsperado = new EstadoUsuarioBasico();
		assertEquals(usuario.getEstado().getClass(), estadoEsperado.getClass());
	}
	
	@Test
	public void actualizacionFallidaDeCategoria2Test() {
		usuario.opinar(muestra, opinion2);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		app.actualizarCategoria(usuario);
		assertEquals(app.cantOpinionesEnLosUltimos30Dias(usuario), 9);
		assertEquals(app.cantMuestrasEnviadasEnLosUltimos30Dias(usuario), 20);
		EstadoUsuario estadoEsperado = new EstadoUsuarioBasico();
		assertEquals(usuario.getEstado().getClass(), estadoEsperado.getClass());
	}
	
	
	@Test
	public void actualizacionDeCategoriasTest() {
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.opinar(muestra, opinion);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		usuario.enviarMuestra(muestra2);
		app.actualizarCategoria(usuario);
		assertEquals(app.cantOpinionesEnLosUltimos30Dias(usuario), 10);
		assertEquals(app.cantMuestrasEnviadasEnLosUltimos30Dias(usuario), 20);
		EstadoUsuario estadoEsperado = new EstadoUsuarioExperto();
		assertEquals(usuario.getEstado().getClass(), estadoEsperado.getClass());
	}
	
	@Test
	public void muestrasAMenosDeUnaDistanciaTest() {
		List<Muestra> muestrasEsperadas = new ArrayList<>();
		assertEquals(app.muestrasAMenosDe(muestra, 10), muestrasEsperadas);
		Ubicacion ubi = new Ubicacion("ubicacion", 10, 5);
		Muestra muestra = new Muestra(opinion, "foto", ubi, usuario);
		app.agregarMuestra(muestra);
		muestrasEsperadas.add(muestra);
		assertEquals(app.muestrasAMenosDe(muestra, 10), muestrasEsperadas);
	}

	@Test
	public void agregarMuestrasAUnaZonaTest() {
		ZonaDeCobertura zona = new ZonaDeCobertura(ubicacion, 10, "nombre");
		app.agregarZona(zona);
		app.agregarMuestra(muestra);
		assertEquals(zona.getMuestras().get(0), muestra);
		Ubicacion ubicacion4 = new Ubicacion("ubicacion", 500, 555);
		Muestra muestra4 = new Muestra(opinion, "foto", ubicacion4, usuario);
		app.agregarMuestra(muestra4);
		assertEquals(zona.getMuestras().size(), 1);
	}
	
	@Test
	public void busquedaPorFiltroTest() {
		ProposicionCompuesta pco = new ProposicionCompuestaOr();
		assertEquals(app.busquedaPorFiltro(pco), app.getMuestras());
		CondicionUltimaVotacion nuevaC2 = new CondicionUltimaVotacion(LocalDate.of(2022, 7, 1), muestra);
		app.agregarMuestra(muestra);
		usuario.opinar(muestra, opinion);
		assertFalse(app.busquedaPorFiltro(nuevaC2).isEmpty());
	}
	
	@Test
	public void busquedaPorFiltroCompuestoTest() {
		ProposicionCompuesta pco = new ProposicionCompuestaOr();
		CondicionUltimaVotacion nuevaC2 = new CondicionUltimaVotacion(LocalDate.of(2022, 7, 1), muestra);
		CondicionFechaCreacion nuevaC1 = new CondicionFechaCreacion(LocalDate.now(), muestra);
		app.agregarMuestra(muestra);
		usuario.opinar(muestra, opinion);
		pco.add(nuevaC1);
		pco.add(nuevaC2);
		assertFalse(app.busquedaPorFiltro(pco).isEmpty());
	}
	
}
