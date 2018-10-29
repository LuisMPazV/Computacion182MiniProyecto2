package co.edu.icesi.mio.testlogic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.icesi.mio.exceptions.RutasLogicException;
import co.edu.icesi.mio.logic.ITmio1_RutasLogic;
import co.edu.icesi.mio.model.Tmio1Ruta;
import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServiciosSitio;
import co.edu.icesi.mio.model.Tmio1SitiosRuta;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestRutasLogic {

	@Autowired
	private ITmio1_RutasLogic tMioRutasLogic;

	private Tmio1Ruta ruta;

	private void contextPruebaActivaNoValido() {
		ruta = new Tmio1Ruta();
		ruta.setActiva("R");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(1));
		ruta.setDiaFin(new BigDecimal(6));
		ruta.setHoraInicio(new BigDecimal(4));
		ruta.setHoraFin(new BigDecimal(17));
		ruta.setNumero("P47");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());

	}

	private void contextRutaValida() {
		ruta = new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(1));
		ruta.setDiaFin(new BigDecimal(6));
		ruta.setHoraInicio(new BigDecimal(4));
		ruta.setHoraFin(new BigDecimal(17));
		ruta.setNumero("P47");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());

	}

	private void contextNumeroNoDefinido() {
		ruta = new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(1));
		ruta.setDiaFin(new BigDecimal(6));
		ruta.setHoraInicio(new BigDecimal(4));
		ruta.setHoraFin(new BigDecimal(17));
		ruta.setNumero(null);
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());

	}

	private void contextNumeroNoTresCaracteres() {
		ruta = new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(1));
		ruta.setDiaFin(new BigDecimal(6));
		ruta.setHoraInicio(new BigDecimal(4));
		ruta.setHoraFin(new BigDecimal(17));
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
		ruta.setNumero("T564");
	}

	private void contextNoDiaInicio() {
		ruta = new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(null);
		ruta.setDiaFin(new BigDecimal(6));
		ruta.setHoraInicio(new BigDecimal(4));
		ruta.setHoraFin(new BigDecimal(17));
		ruta.setNumero("P47");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());

	}

	private void contextNoDiaInicioValido() {
		ruta = new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(23));
		ruta.setDiaFin(new BigDecimal(6));
		ruta.setHoraInicio(new BigDecimal(4));
		ruta.setHoraFin(new BigDecimal(17));
		ruta.setNumero("P47");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());

	}

	private void contextNoDiaFin() {
		ruta = new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(1));
		ruta.setDiaFin(null);
		ruta.setHoraInicio(new BigDecimal(4));
		ruta.setHoraFin(new BigDecimal(17));
		ruta.setNumero("P47");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());

	}

	private void contextNoDiaFinValido() {
		ruta = new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(1));
		ruta.setDiaFin(new BigDecimal(50));
		ruta.setHoraInicio(new BigDecimal(4));
		ruta.setHoraFin(new BigDecimal(17));
		ruta.setNumero("P47");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());

	}

	private void contextDiaInicioMayorFin() {
		ruta = new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(6));
		ruta.setDiaFin(new BigDecimal(2));
		ruta.setHoraInicio(new BigDecimal(4));
		ruta.setHoraFin(new BigDecimal(17));
		ruta.setNumero("P47");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());

	}

	private void contextNoHoraInicio() {
		ruta = new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(2));
		ruta.setDiaFin(new BigDecimal(6));
		ruta.setHoraInicio(null);
		ruta.setHoraFin(new BigDecimal(17));
		ruta.setNumero("P47");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
	}

	private void contextNoHoraInicioValida() {
		ruta = new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(2));
		ruta.setDiaFin(new BigDecimal(6));
		ruta.setHoraInicio(new BigDecimal(2000));
		ruta.setHoraFin(new BigDecimal(17));
		ruta.setNumero("P47");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
	}

	private void contextNoHoraFin() {
		ruta = new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(2));
		ruta.setDiaFin(new BigDecimal(6));
		ruta.setHoraInicio(new BigDecimal(4));
		ruta.setHoraFin(null);
		ruta.setNumero("P47");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
	}

	private void contextNoHoraFinValida() {
		ruta = new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(2));
		ruta.setDiaFin(new BigDecimal(6));
		ruta.setHoraInicio(new BigDecimal(4));
		ruta.setHoraFin(new BigDecimal(-30));
		ruta.setNumero("P47");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
	}

	private void contextHoraInicioMayorHoraFin() {
		ruta = new Tmio1Ruta();
		ruta.setActiva("S");
		ruta.setDescripcion("ruta A a B");
		ruta.setDiaInicio(new BigDecimal(2));
		ruta.setDiaFin(new BigDecimal(6));
		ruta.setHoraInicio(new BigDecimal(200));
		ruta.setHoraFin(new BigDecimal(50));
		ruta.setNumero("P47");
		ruta.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		ruta.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		ruta.setTmio1SitiosRutas1(new ArrayList<Tmio1SitiosRuta>());
	}

	@Test
	public void testRutaValida() {
		assertNotNull(tMioRutasLogic);
		contextRutaValida();
		try {
			tMioRutasLogic.updateRuta(ruta);
		} catch (RutasLogicException e) {
			System.out.println(e.getMsg());
			fail();
		}
	}

	@Test
	public void testEstadoActivaNoValido() {
		assertNotNull(tMioRutasLogic);
		contextPruebaActivaNoValido();
		try {
			tMioRutasLogic.createRuta(ruta);
		} catch (RutasLogicException e) {
			assertEquals(RutasLogicException.ACTIVA_NO_VALIDO, e.getMsg());
		}
	}

	@Test
	public void testNumeroNoDefinido() {
		assertNotNull(tMioRutasLogic);
		contextNumeroNoDefinido();
		try {
			tMioRutasLogic.createRuta(ruta);
			fail();
		} catch (RutasLogicException e) {
			assertEquals(RutasLogicException.NO_NUMERO_RUTA, e.getMsg());
		}

	}

	@Test
	public void testNumeroNoTresCaracteres() {
		assertNotNull(tMioRutasLogic);
		contextNumeroNoTresCaracteres();
		try {
			tMioRutasLogic.createRuta(ruta);
			fail();
		} catch (RutasLogicException e) {
			assertEquals(RutasLogicException.NO_NUMERO_RUTA_TRES_CARACTERES, e.getMsg());
		}
	}

	@Test
	public void testNoDiaInicio() {
		assertNotNull(tMioRutasLogic);
		contextNoDiaInicio();

		try {
			tMioRutasLogic.createRuta(ruta);
			fail();
		} catch (RutasLogicException e) {
			assertEquals(RutasLogicException.DIA_INICIO_NO_NUMERO, e.getMsg());
		}

	}

	@Test
	public void testNoDiaInicioValido() {
		assertNotNull(tMioRutasLogic);
		contextNoDiaInicioValido();
		try {
			tMioRutasLogic.createRuta(ruta);
			fail();
		} catch (RutasLogicException e) {
			assertEquals(RutasLogicException.DIA_INICIO_NO_VALIDO, e.getMsg());
		}
	}

	@Test
	public void testNoDiaFin() {
		assertNotNull(tMioRutasLogic);
		contextNoDiaFin();
		try {
			tMioRutasLogic.createRuta(ruta);
			fail();
		} catch (RutasLogicException e) {
			assertEquals(RutasLogicException.DIA_FIN_NO_NUMERO, e.getMsg());
		}

	}

	@Test
	public void testNoDiaFinValido() {
		assertNotNull(tMioRutasLogic);
		contextNoDiaFinValido();
		try {
			tMioRutasLogic.createRuta(ruta);
			fail();
		} catch (RutasLogicException e) {
			assertEquals(RutasLogicException.DIA_FIN_NO_VALIDO, e.getMsg());
		}
	}

	@Test
	public void testDiaInicioMayorFin() {
		assertNotNull(tMioRutasLogic);
		contextDiaInicioMayorFin();
		try {
			tMioRutasLogic.createRuta(ruta);
			fail();
		} catch (RutasLogicException e) {
			assertEquals(RutasLogicException.DIA_INICIO_MAYOR_FIN, e.getMsg());
		}
	}

	@Test
	public void testNoHoraInicio() {
		assertNotNull(tMioRutasLogic);
		contextNoHoraInicio();
		try {
			tMioRutasLogic.createRuta(ruta);
			fail();
		} catch (RutasLogicException e) {
			assertEquals(RutasLogicException.HORA_INICIO_NO_NUMERO, e.getMsg());
		}

	}

	@Test
	public void testNoHoraInicioValida() {
		assertNotNull(tMioRutasLogic);
		contextNoHoraInicioValida();
		try {
			tMioRutasLogic.createRuta(ruta);
			fail();
		} catch (RutasLogicException e) {
			assertEquals(RutasLogicException.HORA_INICIO_NO_VALIDA, e.getMsg());
		}

	}

	@Test
	public void testNoHoraFin() {
		assertNotNull(tMioRutasLogic);
		contextNoHoraFin();
		try {
			tMioRutasLogic.createRuta(ruta);
			fail();
		} catch (RutasLogicException e) {
			assertEquals(RutasLogicException.HORA_FIN_NO_NUMERO, e.getMsg());
		}

	}

	@Test
	public void testNoHoraFinValida() {
		assertNotNull(tMioRutasLogic);
		contextNoHoraFinValida();
		try {
			tMioRutasLogic.createRuta(ruta);
			fail();
		} catch (RutasLogicException e) {
			assertEquals(RutasLogicException.HORA_FIN_NO_VALIDA, e.getMsg());
		}

	}

	@Test
	public void testHoraInicioHoraFin() {
		assertNotNull(tMioRutasLogic);
		contextHoraInicioMayorHoraFin();
		try {
			tMioRutasLogic.createRuta(ruta);
			fail();
		} catch (RutasLogicException e) {
			assertEquals(RutasLogicException.HORA_INICIO_MAYOR_FIN, e.getMsg());
		}
	}

}
