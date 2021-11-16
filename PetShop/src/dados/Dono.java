package dados;

public class Dono {
	//Atributos
	private String nome;
	private Endereco endereco;
	private int cpf;
	//geters and setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getCpf() {
		return cpf;
	}
	//métodos
	public String toString() {
		return "Nome: "+nome+"\nEndereco do dono: \n"+endereco.toString() + "\nCPF: "+cpf+"\n";
	}
}
