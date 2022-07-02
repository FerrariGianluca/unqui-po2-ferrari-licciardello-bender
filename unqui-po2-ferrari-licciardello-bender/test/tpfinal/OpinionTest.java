package tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpinionTest {

	private Opinion opinion; 

	@BeforeEach
	public void setUp() {
		opinion = new Opinion(TipoOpinion.ChincheFoliada);
	}
	
	@Test
	public void testMuestraBienInicializada() {
		assertEquals(opinion.getFechaDeOpinion(), LocalDate.now());
		assertEquals(opinion.getTipoOpinion(), TipoOpinion.ChincheFoliada);
	}
//
}
