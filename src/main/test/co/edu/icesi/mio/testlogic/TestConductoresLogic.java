package co.edu.icesi.mio.testlogic;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.icesi.mio.logic.ITmio1_ConductoresLogic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestConductoresLogic {

	@Autowired
	private ITmio1_ConductoresLogic tMioConductoresLogic;
	
	

	@Test
	private void testCedulaNumerica() {
		assertNotNull(tMioConductoresLogic);
		
		
	}
	
	
	@Test
	private void test2() {
		assertNotNull(tMioConductoresLogic);
		
	}
	
	
	@Test
	private void test3() {
		assertNotNull(tMioConductoresLogic);
		
	}
	
	
	@Test
	private void test4() {
		assertNotNull(tMioConductoresLogic);
		
	}
	
	
	@Test
	private void test5() {
		assertNotNull(tMioConductoresLogic);
		
	}
	
	
}
