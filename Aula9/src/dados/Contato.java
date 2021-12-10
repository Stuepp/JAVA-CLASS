package dados;

public class Contato {
	//Atributos
	private String nome;
	private int telefone;
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
	//equals - sempre esqueço como fazer essa merda
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
