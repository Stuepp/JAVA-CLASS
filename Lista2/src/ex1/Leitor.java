package ex1;

public class Leitor extends Pessoa{
	@Override
	public String toString() {
		return "---Leitor---"
				+ "\nNome: " + super.getNome()
				+ "\n--Livros Retirados--\n" + mostraLivros();
				
	}
}
