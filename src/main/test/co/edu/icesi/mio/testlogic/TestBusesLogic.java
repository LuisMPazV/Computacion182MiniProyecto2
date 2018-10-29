package co.edu.icesi.mio.testlogic;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.icesi.mio.logic.ITmio1_BusesLogic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestBusesLogic {

	@Autowired
	private ITmio1_BusesLogic tMioBusesLogic;
	

	@Test
	private void test1() {
		assertNotNull(tMioBusesLogic);
		
		
	}
	
	
	@Test
	private void test2() {
		assertNotNull(tMioBusesLogic);
		
	}
	
	
	@Test
	private void test3() {
		assertNotNull(tMioBusesLogic);
		
	}
	
	
	@Test
	private void test4() {
		assertNotNull(tMioBusesLogic);
		
	}
	
	
	@Test
	private void test5() {
		assertNotNull(tMioBusesLogic);
		
	}
}
