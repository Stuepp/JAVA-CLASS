package exceptions;

public class NaoEhPeixeException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public NaoEhPeixeException() {
		
	}
	public NaoEhPeixeException(String msg) {
		super(msg);
	}
}
