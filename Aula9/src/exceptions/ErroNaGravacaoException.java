package exceptions;

public class ErroNaGravacaoException extends ErroArquivoExcpetion {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Construtor
	public ErroNaGravacaoException() {
		super("Erro durante a gravação do arquivo");
	}
}
