package exceptions;

public class LoginException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LoginException() {
		super("Falha ao logar, conferir c�digo e/ou senha");
	}
}
