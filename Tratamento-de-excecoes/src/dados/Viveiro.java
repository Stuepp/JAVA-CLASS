package dados;

import java.util.ArrayList;

import exceptions.EspacoIndisponivelException;
import exceptions.EhPeixeException;

public class Viveiro {
	//Atributos
	protected String nome;
	protected float comprimento, largura;
	protected ArrayList<Animal> animais = new ArrayList<Animal>();
	//getters and setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getComprimento() {
		return comprimento;
	}
	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}
	public float getLargura() {
		return largura;
	}
	public void setLargura(float largura) {
		this.largura = largura;
	}
	//m�todos
	public float calculaEspaco() {
		return comprimento * largura;
	}
	public float larguraDisponivel() {
		float largura = 0;
		for(Animal a : animais) {
			largura += a.getLargura();
		}
		
		return largura;
	}
	public float comprimentoDisponivel() {
		float comprimento = 0;
		for(Animal a : animais) {
			comprimento += a.getComprimento();
		}
		return comprimento;
	}
	private float espacoOcupado() {
		float area = 0;
		for(int i = 0; i < animais.size(); i++) {
			area += animais.get(i).calculaEspacoOcupado();
		}
		return area;
	}
	public float espacoDisponivel() {
		return calculaEspaco() - espacoOcupado();
	}
	public void adicionarAnimal(Animal animal) throws EspacoIndisponivelException, EhPeixeException{
		if(!(animal instanceof Peixe)) {
			if(espacoDisponivel() >= (animal.calculaEspacoOcupado()*0.7)) {
				animais.add(animal);
			}else {
				throw new EspacoIndisponivelException("A espa�o insuficiente para o animal");
			}
		} else {
			throw new EhPeixeException("O animal � peixe e n�o pode ser alocado em um viveiro");
		}
	}
	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("Viveiro\n");
		string.append("Nome: "+nome+"\n");
		for(int i = 0; i < animais.size(); i++) {
			string.append("\t"+ animais.get(i).toString()+"\n");
		}
		return string.toString();
	}
}
