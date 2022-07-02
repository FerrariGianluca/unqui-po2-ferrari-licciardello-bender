package tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FiltroTest {
	
	private CondicionFechaCreacion cfc;
	private CondicionNivelVerificacion cnv;
	private CondicionTipoInsecto cti;
	private CondicionUltimaVotacion cuv;
	private Muestra muestra;
	private Usuario usuario;
	private Ubicacion ubicacion;
	private Opinion opinion;
	private EstadoMuestra estado;
	private ProposicionCompuesta pca;
	private ProposicionCompuesta pco;
	
	@BeforeEach
	public void setUp(){
		usuario = new Usuario();
		ubicacion = new Ubicacion("ubicacion", 10, 8);
		opinion = new Opinion(TipoOpinion.ChincheFoliada);
		muestra = new Muestra(opinion, "foto", ubicacion, usuario);
		estado = new EstadoMuestraBasico(muestra);
		cfc = new CondicionFechaCreacion(LocalDate.of(2022, 5, 7), muestra);
		cnv = new CondicionNivelVerificacion(estado, muestra);
		cti = new CondicionTipoInsecto(TipoOpinion.ChincheFoliada, muestra);
		cuv = new CondicionUltimaVotacion(LocalDate.of(2022, 5, 7), muestra);
		pca = new ProposicionCompuestaAnd();
		pco = new ProposicionCompuestaOr();
	}
	
	
	@Test
	public void condicionFechaCreacionTest(){
		assertTrue(cfc.cumpleCon(muestra));
	}

	@Test
	public void condicionNivelVerificacionTest(){
		assertTrue(cnv.cumpleCon(muestra));
		usuario.subirCategoria();
		usuario.opinar(muestra, opinion);
		assertFalse(cnv.cumpleCon(muestra));
	}
	
	@Test
	public void condicionTipoInsectoTest(){
		assertTrue(cti.cumpleCon(muestra));
	}
	
	@Test
	public void condicionUltimaVotacionTest(){
		assertTrue(cuv.cumpleCon(muestra));
	}
	
	@Test
	public void condicionCompuestaAnd() {
		pca.add(cfc);
		pca.add(cnv);
		assertTrue(pca.cumpleCon(muestra));
		CondicionUltimaVotacion nuevaCondicion = new CondicionUltimaVotacion(LocalDate.now(), muestra);
		pca.add(nuevaCondicion);
		assertFalse(pca.cumpleCon(muestra));
	}
	
	@Test
	public void condicionCompuestaOr() {
		pco.add(cfc);
		pco.add(cnv);
		assertTrue(pco.cumpleCon(muestra));
		CondicionUltimaVotacion nuevaCondicion = new CondicionUltimaVotacion(LocalDate.now(), muestra);
		pco.add(nuevaCondicion);
		assertTrue(pco.cumpleCon(muestra));
	}
	
	@Test
	public void condicionCompuestaOrFallida() {
		CondicionUltimaVotacion nuevaC2 = new CondicionUltimaVotacion(LocalDate.now(), muestra);
		pco.add(nuevaC2);
		CondicionFechaCreacion nuevaC1 = new CondicionFechaCreacion(LocalDate.now(), muestra);
		pco.add(nuevaC1);
		assertFalse(pco.cumpleCon(muestra));
	}
	
	@Test
	public void eliminarFiltroTest() {
		ProposicionCompuestaAnd pca = new ProposicionCompuestaAnd();
		pca.add(cfc);
		pca.add(cnv);
		pca.remove(cfc);
		assertEquals(pca.getFiltros().size(), 1);
	}
}
