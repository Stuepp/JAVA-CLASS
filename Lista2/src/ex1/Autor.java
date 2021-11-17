package ex1;

public class Autor extends Pessoa{
	public String livrosPublicados() {
		String livro = "";
		for(int i = 0; i < getLivros().size(); i++) {
			livro += getLivros().get(i).getNome();
			livro += "\n";
		}
		return livro;
	}
	@Override
	public String toString() {
		return "---Autor---"
				+ "\nNome: " + super.getNome()
				+ "\n--Livros Publicados--\n" + livrosPublicados();				
	}
}
