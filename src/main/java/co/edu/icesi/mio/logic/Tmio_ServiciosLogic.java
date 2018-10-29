package co.edu.icesi.mio.logic;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.mio.dao.ITmio1_Buses_DAO;
import co.edu.icesi.mio.dao.ITmio1_Conductores_DAO;
import co.edu.icesi.mio.dao.ITmio1_Rutas_DAO;
import co.edu.icesi.mio.dao.ITmio1_Servicios_DAO;
import co.edu.icesi.mio.exceptions.ServiciosLogicException;
import co.edu.icesi.mio.model.Tmio1Servicio;

@Service
public class Tmio_ServiciosLogic implements ITmio1_ServiciosLogic{

	@Autowired
	private ITmio1_Servicios_DAO tMioServiciosDao;
	
	@Autowired
	private ITmio1_Buses_DAO tMioBusesDao;
	
	@Autowired
	private ITmio1_Rutas_DAO tMioRutasDao;
	
	@Autowired
	private ITmio1_Conductores_DAO tMioConductoresDao;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void createServicio(Tmio1Servicio servicio) throws ServiciosLogicException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteServicio(Tmio1Servicio servicio) throws ServiciosLogicException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateServicio(Tmio1Servicio servicio) throws ServiciosLogicException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tmio1Servicio> findServicioByRangeOfDates(EntityManager em, Calendar fechaInicio, Calendar fechaFin) {
		// TODO Auto-generated method stub
		return null;
	}
}
