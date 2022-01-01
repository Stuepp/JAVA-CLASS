package exceptions;

public class DeletePostException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DeletePostException() {
		super("Falha ao deletar post");
	}
}
