package exceptions;

public class ErroNaLeituraException extends ErroArquivoExcpetion {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Construtor
	public ErroNaLeituraException() {
		super("Erro durante a leitura do arquivo");
	}
}
