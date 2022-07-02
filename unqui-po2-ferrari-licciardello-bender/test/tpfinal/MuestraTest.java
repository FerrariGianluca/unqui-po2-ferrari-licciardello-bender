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
	public void testMuestraBienInicializa() {
		assertEquals(muestra.getCantOpiniones().get(opinion.getTipoOpinion()), 1);
		assertEquals(muestra.getCantOpiniones().get(TipoOpinion.PhtiaChinche), 0);
		assertEquals(muestra.getFotoVinchuca(), "foto");
		assertEquals(muestra.getResultadoActual(), opinion.getTipoOpinion());
		assertEquals(muestra.getUbicacion(), ubicacion);
		assertEquals(muestra.getUsuario(), usuario);
		EstadoMuestra estado = new EstadoMuestraBasico(muestra);
		assertEquals(muestra.getEstado().getClass(), estado.getClass());
	}
	
	@Test
	public void cuandoOpinaUnExpertoElEstadoDeLaMuestraEsExperto() {
		Opinion opinionExperto = new Opinion(TipoOpinion.VinchucaGuasayana);
		usuario.subirCategoria();
		Usuario usuario2 = new Usuario();
		usuario2.subirCategoria();
		usuario.opinar(muestra, opinionExperto);
		assertEquals(muestra.getResultadoActual(), opinionExperto.getTipoOpinion());
		usuario2.opinar(muestra, new Opinion(TipoOpinion.ChincheFoliada));
		EstadoMuestra estado = new EstadoMuestraExperto(muestra);
		assertEquals(muestra.getEstado().getClass(), estado.getClass());
		assertEquals(muestra.getResultadoActual(), TipoOpinion.NoDefinido);
	}
	
	@Test
	public void cuandoAlguienOpinaEstaOpinionSeAgrega() {
		usuario.opinar(muestra, opinion);
		assertEquals(muestra.getCantOpiniones().get(opinion.getTipoOpinion()), 2);
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
		assertEquals(muestra.getResultadoActual(), TipoOpinion.ChincheFoliada);
	}
	
	@Test
	public void cuandoDosExpertosCoincidenLaMuestraSeVerifica() {
		Opinion opinionExperto = new Opinion(TipoOpinion.VinchucaSordida);
		EstadoMuestra estadoEsperado = new EstadoMuestraCerrado(muestra, TipoOpinion.ChincheFoliada);
		Usuario experto1 = new Usuario();
		Usuario experto2 = new Usuario();
		Usuario basico = new Usuario();
		experto1.subirCategoria();
		experto2.subirCategoria();
		experto1.opinar(muestra, opinionExperto);
		experto2.opinar(muestra, opinionExperto);
		basico.opinar(muestra, opinion);
		assertEquals(muestra.getEstado().obtenerResultadoActual(), opinionExperto.getTipoOpinion());
		assertEquals(muestra.getEstado().getClass(), estadoEsperado.getClass());
	}
	
	@Test
	public void cuandoUnaMuestraEstaVerificadaNoSePuedeOpinar() {
		Opinion opinionExperto = new Opinion(TipoOpinion.VinchucaSordida);
		EstadoMuestra estadoEsperado = new EstadoMuestraCerrado(muestra, TipoOpinion.ChincheFoliada);
		Usuario experto1 = new Usuario();
		Usuario experto2 = new Usuario();
		Usuario experto3 = new Usuario();
		experto1.subirCategoria();
		experto2.subirCategoria();
		experto3.subirCategoria();
		experto1.opinar(muestra, opinionExperto);
		experto2.opinar(muestra, opinionExperto);
		experto3.opinar(muestra, opinionExperto);
		assertEquals(muestra.getEstado().obtenerResultadoActual(), opinionExperto.getTipoOpinion());
		assertEquals(muestra.getEstado().getClass(), estadoEsperado.getClass());
	}
	
}
