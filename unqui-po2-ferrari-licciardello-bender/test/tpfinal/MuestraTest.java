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
	public void setUp() throws Exception{
		opinion = new Opinion(TipoOpinion.ChincheFoliada);
		ubicacion = new Ubicacion("ubicacion", 5, 10);
		usuario = new Usuario();
		muestra = new Muestra(opinion, "foto", ubicacion, usuario);
	}
	
	@Test
	public void testMuestraBienInicializada() {
		assertEquals(muestra.getCantOpiniones().get(opinion.getTipoOpinion()), 1);
		assertEquals(muestra.getCantOpiniones().get(TipoOpinion.PhtiaChinche), 0);
		assertEquals(muestra.getFotoVinchuca(), "foto");
		assertEquals(muestra.getResultadoActual(), opinion.getTipoOpinion());
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
		Opinion opinionExperto = new Opinion(TipoOpinion.VinchucaGuasayana);
		muestra.opinionExperto(opinionExperto);
		EstadoMuestra estado = new EstadoMuestraExperto(muestra);
		assertEquals(muestra.getEstado().getClass(), estado.getClass());
	}
	
	@Test
	public void cuandoAlguienOpinaEstaOpinionSeAgrega() {
		muestra.agregarOpinion(opinion);
		assertEquals(muestra.getCantOpiniones(), 2);
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
		muestra.agregarOpinion(opinion);
		assertEquals(muestra.getResultadoActual(), TipoOpinion.NoDefinido);
	}
	
	
}
