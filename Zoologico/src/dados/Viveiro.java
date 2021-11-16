package dados;

import java.util.ArrayList;

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
	//métodos
	public float calculaEspaco() {
		return comprimento * largura;
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
	public boolean adicionarAnimal(Animal animal) {
		if(espacoDisponivel() >= (animal.calculaEspacoOcupado()*0.7)) {
			animais.add(animal);
			return true;
		}
		return false;
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
