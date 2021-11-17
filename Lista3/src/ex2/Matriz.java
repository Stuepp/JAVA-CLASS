package ex2;

import java.util.ArrayList;

public class Matriz {
	//atributos
	private ArrayList<ArrayList<T>> tlist = new ArrayList<ArrayList<T>>();
	private int n,m;
	//Construtor
	Matriz(int n, int m){
		this.n = n;
		this.m = m;
		System.out.println("Meu tamanho:"+n+"x"+m);
	}
	//métodos
	public boolean set(T obj, int row, int col) {
		if(row > n || col > m) {
			return false;
		}
		System.out.println("oi");
		if(tlist.get(row).size() == 0) {
			ArrayList<T> coluna = new ArrayList<T>();
			coluna.add(obj);
			tlist.add(coluna);
			return true;
		}else {
			tlist.get(row).add(obj);
			return true;
		}
	}
	public T get(int i, int j) {
		if(i > n || j > m || i > tlist.size() || j > tlist.get(i).size()) {
			return null;
		}else{
			return tlist.get(i).get(j);
		}
	}
	public ArrayList<T> getLinha(int linha){
		ArrayList<T> row = new ArrayList<T>();
		for(int j = 0; j < tlist.get(linha).size(); j++) {
			row.add(tlist.get(linha).get(j));
		}
		return row;
	}
	public ArrayList<T> getColuna(int coluna){
		ArrayList<T> col = new ArrayList<T>();
		for(int i = 0; i < tlist.size(); i++) {
			col.add(tlist.get(i).get(coluna));
		}
		return col;
	}
}
