package becapp;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlumnoTest {

	@Test
	public void testGetUmbral_ingresos() {
		Alumno A = new Alumno(3,20000,646050289,estudios_requisitos.ESO, umbral_ingresos.UMBRAL1);
		umbral_ingresos resultado=A.getUmbral_ingresos();
		assertEquals(resultado, umbral_ingresos.UMBRAL1);
	}

	@Test
	public void testSetUmbral_ingresos() {
		Alumno A = new Alumno(3,20000,646050289,estudios_requisitos.ESO, umbral_ingresos.UMBRAL1);
		umbral_ingresos cambio = umbral_ingresos.UMBRAL3;
		A.setUmbral_ingresos(cambio);
		umbral_ingresos resultado = A.getUmbral_ingresos();
		assertEquals(resultado, cambio);
	}

	@Test
	public void testCalcularUmbral() {
		Alumno A = new Alumno(3,26000,646050289,estudios_requisitos.ESO, umbral_ingresos.UMBRAL1);
		String resultado = A.calcularUmbral(A);
		assertEquals(resultado,A.getUmbral_ingresos().toString());
	}

	@Test
	public void testAniadirFavorito() {
		fail("Not yet implemented");
	}

	@Test
	public void testMostrarBecaFavorita() {
		fail("Not yet implemented");
	}

	@Test
	public void testBorrarBecaFavorita() {
		fail("Not yet implemented");
	}

}
