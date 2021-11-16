package dados;

public class Cidade {
	//Atributos
	private String nome, estado;
	//Getters and Setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEstado() {
		return estado;
	}
	//toString
	public String toString() {
		return "------Cidade------\n"
				+ "Nome: "+ nome +"\n"
				+ "Estado: " + estado + "\n";
	}
}
