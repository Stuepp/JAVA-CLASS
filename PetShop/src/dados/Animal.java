package dados;

public class Animal {
	//Atributos
	private String nome, especie, descricao;
	private Dono dono;
	//gettes and setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getEspecie() {
		return especie;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDono(Dono dono) {
		this.dono = dono;
	}
	public Dono getDono() {
		return dono;
	}
	//métodos
	public String toString() {
		return "Nome: "+nome+"\nEspecie: "+especie+"\nDescricao: "+ descricao
				+"\nDono: \n"+dono.toString();
	}
}
