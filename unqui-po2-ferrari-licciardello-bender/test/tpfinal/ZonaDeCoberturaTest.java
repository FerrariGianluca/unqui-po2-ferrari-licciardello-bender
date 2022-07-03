package tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import static org.mockito.Mockito.*;
import tpfinal.Organizacion.TipoDeOrganizacion;

class ZonaDeCoberturaTest {

	private Ubicacion epicentro;
	private double radio;
	private String nombre;
	private ZonaDeCobertura zona1;
	private ZonaDeCobertura zona2;
	private Observador org1;
	private Observador org2;
	private Muestra muestra;
	
	@BeforeEach
	public void setUp() throws Exception{
		epicentro = new Ubicacion("ubicacion", 5, 10);
		radio = 10;
		nombre = "epicentro";
		zona1 = new ZonaDeCobertura(epicentro, radio, nombre);
		org1 = new Organizacion(epicentro, 10, TipoDeOrganizacion.Cultural);
		org2 = new Organizacion(epicentro, 15, TipoDeOrganizacion.Educativa);
		muestra = mock(Muestra.class);
	}
	
	@Test
	public void testZonaBienInicializada() {
		assertEquals(zona1.getEpicentro(), epicentro);
		assertEquals(zona1.getNombre(), nombre);
		assertEquals(zona1.getRadio(), radio);
		assertTrue(zona1.getMuestras().isEmpty());
	}
	
	@Test
	public void zonasQueSolapanTest() {
		Ubicacion epicentro2 = new Ubicacion("epicentro", 5, 11);
		zona2 = new ZonaDeCobertura(epicentro2, 200, "zona");
		assertTrue(zona1.solapaConUnaZona(zona2));
		Ubicacion epicentro3 = new Ubicacion("epicentro", 50, 14);
		ZonaDeCobertura zona3 = new ZonaDeCobertura(epicentro3, 200, "zona");
		ArrayList<ZonaDeCobertura> zonas = new ArrayList<>();
		zonas.add(zona2);
		zonas.add(zona3);
		assertEquals(zona1.zonasQueSolapan(zonas).size(), 1);
	}

	@Test
	public void observersTest() {
		zona1.agregarObserver(org1);
		zona1.agregarObserver(org2);
		assertEquals(zona1.getObservers().size(), 2);
		zona1.sacarObserver(org1);
		assertEquals(zona1.getObservers().size(), 1);
	}
	
	@Test
	public void notifyTest() {
		Organizacion org = mock(Organizacion.class);
		FuncionalidadExterna muestraValidada = mock(FuncionalidadExterna.class);
		FuncionalidadExterna nuevaMuestra = mock(FuncionalidadExterna.class);
		org.setFunMuestraValidada(muestraValidada);
		org.setFunNuevaMuestra(nuevaMuestra);
		zona1.agregarObserver(org);
		zona1.notifyNuevaMuestra(muestra);
		zona1.notifyMuestraValidada(muestra);
		verify(org, times(1)).updateNuevaMuestra(zona1, muestra);
	}
	
}
