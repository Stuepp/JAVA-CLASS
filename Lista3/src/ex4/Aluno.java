package ex4;

import java.util.ArrayList;

public class Aluno {
	private String nome;
	private int idade;
	private ArrayList<Float> notas = new ArrayList<Float>();
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public ArrayList<Float> getNotas() {
		return notas;
	}
	public void setNotas(ArrayList<Float> notas) {
		this.notas = notas;
	}
	public void addNota(Float nota) {
		this.notas.add(nota);
	}
	public String toString() {
		String snotas = "";
		for(int i = 0; i < notas.size(); i++) {
			snotas += notas.get(i)+" ";
		}
		return "Nome: "+nome
				+"\nIdade: "+idade
				+"\nNotas: "+snotas;
	}
}
