package exercicios.aula1;

import java.util.Scanner;

public class Ex2 {
	public static void main(String[]args) {
		String[] nomes = new String[5];
		int i = 0;
		Scanner s = new Scanner(System.in);
		
		while(i < 5) {
			System.out.println("Digite o nome "+(i+1)+"/5");
			nomes[i] = s.nextLine();
			i++;
		}
		System.out.println("Printand nomes");
		i = 4;
		while(i >= 0){
			System.out.println("Nome "+(i+1)+"/5");
			System.out.println(nomes[i]);
			i--;
		}
	}
}
