package exceptions;

public class FollowException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FollowException() {
		super("Falha ao seguir usuário");
	}
}
