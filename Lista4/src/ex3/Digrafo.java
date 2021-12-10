package ex3;

import java.util.List;
import java.util.ArrayList;

public class Digrafo {
	//Atributos
	private List<List<Integer>> ma1 = new ArrayList<List<Integer>>();
	//Getters and Setters
	public List<List<Integer>> getMa1() {
		return ma1;
	}
	public void setMa1(List<List<Integer>> ma1) {
		this.ma1 = ma1;
	}
	//Métodos
	public void adicionarVertice() {
		ma1.add(new ArrayList<Integer>());
		for(int i = 0;i < ma1.size(); i++) {
			while(ma1.get(i).size() < ma1.size()) {
				ma1.get(i).add(0);
			}
		}
	}
	public void adicionarAresta(int origem, int destino) {
		ma1.get(destino).set(origem, 1);
		ma1.get(origem).set(destino, 1);
	}
	
	public String toString() {
		String matriz = "";
		for(int i = 0; i < ma1.size(); i++) {
			for(int j = 0; j < ma1.get(i).size(); j++) {
				matriz += ma1.get(i).get(j)+"\t";
			}
			matriz +="\n";
		}
		return matriz;
	}
}
