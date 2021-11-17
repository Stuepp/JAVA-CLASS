package lista1.exercicios;

import java.util.Scanner;

public class Lex4 {
	
	public static float expo(float expoente, float x) {//ok
		float result = x;
		if(x == 1) {
			return 1;
		}
		if(x == 0 & expoente == 0) {
			System.out.println("Indefinido");
			return 0;
		}
		if(expoente < 0) {
			expoente = expoente * (-1);
			while(expoente > 1) {
					result = result * x;
					expoente--;
			}
			return (1f/result);
		}
		if(expoente > 0) {
			while(expoente > 1) {
				result = result * x;
				expoente--;
			}
			return result;
		}
		
		return 1;
	}
	public static float resto(float x, float y) {//ok
		int indice = 2;
		float result = y * indice;
		if(x == 0 && y != 0) {
			return 0;
		}
		if(y == 0 && x != 0) {
			System.out.println("Infinito");
			return 0;
		
		}
		if(x == 0 && y == 0) {
			System.out.println("Indefenido");
			return 0;
		}
		if(y == 1) {
			return x;
		}
		if(x == 1) {//a condição de y == 1 já está acima então não vai ter 1/1 aqui
			return y;
		}
		while(x >= result) {
			indice++;
			result = y * indice;
		}
		
		if(x == result) {
			return 0;
		}
		if(x < result) {
			indice--;
			result = y * indice;
			return (x-result);
		}
		
		return 0;
	}
	
	public static void main(String[]args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite um número e seu expoente: (x^y)");
		String msg = s.nextLine();
		String[] splitMsg = msg.split("\\^");
		float x = Float.parseFloat(splitMsg[0]);
		float y = Float.parseFloat(splitMsg[1]);
		System.out.println(x+"^"+y+" = "+expo(y,x));
		
		System.out.println("Digite um número e seu diviso: (x/y)");
		msg = s.nextLine();
		splitMsg = msg.split("\\/");
		x = Float.parseFloat(splitMsg[0]);
		y = Float.parseFloat(splitMsg[1]);
		System.out.println("Resto: "+resto(x,y));
		s.close();		
	}
}
