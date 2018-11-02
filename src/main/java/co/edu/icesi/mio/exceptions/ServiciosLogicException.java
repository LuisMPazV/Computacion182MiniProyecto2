package co.edu.icesi.mio.exceptions;

public class ServiciosLogicException extends Exception{

	
	public static final String NO_SERVICIO="El servicio no esta definido.";
	public static final String NO_LLAVE_FORANEA_BUS="La llave foranea del bus no esta definida.";
	public static final String NO_LLAVE_FORANEA_RUTA="La llave foranea de la ruta no esta definida.";
	public static final String NO_LLAVE_FORANEA_CONDUCTOR="La llave foranea del conductor no esta definida";
	public static final String NO_EXISTE_LLAVE_FORANEA_BUS="La llave foranea del bus no existe.";
	public static final String NO_EXISTE_LLAVE_FORANEA_RUTA="La llave foranea de la ruta no existe.";
	public static final String NO_EXISTE_LLAVE_FORANEA_CONDUCTOR="La llave foranea del conductor no existe.";
	public static final String NO_FECHAS="Las fechas no estan definidas.";
	public static final String NO_FECHA_INICIO="La fecha de inicio no esta definida.";
	public static final String NO_FECHA_FIN="La fecha de fin no esta definida.";
	public static final String FECHA_INICIO_MAYOR_FECHA_FIN="La fecha de inicio es mayor a la fecha de fin.";
	public static final String BUS_OCUPADO="El bus designado para el servicio ya esta ocupado en las fechas que se prentende dar el servicio.";
	public static final String CONDUCTOR_OCUPADO="El conductor designado para el servicio ya esta ocupado en las fechas que se prentende dar el servicio.";
	
	public static final String CONDUCTOR_NO_PUEDE_SER_ACTUALIZADO="El servicio no puede ser actualizado por que no existe.";
	
	
	
	public ServiciosLogicException(String msg) {
		super(msg);
	}
}
