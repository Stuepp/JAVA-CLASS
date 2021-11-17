package ex4;

import java.util.Scanner;

public class Main4 {
	private static Sorteador sorteador = new Sorteador();
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu = 0;
		while(menu == 0) {
			System.out.println("(1) cadastra pessoa\n(2) sorteia pessoa");
			int opcao = Integer.parseInt(s.nextLine());
			switch(opcao) {
				case 1:
					cadastrarPessoa();
					break;
				case 2:
					sortearPessoa();
					break;
				default:
					break;
			}
			System.out.println("Deseja continuar?\n(0) sim\n(1) não");
			menu = Integer.parseInt(s.nextLine());
		}
		s.close();
	}
	public static void cadastrarPessoa() {
		Pessoa p = new Pessoa();
		System.out.println("Digite o nome da pessoa:");
		p.setNome(s.nextLine());
		sorteador.cadastrarPessoa(p);
	}
	public static void sortearPessoa() {
		if(sorteador.sortearProximo() == null) {
			System.out.println("Lista vazia");
		}else {
			System.out.println(sorteador.sortearProximo().getNome());
		}
	}
}
