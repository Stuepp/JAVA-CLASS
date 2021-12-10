package ex2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static Scanner s = new Scanner(System.in);
	private static ArrayList<FormaGeometrica> fg = new ArrayList<FormaGeometrica>();

	public static void main(String[] args) {
		int repet = 0;
		while(repet == 0) {
			menu();
			show();
			System.out.println("Deseja continuar?"
					+ "\n(0)Sim (1)Não");
			repet = Integer.parseInt(s.nextLine());
		}
	}
	public static void menu() {
		System.out.println("Qual forma geometrica deseja criar?"
				+ "\n(1) Trapézio"
				+ "\n(2) Losango"
				+ "\n(3) Circulo");
		int escolha = Integer.parseInt(s.nextLine());
		switch(escolha) {
			case 1:
				Trapezio t = new Trapezio();
				System.out.println("Digite a aultura:");
				t.setAltura(Integer.parseInt(s.nextLine()));
				System.out.println("Digite a base menor:");
				t.setBaseMenor(Integer.parseInt(s.nextLine()));
				System.out.println("Digite a base maior:");
				t.setBaseMaior(Integer.parseInt(s.nextLine()));
				System.out.println("Caso tenha os valores estejam invertidos eles foram corrigidos");
				if(t.getMedida1() < t.getMedida2()) {
					int temp = t.getMedida1();
					t.setBaseMaior(t.getMedida2());
					t.setBaseMenor(temp);
				}
				fg.add(t);
				break;
			case 2:
				Losango l = new Losango();
				System.out.println("Digite o diametro menor:");
				l.setd(Integer.parseInt(s.nextLine()));
				System.out.println("Digite o diametro maior:");
				l.setD(Integer.parseInt(s.nextLine()));
				System.out.println("Caso tenha os valores estejam invertidos eles foram corrigidos");
				if(l.getMedida1() < l.getMedida2()) {
					int temp = l.getMedida1();
					l.setD(l.getMedida2());
					l.setd(temp);
				}
				fg.add(l);
				break;
			case 3:
				Circulo c = new Circulo();
				System.out.println("Digite o raio do circulo:");
				c.setRaio(Integer.parseInt(s.nextLine()));
				System.out.println("Digite o diametro do circulo:");
				c.setMedida1(Integer.parseInt(s.nextLine()));
				fg.add(c);
				break;
			default:
				break;
		}
	}
	public static void show() {
		for(int i = 0; i < fg.size(); i++) {
			System.out.println(fg.get(i).toString());
		}
	}
}
