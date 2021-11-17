package ex1;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static Scanner s;
	private static ArrayList<Pessoa> criancas = new ArrayList<Pessoa>();
	private static ArrayList<Pessoa> adolescentes = new ArrayList<Pessoa>();
	private static ArrayList<Pessoa> jovens = new ArrayList<Pessoa>();
	private static ArrayList<Pessoa> adultos = new ArrayList<Pessoa>();
	private static ArrayList<Pessoa> idosos = new ArrayList<Pessoa>();
	//crianca 1-12, adolescetnes 13-18, jovens 19-25, adultos 26-59, idosos 60..

	public static void main(String[] args) {
		try {
			FileReader in = new FileReader("src/ex1/pessoas.txt");
			s = new Scanner(in);
			while(s.hasNext()) {
				Pessoa pessoa = new Pessoa();
				String line = s.nextLine();
				String[] brokenLine = line.split(",");
				String nome = brokenLine[0];
				String cidade = brokenLine[1];
				int cpf = Integer.parseInt(brokenLine[2]);
				int idade = Integer.parseInt(brokenLine[3]);
				pessoa.setNome(nome);
				pessoa.setCidade(cidade);
				pessoa.setIdade(idade);
				pessoa.setCpf(cpf);
				if(idade < 13) {//uma pessoa pode ter 0 anos para evitar de ficar um fantasma vai ser tratada como uma crinaça
					criancas.add(pessoa);	
				}else if(idade < 19) {
					adolescentes.add(pessoa);
				}else if(idade < 26) {
					jovens.add(pessoa);
				}else if(idade < 60) {
					adultos.add(pessoa);
				}else {
					idosos.add(pessoa);
				}
			}
			System.out.println("1 até 12: crianças");
			showPessoas(criancas);
			System.out.println("13 até 18: adolescentes");
			showPessoas(adolescentes);
			System.out.println("19 até 25: jovens");
			showPessoas(jovens);
			System.out.println("26 até 59: adultos");
			showPessoas(adultos);
			System.out.println("60 ou mais: idosos");
			showPessoas(idosos);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			s.close();
		}
	}
	public static void showPessoas(ArrayList<Pessoa> pessoas) {
		int cont = 0;
		while(cont < pessoas.size()) {
			System.out.println("\t"+pessoas.get(cont).toString());
			cont++;
		}
	}
}
