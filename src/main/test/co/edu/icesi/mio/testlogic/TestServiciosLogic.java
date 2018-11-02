package co.edu.icesi.mio.testlogic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.icesi.mio.exceptions.ServiciosLogicException;
import co.edu.icesi.mio.logic.ITmio1_BusesLogic;
import co.edu.icesi.mio.logic.ITmio1_ConductoresLogic;
import co.edu.icesi.mio.logic.ITmio1_RutasLogic;
import co.edu.icesi.mio.logic.ITmio1_ServiciosLogic;
import co.edu.icesi.mio.model.Tmio1Bus;
import co.edu.icesi.mio.model.Tmio1Conductore;
import co.edu.icesi.mio.model.Tmio1Ruta;
import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServicioPK;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestServiciosLogic {

	@Autowired
	private ITmio1_ServiciosLogic tMioServiciosLogic;
	
	@Autowired
	private ITmio1_BusesLogic tMioBusesLogic;
	
	@Autowired
	private ITmio1_RutasLogic tMioRutasLogic;
	
	@Autowired
	private ITmio1_ConductoresLogic tMioConductoresLogic;
	
	Tmio1Ruta ruta;
	Tmio1Ruta ruta2;
	
	Tmio1Bus bus;
	Tmio1Bus bus2;
	
	Tmio1Conductore conductor;
	Tmio1Conductore conductor2;
	
	Tmio1Servicio servicio;
	Tmio1Servicio servicio2;
	
	public void variables() {
		conductor = new Tmio1Conductore();
		conductor.setCedula("11445891");
		conductor.setNombre("Andres");
		conductor.setApellidos("Borrero");
		conductor.setFechaContratacion(new Date((long)(System.currentTimeMillis() - (3.154e+10)*5)));
		conductor.setFechaNacimiento(new Date((long)(System.currentTimeMillis() - (3.154e+10)*20)));
		
		conductor2 = new Tmio1Conductore();
		conductor2.setCedula("12345681");
		conductor2.setNombre("Mateo");
		conductor2.setApellidos("Marin");
		conductor2.setFechaContratacion(new Date((long)(System.currentTimeMillis() - (3.154e+10)*5)));
		conductor2.setFechaNacimiento(new Date((long)(System.currentTimeMillis() - (3.154e+10)*20)));
		
		bus = new Tmio1Bus();
		bus.setCapacidad(new BigDecimal("80"));
		bus.setMarca("Mercedes");
		bus.setModelo(new BigDecimal("2015"));
		bus.setPlaca("XAW234");
		bus.setTipo("A");
		
		bus2 = new Tmio1Bus();
		bus2.setCapacidad(new BigDecimal("50"));
		bus2.setMarca("Mercedes");
		bus2.setModelo(new BigDecimal("2018"));
		bus2.setPlaca("ABC123");
		bus2.setTipo("T");

		ruta = new Tmio1Ruta();
		ruta.setActiva("N");
		ruta.setDescripcion("Ruta 1");
		ruta.setDiaInicio(new BigDecimal("3"));
		ruta.setDiaFin(new BigDecimal("7"));
		ruta.setHoraInicio(new BigDecimal("10"));
		ruta.setHoraFin(new BigDecimal("1400"));
		ruta.setNumero("001");
		
		ruta2 = new Tmio1Ruta();
		ruta2.setActiva("S");
		ruta2.setDescripcion("Ruta 2");
		ruta2.setDiaInicio(new BigDecimal("2"));
		ruta2.setDiaFin(new BigDecimal("5"));
		ruta2.setHoraInicio(new BigDecimal("2"));
		ruta2.setHoraFin(new BigDecimal("1330"));
		ruta2.setNumero("002");
		
		try {
			
			tMioConductoresLogic.createConductor(conductor);
			tMioConductoresLogic.createConductor(conductor2);

			tMioBusesLogic.createBus(bus);
			tMioBusesLogic.createBus(bus2);
			
			tMioRutasLogic.createRuta(ruta);
			tMioRutasLogic.createRuta(ruta2);
			
		} catch (Exception e) {
			System.out.println("->>>>>>>>"+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public void deleteVariables() {
		try {
			tMioConductoresLogic.deleteConductor(conductor);
			tMioConductoresLogic.deleteConductor(conductor2);
			
			tMioBusesLogic.deleteBus(bus);
			tMioBusesLogic.deleteBus(bus2);
			
			tMioRutasLogic.deleteRuta(ruta);
			tMioRutasLogic.deleteRuta(ruta2);
		} catch (Exception e) {
			System.out.println("----------------->aaaaaa");
			System.out.println(e.getMessage());
		}
	}
	
	public void escenario1(){
		
		Tmio1ServicioPK pk = new Tmio1ServicioPK();
		pk.setIdRuta(ruta.getId());
		pk.setIdBus(bus2.getId());
		pk.setFechaInicio(new Date(System.currentTimeMillis()-(86400000*(7-1))));
		pk.setFechaFin(new Date(System.currentTimeMillis()+(86400000*(7+1))));
		pk.setCedulaConductor(conductor.getCedula());
		
		servicio = new Tmio1Servicio();
		servicio.setId(pk);
		servicio.setTmio1Bus(bus2);
		servicio.setTmio1Conductore(conductor);
		servicio.setTmio1Ruta(ruta);
		
	}
	
	public void escenario2(){
		
		Tmio1ServicioPK pk = new Tmio1ServicioPK();
		pk.setIdRuta(ruta.getId());
		pk.setIdBus(bus.getId());
		pk.setFechaInicio(new Date(System.currentTimeMillis()-(86400000*(7-1))));
		pk.setFechaFin(new Date(System.currentTimeMillis()+(86400000*(7+1))));
		pk.setCedulaConductor(conductor.getCedula());
		
		servicio = new Tmio1Servicio();
		servicio.setTmio1Conductore(conductor);
		servicio.setTmio1Ruta(ruta);
		
		Tmio1ServicioPK pk2 = new Tmio1ServicioPK();
		pk2.setIdRuta(ruta2.getId());
		pk2.setIdBus(bus2.getId());
		pk2.setFechaInicio(new Date(System.currentTimeMillis()-(86400000*(7))));
		pk2.setFechaFin(new Date(System.currentTimeMillis()+(86400000*(7))));
		pk2.setCedulaConductor(conductor2.getCedula());
		
		servicio2 = new Tmio1Servicio();
		servicio2.setId(pk2);
		servicio2.setTmio1Bus(bus2);
		servicio2.setTmio1Ruta(ruta2);
		
	}
	
	public void escenario3(){
		
		Tmio1ServicioPK pk = new Tmio1ServicioPK();
		pk.setIdRuta(ruta.getId());
		pk.setIdBus(bus.getId());
		pk.setFechaFin(new Date(System.currentTimeMillis()+(86400000*(7+1))));
		pk.setCedulaConductor(conductor.getCedula());
		
		servicio = new Tmio1Servicio();
		servicio.setId(pk);
		servicio.setTmio1Bus(bus);
		servicio.setTmio1Conductore(conductor);
		servicio.setTmio1Ruta(ruta);
		
		Tmio1ServicioPK pk2 = new Tmio1ServicioPK();
		pk2.setIdRuta(ruta.getId());
		pk2.setIdBus(bus.getId());
		pk2.setFechaInicio(new Date(System.currentTimeMillis()+(86400000*(7))));
		pk2.setFechaFin(new Date(System.currentTimeMillis()-(86400000*(7))));
		pk2.setCedulaConductor(conductor.getCedula());
		
		servicio2 = new Tmio1Servicio();
		servicio2.setId(pk2);
		servicio2.setTmio1Bus(bus);
		servicio2.setTmio1Conductore(conductor);
		servicio2.setTmio1Ruta(ruta);
		
	}
	
	public void escenario4(){
		
		Tmio1ServicioPK pk = new Tmio1ServicioPK();
		pk.setIdRuta(ruta.getId());
		pk.setIdBus(bus2.getId());
		pk.setFechaInicio(new Date(System.currentTimeMillis()-(86400000*(7))));
		pk.setFechaFin(new Date(System.currentTimeMillis()+(86400000*(7))));
		pk.setCedulaConductor(conductor.getCedula());
		
		servicio = new Tmio1Servicio();
		servicio.setId(pk);
		servicio.setTmio1Bus(bus2);
		servicio.setTmio1Conductore(conductor);
		servicio.setTmio1Ruta(ruta);
		
	}
	
	public void escenario5(){
		
		Date a = new GregorianCalendar(2018, 10, 15).getTime();
		Date b = new GregorianCalendar(2018, 11, 20).getTime();
		
		Tmio1ServicioPK pk = new Tmio1ServicioPK();
		pk.setIdRuta(ruta.getId());
		pk.setIdBus(bus2.getId());
		pk.setFechaInicio(a);
		pk.setFechaFin(b);
		pk.setCedulaConductor(conductor.getCedula());
		
		servicio = new Tmio1Servicio();
		servicio.setId(pk);
		servicio.setTmio1Bus(bus2);
		servicio.setTmio1Conductore(conductor);
		servicio.setTmio1Ruta(ruta);
		
		try {
			tMioServiciosLogic.createServicio(servicio);
		} catch (Exception e) {
			System.out.println("Hola prro");
		}
		
	}
	
	@Test
	public void testInsertarValido() {
		assertNotNull(tMioServiciosLogic);
		System.out.println("------------------> 1");
		variables();
		escenario1();
		try {
			tMioServiciosLogic.createServicio(servicio);
		} catch (Exception e) {
			e.printStackTrace();
			fail("No se pudo agregar el servicio");
		}
		try {
			tMioServiciosLogic.deleteServicio(servicio);
		} catch (Exception e) {
		}
		deleteVariables();
	}
	
	
	@Test
	public void testLlavesExisten() {
		assertNotNull(tMioServiciosLogic);
		//Intento de registro sin llave bus
		System.out.println("------------------> 2");
		variables();
		escenario2();
		try {
			tMioServiciosLogic.createServicio(servicio);
			fail("Servicio agregrado sin llave bus");
		} catch (Exception e) {
			assertEquals(ServiciosLogicException.NO_LLAVE_FORANEA_BUS, e.getMessage());
		}
		//Intento de registro sin llave conductor
		try {
			tMioServiciosLogic.createServicio(servicio2);
			fail("Servicio agregrado sin llave conductor");
		} catch (Exception e) {
			assertEquals(ServiciosLogicException.NO_LLAVE_FORANEA_CONDUCTOR, e.getMessage());
		}
		deleteVariables();
	}
	
	
	@Test
	public void testFechaExisteYMenorQueFinal() {
		assertNotNull(tMioServiciosLogic);
		System.out.println("------------------> 3");
		variables();
		escenario3();
		
		//Intento agregar un servicio sin fecha inicio
		try {
			tMioServiciosLogic.createServicio(servicio);
			fail("Agrego un Servicio sin fecha de inicio");
		} catch (Exception e) {
			assertEquals(ServiciosLogicException.NO_FECHA_INICIO, e.getMessage());
		}
		
		//Intento Agregar un servicio con fecha final menor que inicial
		try {
			tMioServiciosLogic.createServicio(servicio2);
			fail("Se agrego un servicio con fecia final menor que inicial");
		} catch (Exception e) {
			assertEquals(ServiciosLogicException.FECHA_INICIO_MAYOR_FECHA_FIN, e.getMessage());
		}
		deleteVariables();
	}
	
	
	@Test
	public void testFindServicioByRengeOfDaysConInputsInvalidos() {
		assertNotNull(tMioServiciosLogic);
		
		//Intento no fecha inicio
		try {
			tMioServiciosLogic.findServicioByRangeOfDates(null, new GregorianCalendar(2018, 10, 10));
			fail("fecha inicio no definida");
		} catch (ServiciosLogicException e) {
			assertEquals(ServiciosLogicException.NO_FECHA_INICIO, e.getMessage());
		}
		
		//Intento no fecha fin
		try {
			tMioServiciosLogic.findServicioByRangeOfDates(new GregorianCalendar(2018, 10, 10), null);
			fail("fecha fin no definida");
		} catch (ServiciosLogicException e) {
			assertEquals(ServiciosLogicException.NO_FECHA_FIN, e.getMessage());
		}
		
		//Intento fecha inicio mayor que fecha fin
		try {
			tMioServiciosLogic.findServicioByRangeOfDates(new GregorianCalendar(2019, 10, 10), new GregorianCalendar(2018, 11, 20));
			fail("fecha inicio mayor que fecha fin");
		} catch (ServiciosLogicException e) {
			assertEquals(ServiciosLogicException.FECHA_INICIO_MAYOR_FECHA_FIN, e.getMessage());
		}
	}
	
	
	@Test
	public void testFindServicioByRengeOfDaysConInputsValidos() {
		assertNotNull(tMioServiciosLogic);
		variables();
		escenario5();
		
		List<Tmio1Servicio> servicios = null;
		try {
			servicios = tMioServiciosLogic.findServicioByRangeOfDates(new GregorianCalendar(2018, 10, 14), new GregorianCalendar(2018, 11, 21));
		} catch (Exception e) {
			fail("Excepcion inesperada en la busqueda");
		}
		assertNotNull(servicios);
		assertEquals(1, servicios.size());
		try {
			tMioServiciosLogic.deleteServicio(servicio);
		} catch (Exception e) {
		}
		deleteVariables();
	}
	
}
