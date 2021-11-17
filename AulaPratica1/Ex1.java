package exercicios.aula1;

import java.util.Scanner;

public class Ex1 {
		
	public static void main(String[]args) {
		int[] valores = new int[5];
		int i = 0, media = 0;
		Scanner s = new Scanner(System.in);
		
		do {
			System.out.println("Digite o valor "+(i+1)+"/5  para suas médias serem calculadas");
			valores[i] = Integer.parseInt(s.nextLine());
			media += valores[i];
			i++;
		}while(i < 5);
		System.out.println("Média: " + media/valores.length);

	}
}
