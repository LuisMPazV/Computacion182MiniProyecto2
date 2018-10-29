package co.edu.icesi.mio.exceptions;

public class RutasLogicException extends Exception{

	
	public static final String NO_NUMERO_RUTA="El numero de ruta no esta definido.";
	public static final String NO_NUMERO_RUTA_TRES_CARACTERES="El numero de ruta no tiene tres caracteres.";
	public static final String DIA_INICIO_NO_NUMERO="El dia de inicio no es un numero.";
	public static final String DIA_FIN_NO_NUMERO="El dia de fin no es un numero.";
	public static final String DIA_INICIO_NO_VALIDO="El dia de inicio no esta entre 1 y 7.";
	public static final String DIA_FIN_NO_VALIDO="El dia de fin no esta entre 1 y 7.";
	public static final String DIA_INICIO_MAYOR_FIN="El dia de inicio es mayor al dia de fin.";
	public static final String HORA_INICIO_NO_NUMERO="La hora de inicio no es un numero.";
	public static final String HORA_FIN_NO_NUMERO="La hora de fin no es un numero.";
	public static final String HORA_INICIO_NO_VALIDA="La hora de inicio no esta entre 1 y 1440.";
	public static final String HORA_FIN_NO_VALIDA="La hora de fin no esta entre 1 y 1440.";
	public static final String HORA_INICIO_MAYOR_FIN="La hora de inicio es mayor a la hora de fin.";
	public static final String ACTIVA_NO_VALIDO="El estado de actividad no es valido.";
	public static final String RUTA_NO_DEFINIDA="La ruta no esta definida.";
	private String msg;
	
	public RutasLogicException(String msg) {
		super();
		this.msg=msg;
	}
}
