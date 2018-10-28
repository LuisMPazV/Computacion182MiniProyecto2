package co.edu.icesi.mio.logic;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.GregorianCalendar;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.mio.dao.Tmio1_Conductores_DAO;
import co.edu.icesi.mio.exceptions.ConductoresLogicException;
import co.edu.icesi.mio.model.Tmio1Conductore;

@Service
public class Tmio1_ConductoresLogic implements ITmio1_ConductoresLogic{

	@Autowired
	Tmio1_Conductores_DAO tMioConductoresDao;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void createConductor(Tmio1Conductore conductor) throws ConductoresLogicException {
		if(conductor==null) {
			
		}else if(conductor.getCedula()==null||conductor.getCedula().isEmpty()) {
			//TODO falta validar que la cedula sea solo de numeros
		}else if(conductor.getNombre()==null||(conductor.getNombre().isEmpty()||conductor.getNombre().length()<3)) {
			
		}else if(conductor.getApellidos()==null||(conductor.getApellidos().isEmpty()||conductor.getApellidos().length()<3)) {
			
		}else if(conductor.getFechaNacimiento()==null||(new Date(System.currentTimeMillis()).getYear()-conductor.getFechaNacimiento().getYear())<18) {
			
		}else if(conductor.getFechaContratacion()==null||new Date(System.currentTimeMillis()).compareTo(conductor.getFechaContratacion())<0) {
			
		}else {
			tMioConductoresDao.save(entityManager, conductor);
		}
		
	}

	@Override
	@Transactional
	public void deleteConductor(Tmio1Conductore conductor) throws ConductoresLogicException {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void updateConductor(Tmio1Conductore conductor) throws ConductoresLogicException {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Tmio1Conductore findConductorByCedula(String cedula) throws ConductoresLogicException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Tmio1Conductore> findConductorByNombre(String nombre) throws ConductoresLogicException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Tmio1Conductore> findConductorByApellido(String apellido) throws ConductoresLogicException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
