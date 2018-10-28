package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;

import co.edu.icesi.mio.exceptions.BusesLogicException;
import co.edu.icesi.mio.model.Tmio1Bus;

public interface ITmio1_BusesLogic {

	public void createBus(Tmio1Bus bus)throws BusesLogicException;
	public void deleteBus(Tmio1Bus bus)throws BusesLogicException;
	public void updateBus(Tmio1Bus bus)throws BusesLogicException;
	public List<Tmio1Bus> findBusByModelo(BigDecimal modelo)throws BusesLogicException;
	public List<Tmio1Bus> findBusByTipo(String tipo)throws BusesLogicException;
	public List<Tmio1Bus> findBusByCapacidad(BigDecimal capacidad)throws BusesLogicException;
}
