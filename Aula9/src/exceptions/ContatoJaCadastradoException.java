package exceptions;

public class ContatoJaCadastradoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Contrutor
	public ContatoJaCadastradoException() {
		super("Contato já cadastrado");
	}
}
