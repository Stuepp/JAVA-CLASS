package exceptions;

public class PostException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PostException() {
		super("Falha ao postar");
	}
}
