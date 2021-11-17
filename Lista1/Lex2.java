package lista1.exercicios;

import java.util.Scanner;
import java.util.Random;

public class Lex2 {
	//atributos
	private int[][] m1,m2,mB,mL; // matrizes
	private int col = 0, row = 0;
	private Scanner s = new Scanner(System.in);
	private Random r = new Random();
	//construtor
	public Lex2() {
		
	}
	//métodos
	public void matrix_size() {
		System.out.println("Digite o número de linhas e colunas da matriz");
		row = Integer.parseInt(s.nextLine());
		col = Integer.parseInt(s.nextLine());
		m1 = new int[row][col];//matriz aleatoria 1
		m2 = new int[row][col];//matriz aleatoria 2
		mB = new int[row][col];//matriz de maiores (B biggers)
		mL = new int[row][col];//matriz de menores (L lowers)
	}
	public void fill_matrix() {//preenche as matrizes m1 e m2 enquanto pega os maiores e os menores
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				m1[i][j] = r.nextInt(10);
				m2[i][j] = r.nextInt(10);
				
				if(m1[i][j] > m2 [i][j]) {
					mB[i][j] = m1[i][j];
					if(i == j || i < j) {//se estiver no triângulo superior
						mL[i][j] = 0;
					}else {
						mL[i][j] = m2[i][j];
					}
				}else {
					mB[i][j] = m2[i][j];
					if(i == j || i < j) {//se estiver no triângulo superior
						mL[i][j] = 0;
					}else {
						mL[i][j] = m1[i][j];
					}
				}
			}
		}
	}
	public void print(int[][] matrixN) {
		for(int i = 0; i < col; i++) {
			for(int j = 0; j < row; j++) {
				System.out.print(matrixN[i][j]+" ");
			}
			System.out.println();
		}
	}
	//main
	public static void main(String[]args) {
		Lex2 lex2 = new Lex2();
		lex2.matrix_size();
		lex2.fill_matrix();
		System.out.println("m1:");
		lex2.print(lex2.m1);
		System.out.println("m2:");
		lex2.print(lex2.m2);
		System.out.println("mB");
		lex2.print(lex2.mB);
		System.out.println("mL");
		lex2.print(lex2.mL);
		
	}
}
