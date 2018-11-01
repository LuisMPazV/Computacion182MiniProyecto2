package co.edu.icesi.mio.exceptions;

public class ConductoresLogicException extends Exception{
	
	
	public static final String CEDULA_NO_DEFINIDO="La cedula no esta definida";
	public static final String CEDULA_NO_NUMERICA="La cedula tiene caracteres diferentes a numeros";
	public static final String CONDUCTOR_NO_DEFINIDO="El conductor no esta definido";
	public static final String NOMBRE_NO_DEFINIDO="El nombre no esta definido";
	public static final String NOMBRE_LONGITUD_INVALIDA="El nombre no tiene mas de tres caracteres";
	public static final String APELLIDO_NO_DEFINIDO="El apellido no esta definido";
	public static final String APELLIDO_LONGITUD_INVALIDA="El apellido no tiene mas de tres caracteres";
	public static final String FECHA_NACIMIENTO_NO_DEFINIDA="La fecha de nacimiento no esta definida";
	public static final String NO_MAYOR_DE_EDAD="El conductor no es mayor de edad";
	public static final String FECHA_CONTRATACION_NO_DEFINIDA="La fecha de contratacion no esta definida";
	public static final String FECHA_CONTRATACION_INVALIDA="La fecha de contratacion es mayor a la fecha actual";
	
	
	
	public ConductoresLogicException(String msg) {
		super(msg);
	}

}
