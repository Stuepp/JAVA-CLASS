package dados;

public class Endereco {
	private int id, numero, idPessoa;
	private String cidade, rua;
	
	public Endereco(int id, String rua, int numero, String cidade) {
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
	}
	public Endereco() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
}
