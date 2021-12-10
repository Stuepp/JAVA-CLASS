package dados;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author Stuepp
 *
 */
public abstract class Gerador implements ISequencia{
	//Atributos
	private List<Integer> sequencia = new LinkedList<Integer>();
	//Get
	public List<Integer> getSequencia(){
		return this.sequencia;
	}
	//
	public abstract void gerar(int quantidade);
	//M�todos
	public int sortear() {
		final Random r = new Random();
		return sequencia.get(r.nextInt(sequencia.size()));
	}
	public long somatorio() {
		long soma = 0;
		for(final int x : sequencia) {
			soma += x;
		}
		return soma;
	}
	public long produtorio() {
		long produto = 1;
		for (final int x : sequencia) {
			produto += produto * x;
		}
		return produto;
	}
	public double mediaGeometrica() {
		return Math.pow(produtorio(), 1.0 / (double) (sequencia.size()));
	}
	public double mediaAritimetica() {
		return somatorio() / (double) (sequencia.size());
	}
	public double variancia() {
		final double media = mediaAritimetica();
		double soma = 0;
		for(final int x : sequencia) {
			soma += Math.pow(x - media, 2);
		}
		return soma / (double) (sequencia.size() -1);
	}
	public double desvioPadrao() {
		return Math.sqrt(variancia());
	}
	public int amplitude() {
		int maior = sequencia.get(0);
		int menor = sequencia.get(0);
		
		for(final int x : sequencia) {
			if(x > maior) {
				maior = x;
			}
			if(x < menor) {
				menor = x;
			}
		}
		return (maior - menor);
	}
}