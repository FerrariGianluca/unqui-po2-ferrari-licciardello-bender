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
		u1 = new Ubicacion("Lanus",54873428,23123123);
		u2 = new Ubicacion("Banfield",6,8);
		u3 = new Ubicacion("Avellaneda", 3,5);
		u4 = new Ubicacion("Avellaneda", 5,5);
		ubicaciones = new ArrayList<Ubicacion>();
		ubicaciones.add(u3);
		ubicaciones.add(u2);
		ubicaciones.add(u1);
	}
	
	
	
	@Test
	void tieneAlgunaUbicacionAMenosDeXTest() {
		assertTrue(u4.tieneAlgunaUbicacionAMenosDe(ubicaciones, 776897698));
		assertFalse(u4.tieneAlgunaUbicacionAMenosDe(ubicaciones, 1));
	}

	
	
}
