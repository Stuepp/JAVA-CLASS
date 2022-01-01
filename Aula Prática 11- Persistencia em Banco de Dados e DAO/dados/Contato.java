package dados;

public class Contato {
	//Atributos
	private String nome;
	private int telefone,id;
	
	public Contato(int id, String nome, int telefone) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
	}
	//Getters and Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//equals
	public boolean esquals(Object o) {
		if(o instanceof Contato) {
			Contato c = (Contato) o;
			if(this.telefone == c.getTelefone()) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
}
