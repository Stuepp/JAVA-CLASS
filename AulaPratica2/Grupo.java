package exercicio1.aula2.dados;

public class Grupo {
	//Atributos
	private Pessoa pessoas[];
	private int nPessoas = 0;
	private int maxPessoas;
	//Construtor
	Grupo(int npessoas){
		pessoas = new Pessoa[npessoas];
		this.maxPessoas = npessoas;
	}
	//Métodos
	public void setPessoa(Pessoa p) {
		if(this.nPessoas < this.maxPessoas) {
			pessoas[this.nPessoas] = p;
			this.nPessoas++;			
		}
	}
	public Pessoa getPessoa(int i) {
		return pessoas[i];
	}
	public Pessoa ordem_decrescente(Pessoa pessoas[]) {
		return pessoas[0];
	}
}
