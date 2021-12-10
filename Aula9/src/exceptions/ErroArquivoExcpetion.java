package exceptions;

public class ErroArquivoExcpetion extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Atributos
	private String caminho;
	//Construtor
	public ErroArquivoExcpetion(String msg) {
		super(msg);
	}
	//Getters and Setters
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
}
