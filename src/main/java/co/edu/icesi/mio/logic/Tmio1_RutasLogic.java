package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.mio.dao.ITmio1_Rutas_DAO;

import co.edu.icesi.mio.exceptions.RutasLogicException;
import co.edu.icesi.mio.model.Tmio1Ruta;

@Service
public class Tmio1_RutasLogic implements ITmio1_RutasLogic{

	
	@Autowired
	private ITmio1_Rutas_DAO tMioRutasDao;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void createRuta(Tmio1Ruta ruta) throws RutasLogicException {
		if(ruta==null) {
			throw new RutasLogicException(RutasLogicException.RUTA_NO_DEFINIDA);
		}else if(ruta.getNumero()==null||ruta.getNumero().length()!=3) {
			if(ruta.getNumero()==null) {
				throw new RutasLogicException(RutasLogicException.NO_NUMERO_RUTA);	
			}else {
				throw new RutasLogicException(RutasLogicException.NO_NUMERO_RUTA_TRES_CARACTERES);				
			}
		}else if(ruta.getDiaInicio()==null||ruta.getDiaInicio().compareTo(BigDecimal.valueOf(1))<0||ruta.getDiaInicio().compareTo(BigDecimal.valueOf(7))>0) {
			if(ruta.getDiaInicio()==null) {
				throw new RutasLogicException(RutasLogicException.DIA_INICIO_NO_NUMERO);
			}else {
				throw new RutasLogicException(RutasLogicException.DIA_INICIO_NO_VALIDO);
			}
		}else if(ruta.getDiaFin()==null||ruta.getDiaFin().compareTo(BigDecimal.valueOf(1))<0||ruta.getDiaFin().compareTo(BigDecimal.valueOf(7))>0) {
			if(ruta.getDiaFin()==null) {
				throw new RutasLogicException(RutasLogicException.DIA_FIN_NO_NUMERO);
			}else {
				throw new RutasLogicException(RutasLogicException.DIA_FIN_NO_VALIDO);
			}
		}else if(ruta.getDiaInicio().compareTo(ruta.getDiaFin())>0) {
			throw new RutasLogicException(RutasLogicException.DIA_INICIO_MAYOR_FIN);
		}else if(ruta.getHoraInicio()==null||ruta.getHoraInicio().compareTo(BigDecimal.valueOf(1))<0||ruta.getHoraInicio().compareTo(BigDecimal.valueOf(1440))>0) {
			if(ruta.getHoraInicio()==null) {
				throw new RutasLogicException(RutasLogicException.HORA_INICIO_NO_NUMERO);
			}else {
				throw new RutasLogicException(RutasLogicException.HORA_INICIO_NO_VALIDA);
			}
		}else if(ruta.getHoraFin()==null||ruta.getHoraFin().compareTo(BigDecimal.valueOf(1))<0||ruta.getHoraFin().compareTo(BigDecimal.valueOf(1440))>0) {
			if(ruta.getHoraFin()==null) {
				throw new RutasLogicException(RutasLogicException.HORA_FIN_NO_NUMERO);
			}else {
				throw new RutasLogicException(RutasLogicException.HORA_FIN_NO_VALIDA);
			}
		}else if(ruta.getHoraInicio().compareTo(ruta.getHoraFin())>0) {
			throw new RutasLogicException(RutasLogicException.HORA_INICIO_MAYOR_FIN);
		}else if(!ruta.getActiva().equals("S")||!ruta.getActiva().equals("N")) {
			throw new RutasLogicException(RutasLogicException.ACTIVA_NO_VALIDO);
		}else {
			tMioRutasDao.save(entityManager, ruta);
		}
		
		
	}

	@Override
	public void deleteRuta(Tmio1Ruta ruta) throws RutasLogicException {
		if(ruta==null) {
			throw new RutasLogicException(RutasLogicException.RUTA_NO_DEFINIDA);
		}else if(ruta.getNumero()==null||ruta.getNumero().length()!=3) {
			if(ruta.getNumero()==null) {
				throw new RutasLogicException(RutasLogicException.NO_NUMERO_RUTA);	
			}else {
				throw new RutasLogicException(RutasLogicException.NO_NUMERO_RUTA_TRES_CARACTERES);				
			}
		}else if(ruta.getDiaInicio()==null||ruta.getDiaInicio().compareTo(BigDecimal.valueOf(1))<0||ruta.getDiaInicio().compareTo(BigDecimal.valueOf(7))>0) {
			if(ruta.getDiaInicio()==null) {
				throw new RutasLogicException(RutasLogicException.DIA_INICIO_NO_NUMERO);
			}else {
				throw new RutasLogicException(RutasLogicException.DIA_INICIO_NO_VALIDO);
			}
		}else if(ruta.getDiaFin()==null||ruta.getDiaFin().compareTo(BigDecimal.valueOf(1))<0||ruta.getDiaFin().compareTo(BigDecimal.valueOf(7))>0) {
			if(ruta.getDiaFin()==null) {
				throw new RutasLogicException(RutasLogicException.DIA_FIN_NO_NUMERO);
			}else {
				throw new RutasLogicException(RutasLogicException.DIA_FIN_NO_VALIDO);
			}
		}else if(ruta.getDiaInicio().compareTo(ruta.getDiaFin())>0) {
			throw new RutasLogicException(RutasLogicException.DIA_INICIO_MAYOR_FIN);
		}else if(ruta.getHoraInicio()==null||ruta.getHoraInicio().compareTo(BigDecimal.valueOf(1))<0||ruta.getHoraInicio().compareTo(BigDecimal.valueOf(1440))>0) {
			if(ruta.getHoraInicio()==null) {
				throw new RutasLogicException(RutasLogicException.HORA_INICIO_NO_NUMERO);
			}else {
				throw new RutasLogicException(RutasLogicException.HORA_INICIO_NO_VALIDA);
			}
		}else if(ruta.getHoraFin()==null||ruta.getHoraFin().compareTo(BigDecimal.valueOf(1))<0||ruta.getHoraFin().compareTo(BigDecimal.valueOf(1440))>0) {
			if(ruta.getHoraFin()==null) {
				throw new RutasLogicException(RutasLogicException.HORA_FIN_NO_NUMERO);
			}else {
				throw new RutasLogicException(RutasLogicException.HORA_FIN_NO_VALIDA);
			}
		}else if(ruta.getHoraInicio().compareTo(ruta.getHoraFin())>0) {
			throw new RutasLogicException(RutasLogicException.HORA_INICIO_MAYOR_FIN);
		}else if(!ruta.getActiva().equals("S")||!ruta.getActiva().equals("N")) {
			throw new RutasLogicException(RutasLogicException.ACTIVA_NO_VALIDO);
		}else {
			tMioRutasDao.delete(entityManager, ruta);
		}
	}

	@Override
	public void updateRuta(Tmio1Ruta ruta) throws RutasLogicException {
		if(ruta==null) {
			throw new RutasLogicException(RutasLogicException.RUTA_NO_DEFINIDA);
		}else if(ruta.getNumero()==null||ruta.getNumero().length()!=3) {
			if(ruta.getNumero()==null) {
				throw new RutasLogicException(RutasLogicException.NO_NUMERO_RUTA);	
			}else {
				throw new RutasLogicException(RutasLogicException.NO_NUMERO_RUTA_TRES_CARACTERES);				
			}
		}else if(ruta.getDiaInicio()==null||ruta.getDiaInicio().compareTo(BigDecimal.valueOf(1))<0||ruta.getDiaInicio().compareTo(BigDecimal.valueOf(7))>0) {
			if(ruta.getDiaInicio()==null) {
				throw new RutasLogicException(RutasLogicException.DIA_INICIO_NO_NUMERO);
			}else {
				throw new RutasLogicException(RutasLogicException.DIA_INICIO_NO_VALIDO);
			}
		}else if(ruta.getDiaFin()==null||ruta.getDiaFin().compareTo(BigDecimal.valueOf(1))<0||ruta.getDiaFin().compareTo(BigDecimal.valueOf(7))>0) {
			if(ruta.getDiaFin()==null) {
				throw new RutasLogicException(RutasLogicException.DIA_FIN_NO_NUMERO);
			}else {
				throw new RutasLogicException(RutasLogicException.DIA_FIN_NO_VALIDO);
			}
		}else if(ruta.getDiaInicio().compareTo(ruta.getDiaFin())>0) {
			throw new RutasLogicException(RutasLogicException.DIA_INICIO_MAYOR_FIN);
		}else if(ruta.getHoraInicio()==null||ruta.getHoraInicio().compareTo(BigDecimal.valueOf(1))<0||ruta.getHoraInicio().compareTo(BigDecimal.valueOf(1440))>0) {
			if(ruta.getHoraInicio()==null) {
				throw new RutasLogicException(RutasLogicException.HORA_INICIO_NO_NUMERO);
			}else {
				throw new RutasLogicException(RutasLogicException.HORA_INICIO_NO_VALIDA);
			}
		}else if(ruta.getHoraFin()==null||ruta.getHoraFin().compareTo(BigDecimal.valueOf(1))<0||ruta.getHoraFin().compareTo(BigDecimal.valueOf(1440))>0) {
			if(ruta.getHoraFin()==null) {
				throw new RutasLogicException(RutasLogicException.HORA_FIN_NO_NUMERO);
			}else {
				throw new RutasLogicException(RutasLogicException.HORA_FIN_NO_VALIDA);
			}
		}else if(ruta.getHoraInicio().compareTo(ruta.getHoraFin())>0) {
			throw new RutasLogicException(RutasLogicException.HORA_INICIO_MAYOR_FIN);
		}else if(!ruta.getActiva().equals("S")||!ruta.getActiva().equals("N")) {
			throw new RutasLogicException(RutasLogicException.ACTIVA_NO_VALIDO);
		}else {
			tMioRutasDao.update(entityManager, ruta);
		}
	}

	@Override
	public List<Tmio1Ruta> getRutasByRangeDays(BigDecimal begin, BigDecimal end) throws RutasLogicException {
		if(begin==null||begin.compareTo(BigDecimal.valueOf(1))<0||begin.compareTo(BigDecimal.valueOf(7))>0) {
			if(begin==null) {
				throw new RutasLogicException(RutasLogicException.DIA_INICIO_NO_NUMERO);
			}else {
				throw new RutasLogicException(RutasLogicException.DIA_INICIO_NO_VALIDO);
			}
		}else if(end==null||end.compareTo(BigDecimal.valueOf(1))<0||end.compareTo(BigDecimal.valueOf(7))>0) {
			if(end==null) {
				throw new RutasLogicException(RutasLogicException.DIA_FIN_NO_NUMERO);
			}else {
				throw new RutasLogicException(RutasLogicException.DIA_FIN_NO_VALIDO);
			}
		}else if(begin.compareTo(end)>0) {
			throw new RutasLogicException(RutasLogicException.DIA_INICIO_MAYOR_FIN);
		}else {
			return tMioRutasDao.findByRangeOfDays(entityManager, begin, end);			
		}
	}

	
	


}
