package exceptions;

public class SearchUserException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchUserException() {
		super("Falha ao procurar por usuário");
	}
}
