package ex1;

public abstract class Animal {
	//Atributos
	private String nome;
	//Getters and Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	//M�todo
	public abstract String emitirSom();
}
