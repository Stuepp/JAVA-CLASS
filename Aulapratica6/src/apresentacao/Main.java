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
}
