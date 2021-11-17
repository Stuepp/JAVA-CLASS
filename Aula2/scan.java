package aula02;

import java.util.Random;
import java.util.Scanner;

public class scan {
	public static void main(String[]args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite seu nome:");
		String nome = s.nextLine();
		System.out.println("Nome inserido: " + nome);
		if(nome.equals("Arthur")) {
			System.out.println("Nome perfeito");
		}
		Random rand = new Random();
		System.out.println("Sou um n�mero pseudo aleat�rio: "+ rand.nextInt());
	}
}
