package ex3;

import java.util.Scanner;

public class Main {
	private static Scanner s = new Scanner(System.in);
	private static Digrafo d = new Digrafo();
	private static Grafo g = new Grafo();

	public static void main(String[] args) {
		int repet = 0;
		matriz();
		while(repet == 0) {
			System.out.println("---Digrafo---");
			System.out.print(d.toString());
			System.out.println("---Grafo---");
			System.out.print(g.toString());
			relacao();
			System.out.println("---Digrafo---");
			System.out.print(d.toString());
			System.out.println("---Grafo---");
			System.out.print(g.toString());
			System.out.println("Deseja continuar?"
					+ "\n(0)Sim (1)Não");
			repet = Integer.parseInt(s.nextLine());
		}
	}
	public static void matriz() {
		System.out.println("Quantos estados tem o digrafo?");
		int Nelementos = Integer.parseInt(s.nextLine());
		int contador = 0;
		while(contador < Nelementos) {
			d.adicionarVertice();
			g.adicionarVertice();
			contador++;
		}
	}
	public static void relacao() {
		System.out.println("Deseja adicionar uma relação?"
				+ "\n(0)Sim (1)Não");
		int escolha = Integer.parseInt(s.nextLine());
		switch(escolha) {
			case 0:
				System.out.println("Digite a origem");
				int origem = Integer.parseInt(s.nextLine());
				System.out.println("Digite o destino");
				int destino = Integer.parseInt(s.nextLine());
				d.adicionarAresta(origem, destino);
				g.adicionarAresta(origem, destino);
				break;
			case 1:
				break;
			default:
				break;
		}
	}
}
