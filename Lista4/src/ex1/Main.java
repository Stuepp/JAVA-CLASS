package ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static ArrayList<Animal> a = new ArrayList<Animal>();
	private static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		int repet = 0;
		while(repet == 0) {
			menu();
			show();
			System.out.println("Deseja continuar?"
					+ "\n(0)sim (1)não");
			repet = Integer.parseInt(s.nextLine());
		}
	}
	public static void menu() {
		System.out.println("Escolha o tipo de animal"
				+ "\n(1) Cachorro"
				+ "\n(2) Gato"
				+ "\n(3) Passarinho");
		int escolha = Integer.parseInt(s.nextLine());
		switch(escolha) {
		case 1:
			Cachorro c = new Cachorro();
			System.out.println("Digite o nome do cachorro:");
			c.setNome(s.nextLine());
			a.add(c);
			break;
		case 2:
			Gato g = new Gato();
			System.out.println("Digite o nome do gato:");
			g.setNome(s.nextLine());
			a.add(g);
			break;
		case 3:
			Passarinho p = new Passarinho();
			System.out.println("Digite o nome do passarinho:");
			p.setNome(s.nextLine());
			a.add(p);
			break;
		default:
			break;
		}
	}
	public static void show() {
		for(int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i).emitirSom());
		}
	}
}
