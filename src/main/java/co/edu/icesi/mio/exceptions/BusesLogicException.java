package co.edu.icesi.mio.exceptions;

public class BusesLogicException extends Exception{

	public static final String BUS_NO_DEFINIDO="El bus no esta definido.";
	public static final String NO_PLACA="La placa no esta definida.";
	public static final String NO_PLACA_SEIS_CARACTERES="La placa no tiene seis caracteres.";
	public static final String NO_MARCA="La marca no esta definida.";
	public static final String NO_MARCA_TRES_CARACTERES="La marca no tiene al menos tres caracteres.";
	public static final String NO_MODELO_NUMERICO="La modelo no es un numero.";
	public static final String NO_MODELO_CUATRO_CARACTERES="El modelo no tiene cuatro digitos.";
	public static final String TIPO_NO_DEFINIDA="El tipo de bus no esta definido.";
	public static final String CAPACIDAD_NO_DEFINIDA="La capacidad del bus no esta definida.";
	
	public static final String TIPO_NO_VALIDO="El tipo de bus no es valido.";
	public static final String CAPACIDAD_NO_VALIDA="La capacidad del bus no es valida(Mayor a 0).";
	
	public BusesLogicException(String msg) {
		super(msg);
	}
}
