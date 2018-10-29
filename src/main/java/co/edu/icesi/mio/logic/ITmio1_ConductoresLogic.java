package co.edu.icesi.mio.logic;

import java.util.List;

import co.edu.icesi.mio.exceptions.ConductoresLogicException;
import co.edu.icesi.mio.model.Tmio1Conductore;

public interface ITmio1_ConductoresLogic {
	
	
	public void createConductor(Tmio1Conductore conductor)throws ConductoresLogicException;
	public void deleteConductor(Tmio1Conductore conductor)throws ConductoresLogicException;
	public void updateConductor(Tmio1Conductore conductor)throws ConductoresLogicException;
	public Tmio1Conductore findConductorByCedula(String cedula)throws ConductoresLogicException;
	public List<Tmio1Conductore> findConductorByNombre(String nombre)throws ConductoresLogicException;
	public List<Tmio1Conductore> findConductorByApellido(String apellido)throws ConductoresLogicException;
	

}
