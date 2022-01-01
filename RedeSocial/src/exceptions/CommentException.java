package exceptions;

public class CommentException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommentException() {
		super("Falha ao comentar");
	}
}
