package co.edu.icesi.mio.testlogic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.icesi.mio.exceptions.BusesLogicException;
import co.edu.icesi.mio.logic.ITmio1_BusesLogic;
import co.edu.icesi.mio.model.Tmio1Bus;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestBusesLogic {

	Tmio1Bus bus;
	Tmio1Bus bus2;
	
	@Autowired
	private ITmio1_BusesLogic tMioBusesLogic;
	
	public void escenario1() {
		
		bus = new Tmio1Bus();
		bus.setCapacidad(new BigDecimal("80"));
		bus.setMarca("Mercedes");
		bus.setModelo(new BigDecimal("2015"));
		bus.setPlaca("XAW234");
		bus.setTipo("A");
	}
	
	public void escenario2() {
		
		bus = new Tmio1Bus();
		bus.setCapacidad(new BigDecimal("80"));
		bus.setMarca("Mercedes");
		bus.setModelo(new BigDecimal("2015"));
		bus.setTipo("A");
		
		bus2 = new Tmio1Bus();
		bus2.setCapacidad(new BigDecimal("50"));
		bus2.setMarca("Mercedes");
		bus2.setModelo(new BigDecimal("2018"));
		bus2.setPlaca("ABC12");
		bus2.setTipo("T");

	}
	
	public void escenario3() {
		
		bus = new Tmio1Bus();
		bus.setCapacidad(new BigDecimal("80"));
		bus.setMarca("Mercedes");
		bus.setPlaca("XAW234");
		bus.setTipo("A");
		
		bus2 = new Tmio1Bus();
		bus2.setCapacidad(new BigDecimal("50"));
		bus2.setMarca("Mercedes");
		bus2.setModelo(new BigDecimal("201"));
		bus2.setPlaca("ABC123");
		bus2.setTipo("T");
		
	}
	
	public void escenario4() {
		
		bus = new Tmio1Bus();
		bus.setCapacidad(new BigDecimal("80"));
		bus.setMarca("Mercedes");
		bus.setModelo(new BigDecimal("2015"));
		bus.setPlaca("XAW234");
		
		bus2 = new Tmio1Bus();
		bus2.setCapacidad(new BigDecimal("50"));
		bus2.setMarca("Mercedes");
		bus2.setModelo(new BigDecimal("2018"));
		bus2.setPlaca("ABC123");
		bus2.setTipo("Holi");

	}
	
	public void escenario5() {
		
		bus = new Tmio1Bus();
		bus.setMarca("Mercedes");
		bus.setModelo(new BigDecimal("2015"));
		bus.setPlaca("XAW234");
		bus.setTipo("A");
		
		bus2 = new Tmio1Bus();
		bus2.setCapacidad(new BigDecimal("-10"));
		bus2.setMarca("Mercedes");
		bus2.setModelo(new BigDecimal("2018"));
		bus2.setPlaca("ABC123");
		bus2.setTipo("T");

	}

	@Test
	public void testInsertarValido() {
		assertNotNull(tMioBusesLogic);
		escenario1();
		//Registro bus valido
		try {
			tMioBusesLogic.createBus(bus);
		} catch (Exception e) {
			fail("El bus no se pudo agregar");
		}
	}
	
	
	@Test
	public void testPlacaNoDefinidaY6Caracteres() {
		
		assertNotNull(tMioBusesLogic);
		escenario2();
		//Intento de registro placa no valida
		try {
			tMioBusesLogic.createBus(bus);
			fail("Se agrego un bus con placa no definida");
		} catch (Exception e) {
			assertEquals(BusesLogicException.NO_PLACA, e.getMessage());
		}
		//Intento d eregistro placa con numero de caracteres diferente de 6
		try {
			tMioBusesLogic.createBus(bus2);
			fail("Se agrego un bus con placa con numero de caracteres diferente de 6");
		} catch (Exception e) {
			assertEquals(BusesLogicException.NO_PLACA_SEIS_CARACTERES, e.getMessage());
		}
		
	}
	
	
	@Test
	public void testModeloNumericoY4Digitos() {
		assertNotNull(tMioBusesLogic);
		escenario3();
		//Intento de registro placa no valida
		try {
			tMioBusesLogic.createBus(bus);
			fail("Se agrego un bus con modelo numerico no definido");
		} catch (Exception e) {
			assertEquals(BusesLogicException.NO_MODELO_NUMERICO, e.getMessage());
		}
		//Intento d eregistro placa con numero de caracteres diferente de 6
		try {
			tMioBusesLogic.createBus(bus2);
			fail("Se agrego un bus con modelo con numero de digitos diferente de 4");
		} catch (Exception e) {
			assertEquals(BusesLogicException.NO_MODELO_CUATRO_CARACTERES, e.getMessage());
		}
	}
	
	
	@Test
	public void testTipoPAT() {
		assertNotNull(tMioBusesLogic);
		escenario4();
		//Intento de registro placa no valida
		try {
			tMioBusesLogic.createBus(bus);
			fail("Se agrego un bus con tipo no definido");
		} catch (Exception e) {
			assertEquals(BusesLogicException.TIPO_NO_DEFINIDA, e.getMessage());
		}
		//Intento d eregistro placa con numero de caracteres diferente de 6
		try {
			tMioBusesLogic.createBus(bus2);
			fail("Se agrego un bus con tipo no valido");
		} catch (Exception e) {
			assertEquals(BusesLogicException.TIPO_NO_VALIDO, e.getMessage());
		}
	}
	
	
	@Test
	public void testCapacidadNumericaYMayorA0() {
		assertNotNull(tMioBusesLogic);
		escenario5();
		//Intento de registro placa no valida
		try {
			tMioBusesLogic.createBus(bus);
			fail("Se agrego un bus con capacidad numerica no definida");
		} catch (Exception e) {
			assertEquals(BusesLogicException.CAPACIDAD_NO_DEFINIDA, e.getMessage());
		}
		//Intento d eregistro placa con numero de caracteres diferente de 6
		try {
			tMioBusesLogic.createBus(bus2);
			fail("Se agrego un bus con capacidad no valida");
		} catch (Exception e) {
			assertEquals(BusesLogicException.CAPACIDAD_NO_VALIDA, e.getMessage());
		}
	}
}
