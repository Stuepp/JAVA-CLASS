package dados;

public class Veterinario {
	//Atributos
	private String nome;
	private float salario;
	private Endereco endereco;
	private Animal animais[];
	private int qtdAnimais = 0, maxAnimais;
	//Construtor
	public Veterinario(int maxAnimais) {
		this.animais = new Animal[maxAnimais];
		this.maxAnimais = maxAnimais;
	}
	//gettes and setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public float getSalario() {
		return salario;
	}
	public int getMaxAnimais() {
		return maxAnimais;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setAnimal(Animal animal) {
		if(this.qtdAnimais < this.maxAnimais) {
			animais[this.qtdAnimais] = animal;
			this.qtdAnimais++;
		}
	}
	public Animal getAnimal(int i) {
		return animais[i];
	}
	//métodos
	public String toString() {
		String animaisQueCuida = null;
		for(int i = 0; i < maxAnimais; i++) {
			animaisQueCuida += animais[i].toString();
		}
		return "Nome: "+nome+"\nSalario: "+salario +"\nEndereco: \n"+endereco.toString()
			+"\nAnimais que cuida: \n" + animaisQueCuida + "\n";
	}
}
