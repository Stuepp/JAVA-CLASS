package exceptions;

public class UnfollowException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnfollowException() {
		super("Falha ao deixar de seguir usuário");
	}
}
