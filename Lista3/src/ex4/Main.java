package ex4;

import java.util.Scanner;

public class Main {
	private static Scanner s = new Scanner(System.in);
	private static Turma turma = new Turma();
	
	public static void main(String[] args) {
		int menu = 0;
		while(menu == 0) {
			addAluno();
			showAlunos();
			System.out.println("Deseja continua?"
					+ "\n(0)Sim\n(1)Não");
			menu = Integer.parseInt(s.nextLine());
		}

	}
	public static void addAluno() {
		Aluno aluno = new Aluno();
		System.out.println("Nome:");
		aluno.setNome(s.nextLine());
		System.out.println("Idade:");
		aluno.setIdade(Integer.parseInt(s.nextLine()));
		for(int i = 0; i < 5; i++) {
			System.out.println("Nota "+i+":");
			aluno.addNota(Float.parseFloat(s.nextLine()));
		}
		turma.addAluno(aluno);
	}
	public static void showAlunos() {
		for(int i = 0; i < turma.getAlunos().size();i++) {
			System.out.println(turma.getAlunos().get(i).toString());
		}
	}
}
