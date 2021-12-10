package exceptions;

public class TemperaturaInadequadaException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public TemperaturaInadequadaException() {
		
	}
	public TemperaturaInadequadaException(String msg) {
		super(msg);
	}
}
