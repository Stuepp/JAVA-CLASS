package ex1;

import java.util.ArrayList;

public class Negocio {
	//Atributos
	private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	private ArrayList<Livro> livros = new ArrayList<Livro>();
	//Getters and Setters

	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	public ArrayList<Livro> getLivros() {
		return livros;
	}

	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}
	//métodos
	public void addPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}
	public void addLivro(Livro livro) {
		livros.add(livro);
	}
	public String mostraLivros(){
		String livro = "";
		for(int i = 0; i < livros.size(); i++) {
			livro += livros.get(i).toString();
			livro += "\n";
		}
		return livro;
	}
	public String mostraPessoas(){
		String pessoa = "";
		for(int i = 0; i < pessoas.size(); i++) {
			pessoa += pessoas.get(i).toString();
			pessoa += "\n";
		}
		return pessoa;
	}
	public String mostraSoAutores() {
		String autor = "";
		for(int i = 0; i < pessoas.size(); i++) {
			if((pessoas.get(i) instanceof Autor)) {
				autor += pessoas.get(i).toString();
				autor += "\n";
			}
		}
		return autor;		
	}
}
