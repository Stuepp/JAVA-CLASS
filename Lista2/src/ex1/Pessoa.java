package ex1;

import java.util.ArrayList;

public class Pessoa {
	//Atributos
	private String nome;
	private ArrayList<Livro> livros = new ArrayList<Livro>();
	//Getters and Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Livro> getLivros() {
		return livros;
	}
	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}
	//métodos
	public void addLivro(Livro livro) {
		livros.add(livro);
	}
	public String mostraLivros() {
		String livro = "";
		for(int i = 0; i < livros.size(); i++) {
			livro += livros.get(i).toString();
			livro += "\n";
		}
		return livro;
	}
	public String toString() {

		return "---Pessoa---"
				+ "\nNome: "+nome
				+ "\n--Livros Retirados--\n"+ mostraLivros();
	}
}
