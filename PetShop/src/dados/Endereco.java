package dados;

public class Endereco {
	//Atributos
	private String rua, bairro, cidade, estado;
	private int numero, cep;
	//geters and setters
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getRua() {
		return rua;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCidade() {
		return cidade;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEstado() {
		return estado;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getNumero() {
		return numero;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public int getCep() {
		return cep;
	}
	//métodos
	public String toString() {
		return "Estado: "+estado+"\nCidade: "+cidade+"\nBairro: "+bairro+"\nRua: "+rua
				+"\nNúmero: "+numero+"\nCEP: "+ cep+"\n";
	}
}
