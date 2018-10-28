package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.mio.dao.Tmio1_Rutas_DAO;
import co.edu.icesi.mio.exceptions.RutasLogicException;
import co.edu.icesi.mio.model.Tmio1Ruta;

@Service
public class Tmio1_RutasLogic implements ITmio1_RutasLogic{

	
	@Autowired
	Tmio1_Rutas_DAO tMioRutasDao;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void createRuta(Tmio1Ruta ruta) throws RutasLogicException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRuta(Tmio1Ruta ruta) throws RutasLogicException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRuta(Tmio1Ruta ruta) throws RutasLogicException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tmio1Ruta> getRutasByRangeDays(BigDecimal begin, BigDecimal end) throws RutasLogicException {
		// TODO Auto-generated method stub
		return null;
	}

	
	


}
