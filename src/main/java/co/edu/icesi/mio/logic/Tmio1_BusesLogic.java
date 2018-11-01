package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.mio.dao.ITmio1_Buses_DAO;
import co.edu.icesi.mio.dao.Tmio1_Buses_DAO;
import co.edu.icesi.mio.exceptions.BusesLogicException;
import co.edu.icesi.mio.exceptions.RutasLogicException;
import co.edu.icesi.mio.model.Tmio1Bus;

@Service
public class Tmio1_BusesLogic implements ITmio1_BusesLogic{

	@Autowired
	private ITmio1_Buses_DAO tMioBusesDao;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(rollbackFor = BusesLogicException.class)
	public void createBus(Tmio1Bus bus) throws BusesLogicException {
		if(bus==null) {
			throw new BusesLogicException(BusesLogicException.BUS_NO_DEFINIDO);
		}else if(bus.getPlaca()==null||bus.getPlaca().length()!=6) {
			if(bus.getPlaca()==null) {
				throw new BusesLogicException(BusesLogicException.NO_PLACA);
			}else {
				throw new BusesLogicException(BusesLogicException.NO_PLACA_SEIS_CARACTERES);
			}
		}else if(bus.getMarca()==null||bus.getMarca().length()<3) {
			if(bus.getMarca()==null) {
				throw new BusesLogicException(BusesLogicException.NO_MARCA);
			}else {
				throw new BusesLogicException(BusesLogicException.NO_MARCA_TRES_CARACTERES);
			}
		}else if(bus.getModelo()==null||bus.getModelo().toString().length()!=4) {
			if(bus.getModelo()==null) {
				throw new BusesLogicException(BusesLogicException.NO_MODELO_NUMERICO);
			}else {
				throw new BusesLogicException(BusesLogicException.NO_MODELO_CUATRO_CARACTERES);
			}
		}else if(bus.getTipo()==null||!bus.getTipo().equals("P")||!bus.getTipo().equals("A")||!bus.getTipo().equals("T")) {
			if(bus.getTipo()==null) {
				throw new BusesLogicException(BusesLogicException.TIPO_NO_DEFINIDA);
			}else {
				throw new BusesLogicException(BusesLogicException.TIPO_NO_VALIDO);
			}
		}else if(bus.getCapacidad()==null||bus.getCapacidad().compareTo(BigDecimal.valueOf(0))<=0) {
			if(bus.getCapacidad()==null) {
				throw new BusesLogicException(BusesLogicException.CAPACIDAD_NO_DEFINIDA);
			}else {
				throw new BusesLogicException(BusesLogicException.CAPACIDAD_NO_VALIDA);
			}
		}else {
			tMioBusesDao.save(entityManager, bus);
		}
		
	}

	@Override
	@Transactional(rollbackFor = BusesLogicException.class)
	public void deleteBus(Tmio1Bus bus) throws BusesLogicException {
		if(bus==null) {
			throw new BusesLogicException(BusesLogicException.BUS_NO_DEFINIDO);
		}else if(bus.getPlaca()==null||bus.getPlaca().length()!=6) {
			if(bus.getPlaca()==null) {
				throw new BusesLogicException(BusesLogicException.NO_PLACA);
			}else {
				throw new BusesLogicException(BusesLogicException.NO_PLACA_SEIS_CARACTERES);
			}
		}else if(bus.getMarca()==null||bus.getMarca().length()<3) {
			if(bus.getMarca()==null) {
				throw new BusesLogicException(BusesLogicException.NO_MARCA);
			}else {
				throw new BusesLogicException(BusesLogicException.NO_MARCA_TRES_CARACTERES);
			}
		}else if(bus.getModelo()==null||bus.getModelo().toString().length()!=4) {
			if(bus.getModelo()==null) {
				throw new BusesLogicException(BusesLogicException.NO_MODELO_NUMERICO);
			}else {
				throw new BusesLogicException(BusesLogicException.NO_MODELO_CUATRO_CARACTERES);
			}
		}else if(bus.getTipo()==null||!bus.getTipo().equals("P")||!bus.getTipo().equals("A")||!bus.getTipo().equals("T")) {
			if(bus.getTipo()==null) {
				throw new BusesLogicException(BusesLogicException.TIPO_NO_DEFINIDA);
			}else {
				throw new BusesLogicException(BusesLogicException.TIPO_NO_VALIDO);
			}
		}else if(bus.getCapacidad()==null||bus.getCapacidad().compareTo(BigDecimal.valueOf(0))<=0) {
			if(bus.getCapacidad()==null) {
				throw new BusesLogicException(BusesLogicException.CAPACIDAD_NO_DEFINIDA);
			}else {
				throw new BusesLogicException(BusesLogicException.CAPACIDAD_NO_VALIDA);
			}
		}else {
			tMioBusesDao.delete(entityManager, bus);
		}
		
	}

	@Override
	@Transactional(rollbackFor = BusesLogicException.class)
	public void updateBus(Tmio1Bus bus) throws BusesLogicException {
		if(bus==null) {
			throw new BusesLogicException(BusesLogicException.BUS_NO_DEFINIDO);
		}else if(bus.getPlaca()==null||bus.getPlaca().length()!=6) {
			if(bus.getPlaca()==null) {
				throw new BusesLogicException(BusesLogicException.NO_PLACA);
			}else {
				throw new BusesLogicException(BusesLogicException.NO_PLACA_SEIS_CARACTERES);
			}
		}else if(bus.getMarca()==null||bus.getMarca().length()<3) {
			if(bus.getMarca()==null) {
				throw new BusesLogicException(BusesLogicException.NO_MARCA);
			}else {
				throw new BusesLogicException(BusesLogicException.NO_MARCA_TRES_CARACTERES);
			}
		}else if(bus.getModelo()==null||bus.getModelo().toString().length()!=4) {
			if(bus.getModelo()==null) {
				throw new BusesLogicException(BusesLogicException.NO_MODELO_NUMERICO);
			}else {
				throw new BusesLogicException(BusesLogicException.NO_MODELO_CUATRO_CARACTERES);
			}
		}else if(bus.getTipo()==null||!bus.getTipo().equals("P")||!bus.getTipo().equals("A")||!bus.getTipo().equals("T")) {
			if(bus.getTipo()==null) {
				throw new BusesLogicException(BusesLogicException.TIPO_NO_DEFINIDA);
			}else {
				throw new BusesLogicException(BusesLogicException.TIPO_NO_VALIDO);
			}
		}else if(bus.getCapacidad()==null||bus.getCapacidad().compareTo(BigDecimal.valueOf(0))<=0) {
			if(bus.getCapacidad()==null) {
				throw new BusesLogicException(BusesLogicException.CAPACIDAD_NO_DEFINIDA);
			}else {
				throw new BusesLogicException(BusesLogicException.CAPACIDAD_NO_VALIDA);
			}
		}else {
			tMioBusesDao.update(entityManager, bus);
		}
	}

	@Override
	@Transactional(rollbackFor = BusesLogicException.class)
	public List<Tmio1Bus> findBusByModelo(BigDecimal modelo) throws BusesLogicException {
		if(modelo==null||modelo.toString().length()!=4) {
			if(modelo==null) {
				throw new BusesLogicException(BusesLogicException.NO_MODELO_NUMERICO);
			}else {
				throw new BusesLogicException(BusesLogicException.NO_MODELO_CUATRO_CARACTERES);
			}
		}else {
			return tMioBusesDao.findByModel(entityManager, modelo);			
		}
	}

	@Override
	@Transactional(rollbackFor = BusesLogicException.class)
	public List<Tmio1Bus> findBusByTipo(String tipo) throws BusesLogicException {
		if(tipo==null||!tipo.equals("P")||!tipo.equals("A")||!tipo.equals("T")) {
			if(tipo==null) {
				throw new BusesLogicException(BusesLogicException.TIPO_NO_DEFINIDA);
			}else {
				throw new BusesLogicException(BusesLogicException.TIPO_NO_VALIDO);
			}
		}else {
			return tMioBusesDao.findByType(entityManager, tipo);
		}
	}

	@Override
	@Transactional(rollbackFor = BusesLogicException.class)
	public List<Tmio1Bus> findBusByCapacidad(BigDecimal capacidad) throws BusesLogicException {
		if(capacidad==null||capacidad.compareTo(BigDecimal.valueOf(0))<=0) {
			if(capacidad==null) {
				throw new BusesLogicException(BusesLogicException.CAPACIDAD_NO_DEFINIDA);
			}else {
				throw new BusesLogicException(BusesLogicException.CAPACIDAD_NO_VALIDA);
			}
		}else {
			return tMioBusesDao.findByCapacity(entityManager, capacidad);			
		}
	}
	
	
	

}
