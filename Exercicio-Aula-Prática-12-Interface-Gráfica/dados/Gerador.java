package dados;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Stuepp
 *
 */
public abstract class Gerador {
	//atributos
	private List<Integer> sequencia = new LinkedList<Integer>();
	//métodos
	public List<Integer> getSequencia(){
		return this.sequencia;
	}
	public abstract void gerar(int quantidade);
}