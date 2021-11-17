package ex4;

import java.util.ArrayList;

public class Equipe {
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	private String nome;

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		String salunos = "";
		for(int i = 0; i < alunos.size(); i++) {
			salunos += "\t"+alunos.get(i)+"\n";
		}
		return "Nome da equipe: "+nome
				+"\nAlunos:\n"+salunos;
	}
}
