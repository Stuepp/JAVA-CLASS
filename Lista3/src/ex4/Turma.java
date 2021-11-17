package ex4;

import java.util.ArrayList;
import java.util.Collections;

public class Turma {
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
	public void addAluno(Aluno aluno) {
		alunos.add(aluno);
		int size = alunos.size();
		if(size > 0) {
			ordenarAlunosPorMedia();
		}
		if(size%3==0) {
			
		}
		if(size%4==0) {
			
		}
	}
	private void ordenarAlunosPorMedia() {
		float ant, atual;
		Aluno before = new Aluno();
		for(int i = 1; i < alunos.size();i++) {
			 atual = calculaMedia(alunos.get(i));
			 ant = calculaMedia(alunos.get((i-1)));
			 before = alunos.get((i-1));
			 if(ant < atual) {
				 alunos.remove((i-1));
				 alunos.add(before);
			 }
		}
	}
	private float calculaMedia(Aluno aluno) {
		float media = 0;
		for(int i = 0; i < 5; i++) {
			media += aluno.getNotas().get(i);
		}
		return (media/5);
	}
	public void separarEmEquipes() {
		int max = alunos.size();
		ArrayList<Aluno> equipes = new ArrayList<Aluno>();
		for(int i = 0; i < max; i++) {
			equipes.add(alunos.get(i));
			equipes.add(alunos.get(max));
			max--;
			if(max-i > 3 && equipes.size() == 4) {
				equipes = new ArrayList<Aluno>();
			}
			if(max-i < 4 && (equipes.size() == 4 || equipes.size() == 3)) {
				equipes = new ArrayList<Aluno>();
			}
		}
	}
}
