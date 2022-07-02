package tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UbicacionTest {

	private Ubicacion u1;
	private Ubicacion u2;
	private Ubicacion u3;
	private Ubicacion u4;
	private ArrayList<Ubicacion> ubicaciones;
	
	@BeforeEach
	public void setUp(){
		u1 = new Ubicacion("Lanus", 54873428, 23123123);
		u2 = new Ubicacion("Banfield", 4, 5);
		u3 = new Ubicacion("Avellaneda", 5, 4);
		u4 = new Ubicacion("Avellaneda", 5, 5);
		ubicaciones = new ArrayList<Ubicacion>();
		ubicaciones.add(u1);
		ubicaciones.add(u2);
		ubicaciones.add(u3);
	}
	
	@Test
	public void tieneAlgunaUbicacionAMenosDeXTest() {
		assertTrue(u4.tieneAlgunaUbicacionAMenosDe(ubicaciones, 776897698));
		assertFalse(u4.tieneAlgunaUbicacionAMenosDe(ubicaciones, 1));
	}

	@Test
	public void ubicacionesAMenosDeXDistanciaTest() {
		u4.ubicacionesAMenosDe(ubicaciones, 1);
	}
	
}
