package ex1;

public class Pessoa {
	//Atributos
	private String nome, cidade;
	private int idade, cpf;
	//Getters and Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	//
	public String toString() {
		return "- "+nome +", "+ idade +", " + cpf + ", "+cidade;
	}
	public boolean equals(Object o) {
		if(o instanceof Pessoa) {
			Pessoa p = (Pessoa) o;
			if(this.nome == p.getNome()) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
}
