package apresentacao;

import negocio.ListaTelefonica;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import dados.Contato;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;

public class Main {
	private static Scanner s = new Scanner(System.in);
	private static ListaTelefonica lt;
	private static String senha = "insira_sua_senha_aqui";
	public static void main(String[] args) throws ClassNotFoundException, SelectException, InsertException, NumberFormatException, DeleteException {
		try {
			 lt = new ListaTelefonica(senha);
		}catch(SQLException e) {
			System.out.println("Falha ao iniciar");
			e.printStackTrace();
			System.exit(0);
		}
		int menu = 0;
		while(menu == 0) {
			System.out.println("(1) adicionar contato"
					+ "\n(2) remover contato"
					+ "\n(3) exibir todos contatos"
					+ "\n(4) exibir contatos de X inicial");
			int opcao = Integer.parseInt(s.nextLine());
			switch(opcao) {
				case 1:
					adicionarContato();
					break;
				case 2:
					removerContato();
					break;
				case 3:
					exibirContatos();
					break;
				case 4:
					System.out.println("Digite a inicial que deseja pesquisar:");
					String str = s.nextLine();
					char letra = str.charAt(0);
					exibirContatos(letra);
					break;
				default:
					break;
			}			
			
			System.out.println("Deseja continuar"
					+ "\n(0)Sim\n(1)Não");
			menu = Integer.parseInt(s.nextLine());
		}

	}
	public static Contato novoContato() {
		Contato contato = new Contato(0, null, 0);
		System.out.println("Digite o nome do contato:");
		contato.setNome(s.nextLine());
		System.out.println("Digite o número do contato:");
		contato.setTelefone(Integer.parseInt(s.nextLine()));
		
		return contato;
	}
	public static void adicionarContato() throws InsertException, SelectException {
		lt.adicionarContato(novoContato());
	}
	public static void removerContato() throws NumberFormatException, SelectException, DeleteException {
		System.out.println("Digite o a inicial do contato que deseja remover:");
		String str = s.nextLine();
		char letra = str.charAt(0);
		if(lt.buscarContatos(letra).size() > 0) {
			exibirContatos(letra);
			System.out.println("Digite o contato que deseja remover:"
					+ "\nex: 1/2/3...");
			int contatoAremover = Integer.parseInt(s.nextLine());
			if(contatoAremover >= lt.buscarContatos(letra).size()) {
				System.out.println("Tal contato não existe");
			}else {
				lt.removerContato(lt.buscarContatos(letra).get(contatoAremover));
			}
		}else {
			System.out.println("Lista de inicial :"+letra+" é vazia");
		}
		
	}
	public static void exibirContatos() throws SelectException {
		for(int i = 65; i <= 90; i++) {
			char letra = (char) i;
			if(lt.buscarContatos().get(letra).size() > 0) {
				System.out.println(letra+":");
				for(int j = 0; j < lt.buscarContatos().get(letra).size(); j++) {
					System.out.println("\t"+lt.buscarContatos().get(letra).get(j).getNome()+":"+lt.buscarContatos().get(letra).get(j).getTelefone());
				}
			}else {
				System.out.println(letra+":"
						+ "---");
			}
		}
	}
	public static void exibirContatos(char letra) throws SelectException {
		System.out.println(Character.toUpperCase(letra)+":");
		
		for(int i = 0; i < lt.buscarContatos(letra).size(); i++) {
			System.out.println("("+i+")\t"+lt.buscarContatos(letra).get(i).getNome()+":"+lt.buscarContatos(letra).get(i).getTelefone());
		}
	}
}
