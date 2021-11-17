package lista1.exercicios;

import java.util.Scanner;

public class Lex5 {
	public static int[] vogais(String msg) {
		msg = msg.toLowerCase();//tem diferença na tabela ascii caixa alto e baixa
		int indice = 0;
		boolean vogal = false, space = false;
		int[] nvc = {0,0};//número de vogais e conssoantes
		char[] Charmsg = msg.toCharArray();
		int[] vogais = {97,101,105,111,117}; //decimal -> aeiou
		while(indice < msg.length()) {
			for(int i = 0; i < vogais.length; i++) {
				if(Charmsg[indice] == 32) {
					space = true;
				}else if(Charmsg[indice] == vogais[i]) {
					vogal = true;
					nvc[0]++;
				}
			}
			if(vogal != true && space != true) {
				nvc[1]++;
			}
			vogal = false;
			space = false;
			indice++;
		}
		return nvc;
	}
	public static boolean isPalindromo(String msg) {
		msg = msg.toLowerCase();
		char[] Charmsg = msg.toCharArray();
		char[] msgBW = Charmsg;
		int indice = 0;
		while(indice < msg.length()) {
			if(msgBW[indice] != Charmsg[(Charmsg.length-1)-indice]) {
				return false;
			}
			indice++;
		}
		
		return true;
	}
	
	public static void main(String[]args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Digite uma mensagem:");
		String msg = s.nextLine();
		int[] nvc = vogais(msg);
		if(isPalindromo(msg) == true) {
			System.out.println("É um palindromo");
		}else {
			System.out.println("Não é um palindromo");
		}
		System.out.println("Número de vogais: "+nvc[0]);
		System.out.println("Número de conssoantes: "+nvc[1]);
		s.close();
	}
}
