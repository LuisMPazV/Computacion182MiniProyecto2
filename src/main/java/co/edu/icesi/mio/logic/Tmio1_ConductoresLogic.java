package co.edu.icesi.mio.logic;


import java.util.Date;
import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.mio.dao.ITmio1_Conductores_DAO;
import co.edu.icesi.mio.dao.Tmio1_Conductores_DAO;
import co.edu.icesi.mio.exceptions.ConductoresLogicException;
import co.edu.icesi.mio.model.Tmio1Conductore;

@Service
public class Tmio1_ConductoresLogic implements ITmio1_ConductoresLogic{

	@Autowired
	private ITmio1_Conductores_DAO tMioConductoresDao;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void createConductor(Tmio1Conductore conductor) throws ConductoresLogicException {
		if(conductor==null) {
			throw new ConductoresLogicException(ConductoresLogicException.CONDUCTOR_NO_DEFINIDO);
		}else if(conductor.getCedula()==null||conductor.getCedula().isEmpty()) {
			try {
				Integer.parseInt(conductor.getCedula());
			} catch (Exception e) {
				throw new ConductoresLogicException(ConductoresLogicException.CEDULA_NO_NUMERICA);
			}
		}else if(conductor.getNombre()==null||(conductor.getNombre().isEmpty()||conductor.getNombre().length()<3)) {
			if(conductor.getNombre()==null) {
				throw new ConductoresLogicException(ConductoresLogicException.NOMBRE_NO_DEFINIDO);
			}else {
				throw new ConductoresLogicException(ConductoresLogicException.NOMBRE_LONGITUD_INVALIDA);
			}
		}else if(conductor.getApellidos()==null||(conductor.getApellidos().isEmpty()||conductor.getApellidos().length()<3)) {
			if(conductor.getApellidos()==null) {
				throw new ConductoresLogicException(ConductoresLogicException.APELLIDO_NO_DEFINIDO);
			}else {
				throw new ConductoresLogicException(ConductoresLogicException.APELLIDO_LONGITUD_INVALIDA);
			}
		}else if(conductor.getFechaNacimiento()==null||(new Date(System.currentTimeMillis()).getYear()-conductor.getFechaNacimiento().getYear())<18) {
			if(conductor.getFechaNacimiento()==null) {
				throw new ConductoresLogicException(ConductoresLogicException.FECHA_NACIMIENTO_NO_DEFINIDA);
			}else {
				throw new ConductoresLogicException(ConductoresLogicException.NO_MAYOR_DE_EDAD);
			}
		}else if(conductor.getFechaContratacion()==null||new Date(System.currentTimeMillis()).compareTo(conductor.getFechaContratacion())<0) {
			if(conductor.getFechaContratacion()==null) {
				throw new ConductoresLogicException(ConductoresLogicException.FECHA_CONTRATACION_INVALIDA);
			}else {
				throw new ConductoresLogicException(ConductoresLogicException.FECHA_CONTRATACION_INVALIDA);
			}
		}else {
			tMioConductoresDao.save(entityManager, conductor);
		}
		
	}

	@Override
	@Transactional
	public void deleteConductor(Tmio1Conductore conductor) throws ConductoresLogicException {
		if(conductor==null) {
			throw new ConductoresLogicException(ConductoresLogicException.CONDUCTOR_NO_DEFINIDO);
		}else if(conductor.getCedula()==null||conductor.getCedula().isEmpty()) {
			//TODO falta validar que la cedula sea solo de numeros
		}else if(conductor.getNombre()==null||(conductor.getNombre().isEmpty()||conductor.getNombre().length()<3)) {
			if(conductor.getNombre()==null) {
				throw new ConductoresLogicException(ConductoresLogicException.NOMBRE_NO_DEFINIDO);
			}else {
				throw new ConductoresLogicException(ConductoresLogicException.NOMBRE_LONGITUD_INVALIDA);
			}
		}else if(conductor.getApellidos()==null||(conductor.getApellidos().isEmpty()||conductor.getApellidos().length()<3)) {
			if(conductor.getApellidos()==null) {
				throw new ConductoresLogicException(ConductoresLogicException.APELLIDO_NO_DEFINIDO);
			}else {
				throw new ConductoresLogicException(ConductoresLogicException.APELLIDO_LONGITUD_INVALIDA);
			}
		}else if(conductor.getFechaNacimiento()==null||(new Date(System.currentTimeMillis()).getYear()-conductor.getFechaNacimiento().getYear())<18) {
			if(conductor.getFechaNacimiento()==null) {
				throw new ConductoresLogicException(ConductoresLogicException.FECHA_NACIMIENTO_NO_DEFINIDA);
			}else {
				throw new ConductoresLogicException(ConductoresLogicException.NO_MAYOR_DE_EDAD);
			}
		}else if(conductor.getFechaContratacion()==null||new Date(System.currentTimeMillis()).compareTo(conductor.getFechaContratacion())<0) {
			if(conductor.getFechaContratacion()==null) {
				throw new ConductoresLogicException(ConductoresLogicException.FECHA_CONTRATACION_INVALIDA);
			}else {
				throw new ConductoresLogicException(ConductoresLogicException.FECHA_CONTRATACION_INVALIDA);
			}
		}else {
			tMioConductoresDao.delete(entityManager, conductor);
		}
		
	}

	@Override
	@Transactional
	public void updateConductor(Tmio1Conductore conductor) throws ConductoresLogicException {
		if(conductor==null) {
			throw new ConductoresLogicException(ConductoresLogicException.CONDUCTOR_NO_DEFINIDO);
		}else if(conductor.getCedula()==null||conductor.getCedula().isEmpty()) {
			//TODO falta validar que la cedula sea solo de numeros
		}else if(conductor.getNombre()==null||(conductor.getNombre().isEmpty()||conductor.getNombre().length()<3)) {
			if(conductor.getNombre()==null) {
				throw new ConductoresLogicException(ConductoresLogicException.NOMBRE_NO_DEFINIDO);
			}else {
				throw new ConductoresLogicException(ConductoresLogicException.NOMBRE_LONGITUD_INVALIDA);
			}
		}else if(conductor.getApellidos()==null||(conductor.getApellidos().isEmpty()||conductor.getApellidos().length()<3)) {
			if(conductor.getApellidos()==null) {
				throw new ConductoresLogicException(ConductoresLogicException.APELLIDO_NO_DEFINIDO);
			}else {
				throw new ConductoresLogicException(ConductoresLogicException.APELLIDO_LONGITUD_INVALIDA);
			}
		}else if(conductor.getFechaNacimiento()==null||(new Date(System.currentTimeMillis()).getYear()-conductor.getFechaNacimiento().getYear())<18) {
			if(conductor.getFechaNacimiento()==null) {
				throw new ConductoresLogicException(ConductoresLogicException.FECHA_NACIMIENTO_NO_DEFINIDA);
			}else {
				throw new ConductoresLogicException(ConductoresLogicException.NO_MAYOR_DE_EDAD);
			}
		}else if(conductor.getFechaContratacion()==null||new Date(System.currentTimeMillis()).compareTo(conductor.getFechaContratacion())<0) {
			if(conductor.getFechaContratacion()==null) {
				throw new ConductoresLogicException(ConductoresLogicException.FECHA_CONTRATACION_INVALIDA);
			}else {
				throw new ConductoresLogicException(ConductoresLogicException.FECHA_CONTRATACION_INVALIDA);
			}
		}else {
			tMioConductoresDao.update(entityManager, conductor);
		}
		
	}

	@Override
	@Transactional
	public Tmio1Conductore findConductorByCedula(String cedula) throws ConductoresLogicException {
		if(cedula==null||cedula.isEmpty()) {
			
			throw new ConductoresLogicException(ConductoresLogicException.CEDULA_NO_DEFINIDO);
			
		}else {
			boolean num=true;
			for(int i=0;i<cedula.length()&&num;i++) {
				if(cedula.charAt(i)<48||cedula.charAt(i)>57)
					num=false;
			}
			if(num) {
				return tMioConductoresDao.findByCedula(entityManager, cedula);
				
			}else {

				throw new ConductoresLogicException(ConductoresLogicException.CEDULA_NO_NUMERICA);
				
			}
		}
		
	}

	@Override
	@Transactional
	public List<Tmio1Conductore> findConductorByNombre(String nombre) throws ConductoresLogicException {
		if(nombre==null||(nombre.isEmpty()||nombre.length()<3)) {
			if(nombre==null) {
				throw new ConductoresLogicException(ConductoresLogicException.NOMBRE_NO_DEFINIDO);
			}else {
				throw new ConductoresLogicException(ConductoresLogicException.NOMBRE_LONGITUD_INVALIDA);
			}
		}else {
			return tMioConductoresDao.findByName(entityManager, nombre);			
		}
	}

	@Override
	@Transactional
	public List<Tmio1Conductore> findConductorByApellido(String apellido) throws ConductoresLogicException {
		if(apellido==null||(apellido.isEmpty()||apellido.length()<3)) {
			if(apellido==null) {
				throw new ConductoresLogicException(ConductoresLogicException.APELLIDO_NO_DEFINIDO);
			}else {
				throw new ConductoresLogicException(ConductoresLogicException.APELLIDO_LONGITUD_INVALIDA);
			}
		}else {
			return tMioConductoresDao.findByName(entityManager, apellido);			
		}
	}
	
	

}
