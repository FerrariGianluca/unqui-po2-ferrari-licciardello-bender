package tpfinal;

import static org.junit.jupiter.api.Assertions.*;

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
		assertEquals(muestra.getFotoVinchuca(), "foto");
		assertEquals(muestra.getResultadoActual(), opinion);
		assertEquals(muestra.getUbicacion(), ubicacion);
		assertEquals(muestra.getUsuario(), usuario);
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
}
