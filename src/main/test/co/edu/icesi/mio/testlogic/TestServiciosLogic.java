package co.edu.icesi.mio.testlogic;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.icesi.mio.logic.ITmio1_ServiciosLogic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestServiciosLogic {

	@Autowired
	private ITmio1_ServiciosLogic tMioServiciosLogic;
	
}