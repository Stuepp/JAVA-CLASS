package ex1;

public class Livro {
	//Atributos
	private String nome,retirada, devolucao;
	private Autor autor;
	//Getters and Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRetirada() {
		return retirada;
	}
	public void setRetirada(String retirada) {
		this.retirada = retirada;
	}
	public String getDevolucao() {
		return devolucao;
	}
	public void setDevolucao(String devolucao) {
		this.devolucao = devolucao;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	//métodos
	public String toString() {
		return "---Livro---"
				+ "\nNome: "+nome
				+ "\nAutor: "+ autor.getNome()
				+ "\nData retirada: "+retirada
				+ "\nData para devolução: "+devolucao;
	}
}
