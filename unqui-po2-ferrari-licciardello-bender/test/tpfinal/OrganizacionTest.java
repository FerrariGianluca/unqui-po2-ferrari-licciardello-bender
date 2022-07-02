package tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpfinal.Organizacion.TipoDeOrganizacion;

class OrganizacionTest {

	private Ubicacion ubicacion;
	private Organizacion organizacion;
	
	@BeforeEach
	public void setUp() throws Exception{
		ubicacion = new Ubicacion("ubicacion", 5, 10);
		organizacion = new Organizacion(ubicacion, 50, TipoDeOrganizacion.Cultural);
	}
	
	@Test
	public void testMuestraBienInicializa() {
		
	}

}
