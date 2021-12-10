package apresentacao;

import java.util.List;
import dados.*;

public class Main {

	public static void main(String[] args) {
		Gerador gerador;
		List<Integer> resultado;

		//Naturais
		gerador = new Naturais();
		gerador.gerar(10);
		resultado = gerador.getSequencia();
		show("Naturais",resultado);
		//Abundantes
		gerador = new Abundantes();
		gerador.gerar(100);
		resultado = gerador.getSequencia();
		show("Abundantes",resultado);
		//Fibonacci
		gerador = new Fibonacci();
		gerador.gerar(10);
		resultado = gerador.getSequencia();
		show("Fibonacci",resultado);
		//Fatorais
		gerador = new Fatoriais();
		gerador.gerar(10);
		resultado = gerador.getSequencia();
		show("Fatoriais",resultado);
		//Primos
		gerador = new Primos();
		gerador.gerar(10);
		resultado = gerador.getSequencia();
		show("Primos",resultado);
		//Quadrados
		gerador = new Quadrados();
		gerador.gerar(10);
		resultado = gerador.getSequencia();
		show("Quadrados",resultado);
		//Perfeitos
		gerador = new Perfeitos();
		gerador.gerar(30);
		resultado = gerador.getSequencia();
		show("Perfeitos",resultado);
		
		//
        show2(new Abundantes());
        show2(new Fatoriais());
        show2(new Fibonacci());
        show2(new Naturais());
        show2(new Primos());
        show2(new Perfeitos());
        show2(new Quadrados());
        System.out.println();
	}
	public static void show(String tipo,List<Integer> seq) {
		int size = seq.size();
		if(size < 1) {
			System.out.println(tipo+" de "+ size+": {/}");
		}else {
			System.out.println(tipo+" de "+size+":");
			for(int i = 0; i < size; i++) {
				System.out.print(seq.get(i)+", ");
			}
		}
		System.out.println();
	}
	public static void show2(Gerador g) {
		g.gerar(10);
		for(int x : g.getSequencia()) {
			System.out.println(x + " ");
		}
	       System.out.println();
	       //System.out.println("Sortear: " + g.sortear()); bound must be positive
	        System.out.println("Somatorio: " + g.somatorio());
	        System.out.println("Media aritmetica: " + g.mediaAritimetica());
	        System.out.println("Media geometrica: " + g.mediaGeometrica());
	        System.out.println("Variancia: " + g.variancia());
	        System.out.println("Desvio padrão: " + g.desvioPadrao());
	        //System.out.println("Amplitude:" + g.amplitude()); Index: 0, Size: 0
	}
}
