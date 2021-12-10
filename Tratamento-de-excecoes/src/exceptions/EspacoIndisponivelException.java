package exceptions;

public class EspacoIndisponivelException extends Exception{
	private static final long serialVersionUID = 1L;	
	
	public EspacoIndisponivelException() {
		
	}
	public EspacoIndisponivelException(String msg) {
		super(msg);
	}
}
