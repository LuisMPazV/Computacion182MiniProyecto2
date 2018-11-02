package co.edu.icesi.mio.logic;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.mio.dao.ITmio1_Buses_DAO;
import co.edu.icesi.mio.dao.ITmio1_Conductores_DAO;
import co.edu.icesi.mio.dao.ITmio1_Rutas_DAO;
import co.edu.icesi.mio.dao.ITmio1_Servicios_DAO;
import co.edu.icesi.mio.exceptions.ServiciosLogicException;
import co.edu.icesi.mio.model.Tmio1Servicio;

@Service
public class Tmio_ServiciosLogic implements ITmio1_ServiciosLogic {

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
	@Transactional(rollbackFor = ServiciosLogicException.class)
	public void createServicio(Tmio1Servicio servicio) throws ServiciosLogicException {
		if (servicio == null) {
			throw new ServiciosLogicException(ServiciosLogicException.NO_SERVICIO);
		} else if (servicio.getTmio1Bus() == null || servicio.getTmio1Bus().getId() == null
				|| tMioBusesDao.findById(entityManager, servicio.getTmio1Bus().getId()) == null) {
			if (servicio.getTmio1Bus() == null) {
				System.out.println("hola");
				throw new ServiciosLogicException(ServiciosLogicException.NO_LLAVE_FORANEA_BUS);
			} else {
				throw new ServiciosLogicException(ServiciosLogicException.NO_EXISTE_LLAVE_FORANEA_BUS);
			}
		} else if (servicio.getTmio1Conductore() == null || servicio.getTmio1Conductore().getCedula() == null
				|| tMioConductoresDao.findByCedula(entityManager, servicio.getTmio1Conductore().getCedula()) == null) {
			if (servicio.getTmio1Conductore() == null) {
				throw new ServiciosLogicException(ServiciosLogicException.NO_LLAVE_FORANEA_CONDUCTOR);
			} else {
				throw new ServiciosLogicException(ServiciosLogicException.NO_EXISTE_LLAVE_FORANEA_CONDUCTOR);
			}
		} else if (servicio.getTmio1Ruta() == null || servicio.getTmio1Ruta().getId() == null
				|| tMioRutasDao.findById(entityManager, servicio.getTmio1Ruta().getId()) == null) {
			if (servicio.getTmio1Ruta() == null) {
				throw new ServiciosLogicException(ServiciosLogicException.NO_LLAVE_FORANEA_RUTA);
			} else {
				throw new ServiciosLogicException(ServiciosLogicException.NO_EXISTE_LLAVE_FORANEA_RUTA);
			}
		} else if (servicio.getId() == null || servicio.getId().getFechaInicio() == null
				|| servicio.getId().getFechaFin() == null
				|| servicio.getId().getFechaInicio().compareTo(servicio.getId().getFechaFin()) > 0) {
			if (servicio.getId() == null) {

				throw new ServiciosLogicException(ServiciosLogicException.NO_FECHAS);
			} else if (servicio.getId().getFechaInicio() == null) {
				throw new ServiciosLogicException(ServiciosLogicException.NO_FECHA_INICIO);
			} else if (servicio.getId().getFechaFin() == null) {
				throw new ServiciosLogicException(ServiciosLogicException.NO_FECHA_FIN);
			} else {
				throw new ServiciosLogicException(ServiciosLogicException.FECHA_INICIO_MAYOR_FECHA_FIN);
			}
		} else if (!busLibre(servicio)){
			throw new ServiciosLogicException(ServiciosLogicException.BUS_OCUPADO);
		} else if (!conductorLibre(servicio)){
			throw new ServiciosLogicException(ServiciosLogicException.CONDUCTOR_OCUPADO);
		} else {
			tMioServiciosDao.save(entityManager, servicio);
		}

	}
	
	@Override
	@Transactional(rollbackFor = ServiciosLogicException.class)
	public void deleteServicio(Tmio1Servicio servicio) throws ServiciosLogicException {
		if (servicio == null) {
			throw new ServiciosLogicException(ServiciosLogicException.NO_SERVICIO);
		} else if (servicio.getTmio1Bus() == null || servicio.getTmio1Bus().getId() == null
				|| tMioBusesDao.findById(entityManager, servicio.getTmio1Bus().getId()) == null) {
			if (servicio.getTmio1Bus() == null) {
				throw new ServiciosLogicException(ServiciosLogicException.NO_LLAVE_FORANEA_BUS);
			} else {
				throw new ServiciosLogicException(ServiciosLogicException.NO_EXISTE_LLAVE_FORANEA_BUS);
			}
		} else if (servicio.getTmio1Conductore() == null || servicio.getTmio1Conductore().getCedula() == null
				|| tMioConductoresDao.findByCedula(entityManager, servicio.getTmio1Conductore().getCedula()) == null) {
			if (servicio.getTmio1Conductore() == null) {
				throw new ServiciosLogicException(ServiciosLogicException.NO_LLAVE_FORANEA_CONDUCTOR);
			} else {
				throw new ServiciosLogicException(ServiciosLogicException.NO_EXISTE_LLAVE_FORANEA_CONDUCTOR);
			}
		} else if (servicio.getTmio1Ruta() == null || servicio.getTmio1Ruta().getId() == null
				|| tMioRutasDao.findById(entityManager, servicio.getTmio1Ruta().getId()) == null) {
			if (servicio.getTmio1Ruta() == null) {
				throw new ServiciosLogicException(ServiciosLogicException.NO_LLAVE_FORANEA_RUTA);
			} else {
				throw new ServiciosLogicException(ServiciosLogicException.NO_EXISTE_LLAVE_FORANEA_RUTA);
			}
		} else if (servicio.getId() == null || servicio.getId().getFechaInicio() == null
				|| servicio.getId().getFechaFin() == null
				|| servicio.getId().getFechaInicio().compareTo(servicio.getId().getFechaFin()) > 0) {
			if (servicio.getId() == null) {

				throw new ServiciosLogicException(ServiciosLogicException.NO_FECHAS);
			} else if (servicio.getId().getFechaInicio() == null) {
				throw new ServiciosLogicException(ServiciosLogicException.NO_FECHA_INICIO);
			} else if (servicio.getId().getFechaFin() == null) {
				throw new ServiciosLogicException(ServiciosLogicException.NO_FECHA_FIN);
			} else {
				throw new ServiciosLogicException(ServiciosLogicException.FECHA_INICIO_MAYOR_FECHA_FIN);
			}
		} else if (!busLibre(servicio)){
			throw new ServiciosLogicException(ServiciosLogicException.BUS_OCUPADO);
		} else if (!conductorLibre(servicio)){
			throw new ServiciosLogicException(ServiciosLogicException.CONDUCTOR_OCUPADO);
		} else {
			tMioServiciosDao.delete(entityManager, servicio);
		}
	}

	@Override
	@Transactional(rollbackFor = ServiciosLogicException.class)
	public void updateServicio(Tmio1Servicio servicio) throws ServiciosLogicException {
		if (servicio == null) {
			throw new ServiciosLogicException(ServiciosLogicException.NO_SERVICIO);
		} else if (servicio.getTmio1Bus() == null || servicio.getTmio1Bus().getId() == null
				|| tMioBusesDao.findById(entityManager, servicio.getTmio1Bus().getId()) == null) {
			if (servicio.getTmio1Bus() == null) {
				throw new ServiciosLogicException(ServiciosLogicException.NO_LLAVE_FORANEA_BUS);
			} else {
				throw new ServiciosLogicException(ServiciosLogicException.NO_EXISTE_LLAVE_FORANEA_BUS);
			}
		} else if (servicio.getTmio1Conductore() == null || servicio.getTmio1Conductore().getCedula() == null
				|| tMioConductoresDao.findByCedula(entityManager, servicio.getTmio1Conductore().getCedula()) == null) {
			if (servicio.getTmio1Conductore() == null) {
				throw new ServiciosLogicException(ServiciosLogicException.NO_LLAVE_FORANEA_CONDUCTOR);
			} else {
				throw new ServiciosLogicException(ServiciosLogicException.NO_EXISTE_LLAVE_FORANEA_CONDUCTOR);
			}
		} else if (servicio.getTmio1Ruta() == null || servicio.getTmio1Ruta().getId() == null
				|| tMioRutasDao.findById(entityManager, servicio.getTmio1Ruta().getId()) == null) {
			if (servicio.getTmio1Ruta() == null) {
				throw new ServiciosLogicException(ServiciosLogicException.NO_LLAVE_FORANEA_RUTA);
			} else {
				throw new ServiciosLogicException(ServiciosLogicException.NO_EXISTE_LLAVE_FORANEA_RUTA);
			}
		} else if (servicio.getId() == null || servicio.getId().getFechaInicio() == null
				|| servicio.getId().getFechaFin() == null
				|| servicio.getId().getFechaInicio().compareTo(servicio.getId().getFechaFin()) > 0) {
			if (servicio.getId() == null) {

				throw new ServiciosLogicException(ServiciosLogicException.NO_FECHAS);
			} else if (servicio.getId().getFechaInicio() == null) {
				throw new ServiciosLogicException(ServiciosLogicException.NO_FECHA_INICIO);
			} else if (servicio.getId().getFechaFin() == null) {
				throw new ServiciosLogicException(ServiciosLogicException.NO_FECHA_FIN);
			} else {
				throw new ServiciosLogicException(ServiciosLogicException.FECHA_INICIO_MAYOR_FECHA_FIN);
			}
		} else if (!busLibre(servicio)){
			throw new ServiciosLogicException(ServiciosLogicException.BUS_OCUPADO);
		} else if (!conductorLibre(servicio)){
			throw new ServiciosLogicException(ServiciosLogicException.CONDUCTOR_OCUPADO);
		} else {
			tMioServiciosDao.update(entityManager, servicio);
		}
	}

	@Override
	@Transactional(rollbackFor = ServiciosLogicException.class)
	public List<Tmio1Servicio> findServicioByRangeOfDates(Calendar fechaInicio, Calendar fechaFin) throws ServiciosLogicException{
		if (fechaInicio == null || fechaFin == null || fechaInicio.compareTo(fechaFin) > 0) {
			if (fechaInicio == null) {
				throw new ServiciosLogicException(ServiciosLogicException.NO_FECHA_INICIO);
			} else if (fechaFin == null) {
				throw new ServiciosLogicException(ServiciosLogicException.NO_FECHA_FIN);
			} else {
				throw new ServiciosLogicException(ServiciosLogicException.FECHA_INICIO_MAYOR_FECHA_FIN);
			}
		} else {
			return tMioServiciosDao.findByRangeOfDates(entityManager, fechaInicio, fechaFin);
		}
	}
	
	public boolean busLibre(Tmio1Servicio servicio) {
		
		Calendar fechaInicio = new GregorianCalendar(servicio.getId().getFechaInicio().getYear(), servicio.getId().getFechaInicio().getMonth(),servicio.getId().getFechaInicio().getDay());
		Calendar fechaFin = new GregorianCalendar(servicio.getId().getFechaFin().getYear(), servicio.getId().getFechaFin().getMonth(),servicio.getId().getFechaFin().getDay());
		try {
			List<Tmio1Servicio> servicios = tMioServiciosDao.findByCollitionDates(entityManager, fechaInicio, fechaFin);
			for (Tmio1Servicio s : servicios) {
				if (!s.getId().equals(servicio.getId()) && s.getTmio1Bus().getId() == servicio.getTmio1Bus().getId()) {
					return false;
				}
			}
			return true;
		} catch (Exception e) {
		}
		return false;
	}
	
	public boolean conductorLibre(Tmio1Servicio servicio) {
		
		Calendar fechaInicio = new GregorianCalendar(servicio.getId().getFechaInicio().getYear(), servicio.getId().getFechaInicio().getMonth(),servicio.getId().getFechaInicio().getDay());
		Calendar fechaFin = new GregorianCalendar(servicio.getId().getFechaFin().getYear(), servicio.getId().getFechaFin().getMonth(),servicio.getId().getFechaFin().getDay());
		try {
			List<Tmio1Servicio> servicios = tMioServiciosDao.findByCollitionDates(entityManager, fechaInicio, fechaFin);
			for (Tmio1Servicio s : servicios) {
				if (!s.getId().equals(servicio.getId()) && s.getTmio1Conductore().getCedula() == servicio.getTmio1Conductore().getCedula()) {
					return false;
				}
			}
			return true;
		} catch (Exception e) {
		}
		return false;
	}
	
}
