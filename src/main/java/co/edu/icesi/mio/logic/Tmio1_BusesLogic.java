package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.mio.dao.Tmio1_Buses_DAO;
import co.edu.icesi.mio.exceptions.BusesLogicException;
import co.edu.icesi.mio.model.Tmio1Bus;

@Service
public class Tmio1_BusesLogic implements ITmio1_BusesLogic{

	@Autowired
	private Tmio1_Buses_DAO tMioBusesDao;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void createBus(Tmio1Bus bus) throws BusesLogicException {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void deleteBus(Tmio1Bus bus) throws BusesLogicException {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void updateBus(Tmio1Bus bus) throws BusesLogicException {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<Tmio1Bus> findBusByModelo(BigDecimal modelo) throws BusesLogicException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Tmio1Bus> findBusByTipo(String tipo) throws BusesLogicException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Tmio1Bus> findBusByCapacidad(BigDecimal capacidad) throws BusesLogicException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
