package exceptions;

public class DeleteUserException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public DeleteUserException() {
		super("Falha ao deletar usuário");
	}
}
