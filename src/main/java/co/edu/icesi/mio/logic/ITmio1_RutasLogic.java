package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;

import co.edu.icesi.mio.exceptions.RutasLogicException;
import co.edu.icesi.mio.model.Tmio1Ruta;

public interface ITmio1_RutasLogic {
	
	public void createRuta(Tmio1Ruta ruta)throws RutasLogicException;
	public void deleteRuta(Tmio1Ruta ruta)throws RutasLogicException;
	public void updateRuta(Tmio1Ruta ruta)throws RutasLogicException;
	public List<Tmio1Ruta> getRutasByRangeDays(BigDecimal begin, BigDecimal end)throws RutasLogicException;
	
}
