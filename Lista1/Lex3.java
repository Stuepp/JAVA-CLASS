package lista1.exercicios;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;


public class Lex3 {
	
	public static int buscaMaior(int vetor[], int maiorAtual, int indice) {
		if(indice > vetor.length-1) {
			return maiorAtual;
		}
		if(maiorAtual > vetor[indice]) {
			indice++;
			maiorAtual = buscaMaior(vetor, maiorAtual, indice);
			return maiorAtual;
		}
		if(maiorAtual < vetor[indice]) {
			maiorAtual = vetor[indice];
			indice++;
			maiorAtual = buscaMaior(vetor, maiorAtual, indice);
			return maiorAtual;
		}
		if(maiorAtual == vetor[indice]) {
			indice++;
			maiorAtual = buscaMaior(vetor, maiorAtual, indice);
			return maiorAtual;
		}
		return maiorAtual;
	}
	
	
	public static int[] fillArray(int[] vetor, Random r, int vetor_size) {
		
		for(int i = 0; i < vetor_size; i++) {
			vetor[i] = r.nextInt(10);
			System.out.print(vetor[i]+" ");
		}
		
		return vetor;
	}
	
	
	public static void main(String[]args) {
		Random r = new Random();
		Scanner s = new Scanner(System.in); 
		
		System.out.println("Digite o tamanho do vector:");
		int vetor_size = Integer.parseInt(s.nextLine());
		int[] vetor = new int[vetor_size];
		s.close();
		fillArray(vetor, r, vetor_size);
		System.out.println("\nMaior: ");
		System.out.println(buscaMaior(vetor, vetor[0], 1));
	}
}
