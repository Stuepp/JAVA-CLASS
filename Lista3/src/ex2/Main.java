package ex2;

import java.util.Scanner;

public class Main {
	private static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Digite o tamanho da matriz");
		int n = Integer.parseInt(s.nextLine());
		int m = Integer.parseInt(s.nextLine());
		Matriz matriz = new Matriz(n,m);
		T t = new T();
		t.setX(1);
		matriz.set(t, 1, 1);
		//System.out.println(matriz.get(0, 0));
	}

}
