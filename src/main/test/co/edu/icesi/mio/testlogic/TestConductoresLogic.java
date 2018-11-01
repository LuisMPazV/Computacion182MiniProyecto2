package co.edu.icesi.mio.testlogic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.icesi.mio.exceptions.ConductoresLogicException;
import co.edu.icesi.mio.logic.ITmio1_ConductoresLogic;
import co.edu.icesi.mio.model.Tmio1Conductore;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestConductoresLogic {

	@Autowired
	private ITmio1_ConductoresLogic tMioConductoresLogic;
	
	Tmio1Conductore conductor;
	Tmio1Conductore conductor2;
	Tmio1Conductore conductor3;
	Tmio1Conductore conductor4;
	
	public void esceario1() {
		conductor2 = new Tmio1Conductore();
		conductor2.setCedula("455632155");
		conductor2.setNombre("Julian");
		conductor2.setApellidos("Tauta");
		conductor2.setFechaContratacion(new Date((long)(System.currentTimeMillis() - (3.154e+10)*5)));
		conductor2.setFechaNacimiento(new Date((long)(System.currentTimeMillis() - (3.154e+10)*18)));
	}
	
	public void esceario2() {
		conductor = new Tmio1Conductore();
		conductor.setCedula("");
		conductor.setNombre("Andres");
		conductor.setApellidos("Borrero");
		conductor.setFechaContratacion(new Date((long)(System.currentTimeMillis() - (3.154e+10)*5)));
		conductor.setFechaNacimiento(new Date((long)(System.currentTimeMillis() - (3.154e+10)*20)));
		
		conductor2 = new Tmio1Conductore();
		conductor2.setCedula("AAAAA");
		conductor2.setNombre("Luis");
		conductor2.setApellidos("Paz");
		conductor2.setFechaContratacion(new Date((long)(System.currentTimeMillis() - (3.154e+10)*5)));
		conductor2.setFechaNacimiento(new Date((long)(System.currentTimeMillis() - (3.154e+10)*18)));
	}

	public void esceario3() {
		conductor = new Tmio1Conductore();
		conductor.setCedula("1234530");
		conductor.setApellidos("Borrero");
		conductor.setFechaContratacion(new Date((long)(System.currentTimeMillis() - (3.154e+10)*5)));
		conductor.setFechaNacimiento(new Date((long)(System.currentTimeMillis() - (3.154e+10)*20)));
		
		conductor2 = new Tmio1Conductore();
		conductor2.setCedula("455632155");
		conductor2.setNombre("A");
		conductor2.setApellidos("Paz");
		conductor2.setFechaContratacion(new Date((long)(System.currentTimeMillis() - (3.154e+10)*5)));
		conductor2.setFechaNacimiento(new Date((long)(System.currentTimeMillis() - (3.154e+10)*18)));
	}
	
	public void esceario4() {
		conductor = new Tmio1Conductore();
		conductor.setCedula("1234530");
		conductor.setNombre("Andres");
		conductor.setFechaContratacion(new Date((long)(System.currentTimeMillis() - (3.154e+10)*5)));
		conductor.setFechaNacimiento(new Date((long)(System.currentTimeMillis() - (3.154e+10)*20)));
		
		conductor2 = new Tmio1Conductore();
		conductor2.setCedula("455632155");
		conductor2.setNombre("Luis");
		conductor2.setApellidos("P");
		conductor2.setFechaContratacion(new Date((long)(System.currentTimeMillis() - (3.154e+10)*5)));
		conductor2.setFechaNacimiento(new Date((long)(System.currentTimeMillis() - (3.154e+10)*18)));
	}
	
	public void esceario5() {
		conductor = new Tmio1Conductore();
		conductor.setCedula("1234530");
		conductor.setNombre("Andres");
		conductor.setApellidos("Borrero");
		conductor.setFechaContratacion(new Date((long)(System.currentTimeMillis() - (3.154e+10)*5)));
		
		conductor2 = new Tmio1Conductore();
		conductor2.setCedula("455632155");
		conductor2.setNombre("Luis");
		conductor2.setApellidos("Paz");
		conductor2.setFechaContratacion(new Date((long)(System.currentTimeMillis() - (3.154e+10)*5)));
		conductor2.setFechaNacimiento(new Date((long)(System.currentTimeMillis() - (3.154e+10)*17)));
	}
	
	@Test
	public void testInsertarValido() {
		assertNotNull(tMioConductoresLogic);
		esceario1();
		try {
			tMioConductoresLogic.deleteConductor(conductor2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Intento de cedula numerica
		try {
			tMioConductoresLogic.createConductor(conductor2);
		} catch (Exception e) {
			fail("El usuario no pudo ser agregado");
		}
	}
	
	
	@Test
	public void testCedulaNoDefinidaYNumerica() {
		assertNotNull(tMioConductoresLogic);
		esceario2();		
		//Intento de registro cedula no definida nula
		try {
			tMioConductoresLogic.createConductor(conductor);
			fail("Un usuario fue agregado con cedula no definida");
		} catch (Exception e) {
			assertEquals(ConductoresLogicException.CEDULA_NO_DEFINIDO, e.getMessage());
		}
		//Intento de cedula no numerica
		try {
			tMioConductoresLogic.createConductor(conductor2);
			fail("Un usuario fue agregado con cedula no numerica");
		} catch (Exception e) {
			assertEquals(ConductoresLogicException.CEDULA_NO_NUMERICA, e.getMessage());
		}
	}
	
	
	@Test
	public void NombreDefinidoYMasDe3Caracteres() {
		assertNotNull(tMioConductoresLogic);
		esceario3();
		//Intento de registro nombre nulo
		try {
			tMioConductoresLogic.createConductor(conductor);
			fail("Un usuario fue agregado con nombre no definido");
		} catch (Exception e) {
			assertEquals(ConductoresLogicException.NOMBRE_NO_DEFINIDO, e.getMessage());
		}
		
		//Intento de registro nombre menos 3 caracteres
		try {
			tMioConductoresLogic.createConductor(conductor2);
			fail("Un usuario fue agregado con nombre con longitud invalida");
		} catch (Exception e) {
			assertEquals(ConductoresLogicException.NOMBRE_LONGITUD_INVALIDA, e.getMessage());
		}
	}
	
	
	@Test
	public void testApellidoDefinidoYMasde3Caracteres() {
		assertNotNull(tMioConductoresLogic);
		esceario4();
		//Intento de registro apellido nulo
		try {
			tMioConductoresLogic.createConductor(conductor);
			fail("Un usuario fue agregado con apellido no definido");
		} catch (Exception e) {
			assertEquals(ConductoresLogicException.APELLIDO_NO_DEFINIDO, e.getMessage());
		}
		
		//Intento de registro apellido menos 3 caracteres
		try {
			tMioConductoresLogic.createConductor(conductor2);
			fail("Un usuario fue agregado con apellido con longitud invalida");
		} catch (Exception e) {
			assertEquals(ConductoresLogicException.APELLIDO_LONGITUD_INVALIDA, e.getMessage());
		}
	}
	
	
	@Test
	public void testFechaNacimienyoDefinidaYMayorEdad() {
		assertNotNull(tMioConductoresLogic);
		esceario5();
		//Intento de registro fecha nacimiento nulo
		try {
			tMioConductoresLogic.createConductor(conductor);
			fail("Un usuario fue agregado con fecha de nacimiento no definido");
		} catch (Exception e) {
			assertEquals(ConductoresLogicException.FECHA_NACIMIENTO_NO_DEFINIDA, e.getMessage());
		}
		
		//Intento de registro menor edad
		try {
			tMioConductoresLogic.createConductor(conductor2);
			fail("Un usuario menor de edad fue agregado");
		} catch (Exception e) {
			assertEquals(ConductoresLogicException.NO_MAYOR_DE_EDAD, e.getMessage());
		}
	}
	
	
}
