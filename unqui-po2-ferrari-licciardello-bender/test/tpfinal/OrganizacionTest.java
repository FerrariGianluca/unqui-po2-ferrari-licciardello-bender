package tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InOrder;
import static org.mockito.Mockito.*;

import tpfinal.Organizacion.TipoDeOrganizacion;

class OrganizacionTest {

	private Ubicacion ubicacion;
	private Organizacion organizacion;
	private FuncionalidadExterna muestraValidada;
	private FuncionalidadExterna nuevaMuestra;
	private ZonaDeCobertura zona;
	private Muestra muestra;
	
	@BeforeEach
	public void setUp() throws Exception{
		ubicacion = new Ubicacion("ubicacion", 5, 10);
		organizacion = new Organizacion(ubicacion, 50, TipoDeOrganizacion.Cultural);
		muestraValidada = mock(FuncionalidadExterna.class);
		nuevaMuestra = mock(FuncionalidadExterna.class);
		zona = mock(ZonaDeCobertura.class);
		muestra = mock(Muestra.class);
	}
	
	@Test
	public void testFuncionalidades() {
		organizacion.setFunMuestraValidada(muestraValidada);
		organizacion.setFunNuevaMuestra(nuevaMuestra);
		organizacion.updateMuestraValidada(zona, muestra);
		organizacion.updateNuevaMuestra(zona, muestra);
		verify(muestraValidada, times(1)).nuevoEvento(organizacion, zona, muestra);
		verify(nuevaMuestra, times(1)).nuevoEvento(organizacion, zona, muestra);
	}

}
