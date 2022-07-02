package tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppVinchucaTest {
	private AppVinchuca app;
	
	@BeforeEach
	public void setUp(){
		app = new AppVinchuca();
	
	}
	
	
	@Test
	public void appInicializada(){
		assertTrue(app.getMuestras().isEmpty());
		assertTrue(app.getUsuarios().isEmpty());
		assertTrue(app.getZonas().isEmpty());
	}

}
