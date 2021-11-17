package ex1;

import java.util.Scanner;

public class Main1 {

	private static Scanner s = new Scanner(System.in);
	private static Negocio n = new Negocio();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu = 0;
		while(menu == 0) {
			System.out.println("(1) cadastra livro\n(2) cadastra pessoa"
					+ "\n(3) mostra livors\n(4) mostra pessoas\n(5) retirar livro");
			int opcao = Integer.parseInt(s.nextLine());
			switch(opcao) {
				case 1:
					cadastraLivro();
					break;
				case 2:
					cadastraPessoa();
					break;
				case 3:
					mostraLivros();
					break;
				case 4:
					mostraPessoas();
					break;
				case 5:
					retirarLivro();
				default:
					break;
			}
			System.out.println("Deseja continuar?"
					+ "\n(0) sim\n(1) não");
			menu = Integer.parseInt(s.nextLine());
		}
	}
	public static void cadastraLivro() {
		Livro livro = new Livro();
		Autor autor = new Autor();
		System.out.println("Digite o nome do livro:");
		livro.setNome(s.nextLine());
		if(mostraAutores() == "") {
			System.out.println("Digite o nome do autor:");
			autor.setNome(s.nextLine());
			autor.addLivro(livro);
			livro.setAutor(autor);
			n.addLivro(livro);
			n.addPessoa(autor);	
		}else if(mostraAutores() != null) {
			System.out.println(mostraAutores());
			System.out.println("Digite o nome do autor:");
			String nome = s.nextLine();
			for(int i = 0; i < n.getPessoas().size(); i++) {
				if(n.getPessoas().get(i).getNome().equals(nome)) {
					autor = (Autor) n.getPessoas().get(i);
					autor.addLivro(livro);
					livro.setAutor(autor);
					n.addLivro(livro);
					n.addPessoa(autor);
					i = n.getPessoas().size();
				}
			}
		}
	}
	public static void cadastraPessoa() {
		Autor autor = new Autor();
		Leitor leitor = new Leitor();
		System.out.println("Deseja cadastrar um autor ou leitor?"
				+ "\n(1) autor\n(2) leitor");
		int opcao = Integer.parseInt(s.nextLine());
		if(opcao == 1) {
			System.out.println("Digite o nome do autor:");
			autor.setNome(s.nextLine());
			n.addPessoa(autor);
		}
		if(opcao == 2) {
			System.out.println("Digite o nome do leitor:");
			leitor.setNome(s.nextLine());
			n.addPessoa(leitor);
		}
	}
	public static void mostraLivros() {
		System.out.println(n.mostraLivros());
	}
	public static void mostraPessoas() {
		System.out.println(n.mostraPessoas());
	}
	public static String mostraAutores() {
		return n.mostraSoAutores();
	}
	public static void retirarLivro() {
		System.out.println("Quem vai retirar o livro?");
		mostraPessoas();
		System.out.println("Digite o nome da pessoa:");
		String pessoa = s.nextLine();
		for(int i = 0; i < n.getPessoas().size(); i++) {
			if(n.getPessoas().get(i).getNome().equals(pessoa)) {
				mostraLivros();
				System.out.println("Digite o nome do livro que deseja retirar:");
				String livro = s.nextLine();
				for(int j = 0; j < n.getLivros().size(); j++) {
					if(n.getLivros().get(j).getNome().equals(livro)) {
						System.out.println("Digite a data de retirada:"
								+ "\n dd/mm/aaaa");
						n.getLivros().get(j).setRetirada(s.nextLine());
						System.out.println("Digite a data para devolução:"
								+ "\ndd/mm/aaaa");
						n.getLivros().get(j).setDevolucao(s.nextLine());		

						n.getPessoas().get(i).addLivro(n.getLivros().get(j));
					}
				}
			}
		}
		
		
	}
}
