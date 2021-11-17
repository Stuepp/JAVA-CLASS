package exercicio1.aula2.dados;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void create_pessoa(Pessoa p) {
		Random r  = new Random();
		p.setAge(r.nextInt(100));
		p.setHeight(0 + r.nextFloat() * (3 - 0));
		p.setWeight(0 + r.nextFloat() * (300 - 0));
	}
	public static void print_pessoa(Pessoa p) {
		System.out.println("Name: "+ p.getName() +"\nAge: "+ p.getAge()
		+"y\nHeight: "+p.getHeight() +"m\nWeight: "+p.getWeight()
		+"kg\nIMC: "+p.calculate_imc(p.getHeight(), p.getWeight()));
	}
	public static void main(String[]args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Digite o número de pessoas no grupo: ");
		int nPessoas = Integer.parseInt(s.nextLine());
		Grupo g = new Grupo(nPessoas);
		
		for(int i = 0; i < nPessoas; i++) {
			Pessoa p = new Pessoa();
			System.out.println("De um nome a pessoa "+i+": ");
			p.setName(s.nextLine());
			create_pessoa(p);
			g.setPessoa(p);
		}
		for(int i = 0; i < nPessoas; i++) {
			Pessoa p = new Pessoa();
			p = g.getPessoa(i);
			print_pessoa(p);
		}
		s.close();
	}
}
