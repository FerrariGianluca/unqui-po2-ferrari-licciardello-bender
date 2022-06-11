package tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MuestraTest {

	private Opinion opinion;
	private Ubicacion ubicacion;
	private Usuario usuario;
	private Muestra muestra;
	
	@BeforeEach
	public void setUp() {
		opinion = Opinion.VinchucaGuasayana;
		ubicacion = new Ubicacion("ubicacion", 5, 10);
		usuario = new Usuario(1);
		muestra = new Muestra(opinion, "foto", ubicacion, usuario);
	}

	@Test
	public void testMuestraBienInicializada() {
		assertEquals(muestra.getCantOpiniones().get(opinion), 1);
		assertEquals(muestra.getFotoVinchuca(), "foto");
		assertEquals(muestra.getResultadoActual(), opinion);
		assertEquals(muestra.getUbicacion(), ubicacion);
		assertEquals(muestra.getUsuario(), usuario);
	}
	
	@Test
	public void testGetters() {
		assertEquals(muestra.getCerrado().getClass(), EstadoMuestraExperto.class);
		assertEquals(muestra.getEstado().getClass(), EstadoMuestraBasico.class);
		assertEquals(muestra.getExperto().getClass(), EstadoMuestraExperto.class);
		assertEquals(muestra.getFechaDeEnvio(), LocalDate.now());
		assertEquals(muestra.getInicial().getClass(), EstadoMuestraBasico.class);
		Opinion opinionExperto = Opinion.VinchucaGuasayana;
		muestra.opinionExperto(opinionExperto);
		assertEquals(muestra.getOpinionExperto(), opinionExperto);
	}
	
	@Test
	public void cuandoSeInicializaUnaMuestraSuEstadoEsBasico() {
		EstadoMuestra estado = new EstadoMuestraBasico(muestra);
		assertEquals(muestra.getEstado().getClass(), estado.getClass());
	}
	
	@Test
	public void cuandoOpinaUnExpertoElEstadoDeLaMuestraEsExperto() {
		Opinion opinionExperto = Opinion.VinchucaGuasayana;
		muestra.opinionExperto(opinionExperto);
		EstadoMuestra estado = new EstadoMuestraExperto(muestra);
		assertEquals(muestra.getEstado().getClass(), estado.getClass());
	}
	
	@Test
	public void cuandoAlguienOpinaEstaOpinionSeAgregar() {
		muestra.agregarOpinion(opinion);
		assertEquals(muestra.getOpiniones().size(), 2);
	}
	
	@Test
	public void testMuestraAMenosDeUnaUbicacion() {
		ArrayList<Muestra> muestras = new ArrayList<>();
		Ubicacion ubicacion2 = new Ubicacion("ubicacion", 25, 40);
		Muestra muestra2 = new Muestra(opinion, "foto", ubicacion2, usuario);
		muestras.add(muestra2);
		assertFalse(muestra.tieneAlgunaMuestraAMenosDe(muestras, 5));
		muestras.add(muestra);
		assertTrue(muestra.tieneAlgunaMuestraAMenosDe(muestras, 5));
	}
	
	@Test
	public void testResultadoActual() {
		Opinion opinion2 = Opinion.ChincheFoliada;
		muestra.agregarOpinion(opinion);
		muestra.agregarOpinion(opinion2);
		assertEquals(muestra.getResultadoActual(), Opinion.NoDefinido);
	}
	
	//
}
