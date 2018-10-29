package co.edu.icesi.mio.logic;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import co.edu.icesi.mio.exceptions.ServiciosLogicException;
import co.edu.icesi.mio.model.Tmio1Servicio;


public interface ITmio1_ServiciosLogic {

	public void createServicio(Tmio1Servicio servicio)throws ServiciosLogicException;
	public void deleteServicio(Tmio1Servicio servicio)throws ServiciosLogicException;
	public void updateServicio(Tmio1Servicio servicio)throws ServiciosLogicException;
	public List<Tmio1Servicio> findServicioByRangeOfDates(EntityManager em, Calendar fechaInicio, Calendar fechaFin)
}

